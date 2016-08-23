package edu.mum.cs544.l01.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import edu.mum.cs544.l01.core.CustomEntity;


@Entity
//@Table(indexes = {  @Index(name="email_idx", columnList = "email", unique = true) })
public class User implements Serializable, CustomEntity {
       
    @Id @GeneratedValue
    private long userID;
    private String email;
    private String userName;
    private  String password;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String displayName;
    
    
    public User() {
		
	}   
    public User(String email, String userName, String password, Role role) {
		super();
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
    
    @OneToOne( cascade= CascadeType.ALL)
    private Task task;
    
    //@ManyToMany(mappedBy ="user", cascade= CascadeType.ALL)
    //private List<Project> projects;

    @Column
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(nullable = false, length = 60)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
    @Column(nullable = false)
    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Column(name="display_name")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Column
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getUserID() {
		return userID;
	}

	public void setUserID(long userID) {
		this.userID = userID;
	}
  
    public void assignTo(Task task) {
		
    	this.task = task;
	}
    
    public void getAssignedTasks() {
    	
    }
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
		result = prime * result + (int) (userID ^ (userID >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (role != other.role)
			return false;
		if (userID != other.userID)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

//    @Override
//    public String toString() {
//        return "User{" +
//                "email='" + email + '\'' +
//                ", password='" + password + '\'' +
//                ", role=" + role +
//                ", displayName='" + displayName + '\'' +
//                
//                '}'";
//    }
    
    
}
