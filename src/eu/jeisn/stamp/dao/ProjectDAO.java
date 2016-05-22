package eu.jeisn.stamp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import eu.jeisn.stamp.models.Project;


public class ProjectDAO extends DAO<Project> {

	public ProjectDAO() {
		super(Project.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Project> readAllByUser(String userName) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		List<Project> toRet = new ArrayList<>();
		try {
			transaction.begin();
			Query q = manager.createQuery("SELECT t FROM Project t join t.participations p WHERE p.participationId.userId = :name");
			q.setParameter("name", userName);
			toRet = q.getResultList();
			transaction.commit();
		} catch(Exception e) {
			System.err.println("[ProjectDAO]: readAllByUser");
			if(transaction != null) 
				transaction.rollback();
		} finally {
			if(manager != null) 
				manager.close();
		}
		return toRet;
	}
}