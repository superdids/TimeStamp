package eu.jeisn.stamp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.jinq.jpa.JinqJPAStreamProvider;
import org.jinq.orm.stream.JinqStream;

public class DAO<T> {

	protected Class<T> className;
	protected EntityManagerFactory factory;
	protected JinqJPAStreamProvider streams;
	
	public DAO(Class<T> className) {
		this.className = className;
		factory = ContextListener.getFactory();
		streams = new JinqJPAStreamProvider(factory);
	}
	
	public boolean exists(Object id) {
		return read(id) != null;
	}
	
	public T create(T item) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();

		try {
			transaction.begin();
			manager.persist(item);
			transaction.commit();
		} catch(Exception e) {
			System.err.println("[" + className.getName() + "DAO]: create");
			item = null;
			if(transaction != null) 
				transaction.rollback();
		} finally {
			if(manager != null) 
				manager.close();
		}
		return item;
	}

	public T read(Object id) {
		EntityManager manager = factory.createEntityManager();
		T item = null;

		try {
			item = manager.find(className, id);
		} catch(Exception e) {
			System.err.println("[" + className.getName() + "DAO]: read");
		} finally {
			if(manager != null) 
				manager.close();
		}
		return item;
	}
	
	@SuppressWarnings("unchecked")
	public List<T> readAll() {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		List<T> toRet = new ArrayList<>();
		try {
			transaction.begin();
			Query q = manager.createQuery("SELECT t FROM " + className.getName() + " t");
			toRet = q.getResultList();
			transaction.commit();
		} catch(Exception e) {
			System.err.println("[ProjectDAO]: readAll");
			if(transaction != null) 
				transaction.rollback();
		} finally {
			if(manager != null) 
				manager.close();
		}
		return toRet;
	}
	
	public JinqStream<T> getStream() {
		return streams.streamAll(factory.createEntityManager(), className);
	}
	
}
