package edu.mum.cs544.l01.service;


import java.util.List;

import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.User;


public interface UserService  {

   
    public void registerUser(User user );
    
    public List<User> listVolunteers();
    
	public User findUserById(long id) ;
	
	public List<Project> findUserProjects(long userID);

	public String findVolunteerTasks(long userID) ;
   
}
