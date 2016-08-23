package edu.mum.cs544.l01.serviceimpl;

import javax.persistence.Entity;
import javax.persistence.Inheritance;

import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.Task;
import edu.mum.cs544.l01.serviceimpl.UserServiceImpl;


@Entity
public class TaskManager   {

    UserServiceImpl userService;
    
    
    public TaskManager() {
		 userService = new UserServiceImpl();
	}
	
	public void updateProjectStatus() {
		
	}
	
	public void addTask(Task tsk, Project project) {
		
		//project.registerTask(tsk);
	}
	
	public void addProject(Project project) {
		
	}
	
	public void manageUsers() {
		
	}
}

