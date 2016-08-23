package edu.mum.cs544.l01.serviceimpl;

import java.util.List;

import edu.mum.cs544.l01.core.CRUDEntity;
import edu.mum.cs544.l01.core.CustomEntity;
import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.ProjectStatus;
import edu.mum.cs544.l01.repository.ProjectRepositoryDAO;
import edu.mum.cs544.l01.repositoryimpl.ProjectRepositoryImpl;
import edu.mum.cs544.l01.service.ProjectService;

public class ProjectServiceImpl extends CRUDEntity implements ProjectService {

	ProjectRepositoryDAO projectRepository;
	
	public ProjectServiceImpl() {
		projectRepository = new ProjectRepositoryImpl();
	}
	public void setUp() {
		System.out.println("ProjectRepository Created!");
	}


	public void registerProject(CustomEntity project) {
		
		projectRepository.registerProject(project);
	}
	
	@Override
	public Project findByProjectKeyWord(String ProjectName) {
		return projectRepository.findByProjectKeyWord(ProjectName);
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findTasks(Project parentProject) {
		return projectRepository.findTasks(parentProject);
	}

	@Override
	public ProjectStatus findProjectStatus(long projectID) {
		return projectRepository.findProjectStatus(projectID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findProjectByStatus(ProjectStatus status) {
		return projectRepository.findProjectByStatus(status);
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findProjectByLocation(String loc) {
		
		return projectRepository.findProjectByLocation(loc);
	}

	@Override
	public Project findProjectById(long id) {
		return projectRepository.findProjectById(id);
	}
	
	
}
