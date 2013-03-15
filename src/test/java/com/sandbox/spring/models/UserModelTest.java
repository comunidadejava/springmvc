package com.sandbox.spring.models;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;

import com.sandbox.spring.domains.User;

public class UserModelTest {
	
	@Test
	public void getUserById(){
		IModel<User> userModel = new UsersModel();
		User usr = userModel.getById(1); 
		
		Assert.assertEquals("name", "tiago", usr.getName());
		Assert.assertEquals("lastname", "carvalho", usr.getLastName());
		Assert.assertEquals("age", 31, usr.getAge());
		Assert.assertEquals("id", 1, usr.getId());
		Assert.assertEquals("accountId", 122, usr.getAccountId());
	}
	
	@Test
	public void getAllUsers(){
		IModel<User> userModel = new UsersModel();
		List<User> lUser = userModel.getAll(); 
		Assert.assertEquals(3, lUser.size());
		
		User usr = lUser.get(0); //get the one!
		
		Assert.assertEquals("name", "tiago", usr.getName());
		Assert.assertEquals("lastname", "carvalho", usr.getLastName());
		Assert.assertEquals("age", 31, usr.getAge());
		Assert.assertEquals("id", 1, usr.getId());
		Assert.assertEquals("accountId", 122, usr.getAccountId());
	}
}
