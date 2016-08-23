package edu.mum.cs544.l01.repository;

import java.util.List;

import edu.mum.cs544.l01.core.CustomEntity;
import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.User;

public interface UserRepositoryDAO {

	void registerUser(CustomEntity user);
	
	public User findUserById(long id);

	   
    public List<Project> findUserProjects(long userID);

  
    public String findVolunteerTasks(long userID);
    
    public List<User> listVolunteers();
    

}
