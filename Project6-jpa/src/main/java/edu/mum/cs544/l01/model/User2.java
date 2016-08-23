package edu.mum.cs544.l01.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User2 {

    public User2() {
    }

    @Id @GeneratedValue
    private long userID;

    private String email;

    private String password;

    private String firstName;

    private String lastName;

    private String biography;

    private String phone;

    private byte profilePicture;



    public List<User2> getUsers() {
      
        return null;
    }

    public void getUserByID( long userID) {
       
    }

}