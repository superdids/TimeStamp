package eu.jeisn.stamp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import eu.jeisn.stamp.models.Project;
import eu.jeisn.stamp.models.User;

public class UserDAO extends DAO<User> {

	public UserDAO() {
		super(User.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<User> readAllByProject(Integer projectId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		List<User> toRet = new ArrayList<>();
		try {
			transaction.begin();
			Query q = manager.createQuery("SELECT t FROM User t join t.participations p WHERE p.participationId.projectId = :projectId");
			q.setParameter("projectId", projectId);
			toRet = q.getResultList();
			transaction.commit();
		} catch(Exception e) {
			System.err.println("[UserDAO]: readAllByProject");
			if(transaction != null) 
				transaction.rollback();
		} finally {
			if(manager != null) 
				manager.close();
		}
		return toRet;
	}
}
