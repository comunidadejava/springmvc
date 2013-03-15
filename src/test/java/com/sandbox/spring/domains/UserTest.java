package com.sandbox.spring.domains;

import junit.framework.Assert;

import org.junit.Test;

public class UserTest {
	
	@Test
	public void createUser(){
		User usr = new User();
		usr.setAge(31);
		usr.setId(1);
		usr.setLastName("carvalho");
		usr.setName("tiago");
		usr.setAccountId(122);
		
		Assert.assertEquals("name", "tiago", usr.getName());
		Assert.assertEquals("lastname", "carvalho", usr.getLastName());
		Assert.assertEquals("age", 31, usr.getAge());
		Assert.assertEquals("id", 1, usr.getId());
		Assert.assertEquals("accountId", 122, usr.getAccountId());
	}
	
	@Test(expected=AssertionError.class)
	public void createUserFail(){
		User usr = new User();
		usr.setAge(31);
		usr.setId(1);
		usr.setLastName("carvalho");
		usr.setName("tiago");
		usr.setAccountId(122);
		
		Assert.assertEquals("name", "tago", usr.getName());
		Assert.assertEquals("lastname", "carvalho", usr.getLastName());
		Assert.assertEquals("age", 31, usr.getAge());
		Assert.assertEquals("id", 1, usr.getId());
		Assert.assertEquals("accountId", 122, usr.getAccountId());
	}
}
