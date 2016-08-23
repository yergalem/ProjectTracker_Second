package edu.mum.cs544.l01.repository;


import java.util.List;

import org.hibernate.SessionFactory;

import edu.mum.cs544.l01.core.CustomEntity;
import edu.mum.cs544.l01.database.DataAccess;
import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.ProjectStatus;
import edu.mum.cs544.l01.model.User;


public interface ProjectRepositoryDAO  {
	
  
    public Project findByProjectKeyWord(String ProjectName);

   
    public ProjectStatus findProjectStatus( long projectID );

  
    public List<Project> findTasks(Project parentProject);
    
    public List<Project> findProjectByStatus(ProjectStatus status);
    
    public List<Project> findProjectByLocation(String loc);
    
    public void registerProject(CustomEntity project);
    
    public Project findProjectById(long id) ;
    
}
