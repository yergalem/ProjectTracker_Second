package edu.mum.cs544.l01.model;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Volunteer extends User {
	

	public Volunteer() {
		
	}
	private String assignedTo;
	private String serviceDescription;
	
	
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String projectID) {
		this.assignedTo = projectID;
	}
	public String getServiceDescription() {
		return serviceDescription;
	}
	public void setServiceDescription(String serviceDescription) {
		this.serviceDescription = serviceDescription;
	}
	
	
	
    
}
