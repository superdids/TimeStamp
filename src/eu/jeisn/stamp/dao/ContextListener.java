package eu.jeisn.stamp.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;



/**
 * Application Lifecycle Listener implementation class ContextListener
 *
 */

public class ContextListener implements ServletContextListener {

   private static EntityManagerFactory factory;
	
    public ContextListener() {
        
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		factory.close();
		
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		factory = Persistence.createEntityManagerFactory("Stamp");
		
	}
	
	public static EntityManagerFactory getFactory() {
		return factory;
	}
	
} 