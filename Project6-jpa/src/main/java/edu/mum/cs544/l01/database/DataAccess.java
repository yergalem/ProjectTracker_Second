package edu.mum.cs544.l01.database;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//public class DataAccess {
//
//	private static SessionFactory sessionFactory;
//	private static Session session;
//	
//
//	public static void setUpSession() {
//
//		Configuration configuration = new Configuration();
//
//		// This step will read hibernate.cfg.xml
//		sessionFactory = configuration.configure().buildSessionFactory();
//		session = sessionFactory.openSession();;
//
//	}
//
//	public static Session getSession() {
//		setUpSession();
//		
//		return session;
//	}
//	
//	public static SessionFactory getSessionFactory() {
//		setUpSession();
//		return sessionFactory;
//	}
//
//	// if (!sessionFactory.isClosed()) {
//	// sessionFactory.close();
//	// }
//
//}


public class DataAccess {

	private static DataAccess instance = new DataAccess();

	private static SessionFactory sessionFactory;

	private DataAccess(){
	    this.sessionFactory = buildSessionFactory();
	}

	private synchronized static SessionFactory buildSessionFactory() {
	    return new Configuration().configure().buildSessionFactory();
	}

	public static DataAccess getInstance() {
	    if(instance == null){
	        return new DataAccess();
	    }
	    return instance;
	}

	public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	}

	public static Session getSession() {
	    return sessionFactory.openSession();
	}
	
}
