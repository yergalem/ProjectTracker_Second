package edu.mum.cs544.l01.repositoryimpl;

import java.util.List;

import edu.mum.cs544.l01.core.CRUDEntity;
import edu.mum.cs544.l01.core.CustomEntity;
import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.Role;
import edu.mum.cs544.l01.model.User;
import edu.mum.cs544.l01.repository.UserRepositoryDAO;

public class UserRepositoryImpl extends CRUDEntity implements UserRepositoryDAO{

   public UserRepositoryImpl() {
	  		
	  setupEntityClass(User.class);
		
   }
		
	public void setUp() {
		System.out.println("ProjectRepository Created!");
	}



	@Override
	public void registerUser(CustomEntity user) {
		
		insert(user);
	}

	@Override
	public User findUserById(long id) {
		
		return (User) findById(id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findUserProjects(long userID) {
		return  sessionFactory.getCurrentSession()
				.createQuery("from User u INNER JOIN Project p WHERE u.userID =:p.projectID")
				.setParameter("Projects", userID).list();
		
	}

	@Override
	public String findVolunteerTasks(long userID) {
		
		return null;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listVolunteers() {
		return  session.createQuery("from User u  WHERE u.role =:usrRole")
				.setParameter("usrRole", Role.VOLUNTEER).list();
	}

	

}
