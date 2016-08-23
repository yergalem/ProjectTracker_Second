package edu.mum.projecttracker.unitest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import edu.mum.cs544.l01.model.Project;
import edu.mum.cs544.l01.model.ProjectStatus;
import edu.mum.cs544.l01.model.User;
import edu.mum.cs544.l01.service.ProjectService;
import edu.mum.cs544.l01.serviceimpl.ProjectServiceImpl;

public class ProjectTrackerTest {

	ProjectService srvc = new ProjectServiceImpl();
	Project p = new Project("Nuclear Science", new Date(2), new Date(24),"JPA HBM Mastery");
	
	public ProjectTrackerTest() {
	   
		p.setProjectLocation("California");
		
		srvc.registerProject(p);
	}
	
	@Test
	public void testFindProjectById() {
		
		assertEquals("California", srvc.findProjectById( p.getProjectID()).getProjectLocation() );
	}
	
	@Test
	public void testProjectStatus() {

		assertEquals(ProjectStatus.COMPLETE, srvc.findProjectStatus(p.getProjectID()) );
	}
	
	@Test
	public void testfindProjectByLocation() {
		
		assertEquals("California", srvc.findProjectById( p.getProjectID()).getProjectLocation() );
	}
	
	@Test
	public void testfindProjectByKeyWord() {
		
		assertEquals("California", srvc.findByProjectKeyWord( "Nuclear").getProjectLocation() );
	}
	
	@Test
	public void testProjectsPerStatus() {

		List<Project> projLst = Arrays.asList(p);
		assertThat( projLst, is(srvc.findProjectByStatus(ProjectStatus.COMPLETE)));
		
	}

}
