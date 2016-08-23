package edu.mum.cs544.l01.service;

import java.util.List;

import edu.mum.cs544.l01.core.CustomEntity;
import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.ProjectStatus;

public interface ProjectService {

	public Project findByProjectKeyWord(String ProjectName);

	   
    public ProjectStatus findProjectStatus( long projectID);

  
    public List<Project> findTasks(Project parentProject);
    
    public List<Project> findProjectByStatus(ProjectStatus status);
    
    public List<Project> findProjectByLocation(String loc);
    
	public Project findProjectById(long id) ;
	
	public void registerProject(CustomEntity project);
}
