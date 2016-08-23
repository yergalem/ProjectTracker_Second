package edu.mum.projecttracker.unitest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import edu.mum.cs544.l01.model.Role;
import edu.mum.cs544.l01.model.User;
import edu.mum.cs544.l01.service.UserService;
import edu.mum.cs544.l01.serviceimpl.UserServiceImpl;

public class UserTest {

	UserService srvc = new UserServiceImpl();
	User usr = new User("frank@gmail.com","frank","pass", Role.ADMIN);
	User uv1 = new User("Yergalem@gmail.com","yergalem","pass", Role.VOLUNTEER);
	User uv2 = new User("Yonas@gmail.com","YOnas","pass", Role.VOLUNTEER);
	
	public UserTest() {
	   		
		srvc.registerUser(usr);
		srvc.registerUser(uv1);
		srvc.registerUser(uv2);
	}
	
	@Test
	public void testFindUserById() {
		
		assertEquals("frank@gmail.com", srvc.findUserById( usr.getUserID()).getEmail() );
	}
	
	@Test
	public void testVolunteerList() {

		List<User> usrLst = Arrays.asList(uv1, uv2);

		assertThat(usrLst, is(srvc.listVolunteers()));
		
	}
	
	
	

}
