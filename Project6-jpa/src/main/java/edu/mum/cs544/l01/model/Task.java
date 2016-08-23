package edu.mum.cs544.l01.model;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import edu.mum.cs544.l01.core.CustomEntity;

@Entity
@Access(AccessType.FIELD)
public class Task implements CustomEntity{

    public Task() {
    }

    public Task(String content) {
		super();
		this.content = content;
	}

	@Id @GeneratedValue
    private long taskID;

    private String content;
    @ManyToOne(cascade=CascadeType.ALL)
    private Project project;
    
//    @Transient
//    private List<Task> tasks = new ArrayList<>();
//
//	
//    
//    public void	 addTask( Task tsk) {
//		
//    	tasks.add(tsk);
//	}
//
//
//	public List<Task> getTasks() {
//		return tasks;
//	}


	public Project getProject() {
		return project;
	}


	public void setProject(Project project) {
		this.project = project;
	}

	public long getTaskID() {
		return taskID;
	}

	public void setTaskID(long taskID) {
		this.taskID = taskID;
	}
    
    
	

}