package edu.mum.cs544.l01.repositoryimpl;

import java.util.List;

import edu.mum.cs544.l01.core.CRUDEntity;
import edu.mum.cs544.l01.core.CustomEntity;
import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.ProjectStatus;
import edu.mum.cs544.l01.model.User;
import edu.mum.cs544.l01.repository.ProjectRepositoryDAO;

public class ProjectRepositoryImpl extends CRUDEntity implements ProjectRepositoryDAO {

	public ProjectRepositoryImpl() {
		
        setupEntityClass(Project.class);
	}
	public void setUp() {
		System.out.println("ProjectRepository Created!");
	}


	public void registerProject(CustomEntity project) {
		
		insert(project);
	}
	
	
	@Override
	public Project findProjectById(long id) {
		return  (Project) findById(id);
	}
	
	@Override
	public Project findByProjectKeyWord(String searchKeyWord) {
		return (Project) session.createQuery("from Project c where lower(c.projectName) LIKE lower(:searchKeyWord)")
				.setParameter("searchKeyWord", searchKeyWord).uniqueResult();
	}

	

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findTasks(Project parentProject) {
		return (List<Project>) session.createQuery("from Project c where c.tasks = :tasks")
				.setParameter("tasks", parentProject).list();
	}

	@Override
	public ProjectStatus findProjectStatus(long projectID) {
		return (ProjectStatus) session.createQuery("SELECT p.projectStatus from Project p where p.projectID = :ProjectID")
				.setParameter("ProjectID", projectID).uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findProjectByStatus(ProjectStatus status) {
		return (List<Project>) session.createQuery("SELECT DISTINCT c from Project c where c.projectStatus = :status")
				.setParameter("status", status).list();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Project> findProjectByLocation(String loc) {
		
		return (List<Project>) session.createQuery("from Project c where c.projectLocation = :location")
				.setParameter("location", loc).list();
	}


	
	
}
