package edu.mum.cs544.l01.model;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import edu.mum.cs544.l01.core.CustomEntity;

@Entity
@Access(AccessType.FIELD)
public class Project implements CustomEntity {

    public Project() {
    }
       

    public Project(String name, Date startDate, Date endDate, String projectDescription) {
		this.projectName = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.projectDescription = projectDescription;
	}




    public void addDescription() {
                
    }

    public String getDescription() {
        
        return "";
    }

    public void registerStartDate(LocalDate start) {
      
        
    }

    public void registerEndDate( LocalDate end) {
        
        
    }

    public String getProjectDescription(long projectID) {
        
        return "";
    }

    
    
	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public String getProjectDescription() {
		return projectDescription;
	}


	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}


//	public List<User> getUser() {
//		return user;
//	}
//
//
//	public void setUser(List<User> user) {
//		this.user = user;
//	}


	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	   
	public long getProjectID() {
		return projectID;
	}


	public void setProjectID(int projectID) {
		this.projectID = projectID;
	}    

	@Override
	public String toString() {
		return "Project [projectDescription=" + projectDescription + "]";
	}

	

    public ProjectStatus getProjectStatus() {
		return projectStatus;
	}


	public void setProjectStatus(ProjectStatus projectStatus) {
		this.projectStatus = projectStatus;
	}


	public void setProjectID(long projectID) {
		this.projectID = projectID;
	}
	
	

//	public boolean isRequireResource() {
//		return resourceCapacity < user.size();
//	}
	
	public String getProjectLocation() {
		return projectLocation;
	}


	public void setProjectLocation(String projectLocation) {
		this.projectLocation = projectLocation;
	}


	public String getProjectName() {
		return projectName;
	}


	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}



	@Id @GeneratedValue    
    private long projectID;
    
	@Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    private String projectDescription;
    
    private String projectLocation;
    private String projectName;
    
    
    @OneToMany( mappedBy="project",cascade=CascadeType.ALL)
    List<Task> tasks;
    
    //@ManyToMany(cascade=CascadeType.ALL)
    //private List<User> user;
    
    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;
    
    private int resourceCapacity = 2;
    
    @Transient
    boolean requireResource;

    
}