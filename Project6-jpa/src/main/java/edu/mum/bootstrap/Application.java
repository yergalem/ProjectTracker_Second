package edu.mum.bootstrap;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.ProjectStatus;
import edu.mum.cs544.l01.model.Role;
import edu.mum.cs544.l01.model.Task;
import edu.mum.cs544.l01.model.User;
import edu.mum.cs544.l01.repositoryimpl.ProjectRepositoryImpl;
import edu.mum.cs544.l01.serviceimpl.UserServiceImpl;

public class Application {
	

	public static void main(String[] args) {
		Session session = null;
		Transaction tx = null;
		
		try {
			

		
			//tx = session.beginTransaction();
		
			User usr = new User("running@gmail.com","yergalem","pass", Role.ADMIN);
		    Task tsk = new Task("Hibernate Environment Setup");
		    
		    Project p = new Project("Nuclear Project", new Date(2), new Date(2),"JPA HBM Mastery");
		   // new UserServiceImpl().registerProject(p);
		    p.setProjectLocation("California");
		    List<Task> tsks = new ArrayList<>();
		    List<User> usrs = new ArrayList<>();
		    tsks.add(tsk);
		    usrs.add(usr);
		     //tsk.setProject(p);
		   // p.setUser(usrs);
		    p.setTasks(tsks);
		    p.setProjectStatus(ProjectStatus.COMPLETE);
		     usr.assignTo(tsk); 
			//new UserServiceImpl().registerUser(usr);
			new ProjectRepositoryImpl().registerProject(p);
			
			System.out.println(new ProjectRepositoryImpl().findProjectById( p.getProjectID()).getProjectLocation());
			System.out.println(new ProjectRepositoryImpl().findProjectByLocation("California").get(0).getProjectName() );
			System.out.println(new ProjectRepositoryImpl().findByProjectKeyWord("Calif").getEndDate() );
			
			

		} catch (HibernateException e) {
			System.err.println(e);
			if (tx != null) tx.rollback();
		} finally {
			if (session != null) session.close();
		}
		
		
		
	}

	
}
