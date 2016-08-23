package edu.mum.cs544.l01.serviceimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import edu.mum.cs544.l01.database.DataAccess;
import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.User;
import edu.mum.cs544.l01.repositoryimpl.UserRepositoryImpl;
import edu.mum.cs544.l01.service.UserService;

public class UserServiceImpl implements UserService {

	UserRepositoryImpl userRepository;
	
	public UserServiceImpl() {
		userRepository = new UserRepositoryImpl() ;
	}
	
	
	@Override
	public void registerUser(User user ) {
		
		//authenticate
		userRepository.registerUser(user);
		
	  
	}
	
	
	public void registerProject(Project user ) {
		Session session = DataAccess.getSession();
		session.beginTransaction();
		session.persist(user);
		session.getTransaction().commit();
		session.close();
	  
	}


	@Override
	public List<User> listVolunteers() {
		return userRepository.listVolunteers();
	}


	@Override
	public User findUserById(long id) {
		return userRepository.findUserById(id);
	}


	@Override
	public List<Project> findUserProjects(long userID) {
		return userRepository.findUserProjects(userID);
	}


	@Override
	public String findVolunteerTasks(long userID) {
		return userRepository.findVolunteerTasks(userID);
	}

	

	

}
