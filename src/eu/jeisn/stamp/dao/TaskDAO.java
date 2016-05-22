package eu.jeisn.stamp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import eu.jeisn.stamp.models.Task;

public class TaskDAO extends DAO<Task> {
	
	public TaskDAO() {
		super(Task.class);
	}
	
	@SuppressWarnings("unchecked")
	public List<Task> readAllByUserProject(String userId, Integer projectId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		List<Task> tasks = new ArrayList<>();
		try {
			transaction.begin();
			String userTasks = "SELECT t FROM Task t WHERE t.user.userName = :userId";
			String projectTasks = "SELECT t FROM Task t WHERE t.project.id = :projectId";
			Query q = manager.createQuery(userTasks + " INTERSECT " + projectTasks);
			q.setParameter("userId", userId);
			q.setParameter("projectId", projectId);
			tasks = q.getResultList();
			transaction.commit();
		} catch(Exception e) {
			System.err.println("[TaskDAO]: taskByUserProject");
			if(transaction != null) {
				transaction.rollback();
			}
		} finally {
			if(manager != null) {
				manager.close();
			}
		}
		
		
		return tasks;
	}
}
