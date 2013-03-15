package com.sandbox.spring.models;

import java.util.ArrayList;
import java.util.List;

import com.sandbox.spring.domains.User;

public class UsersModel implements IModel<User> {

	@Override
	public User getById(int id) {
		User user = buildUser();
		return user;
	}

	@Override
	public User save(User domainData) {
		domainData.setId(222); //pretend we are saving
		return domainData;
	}

	@Override
	public void delete() {
		// TODO Auto-generated method stub
	}

	@Override
	public List<User> getAll() {
		List<User> usrList = new ArrayList<User>(2);
		usrList.add(this.buildUser());
		usrList.add(this.buildUser());
		usrList.add(this.buildUser());
		return usrList;
	}
	
	//static data sake
	private User buildUser() {
		User user = new User();
		user.setAge(31);
		user.setId(1);
		user.setLastName("carvalho");
		user.setName("tiago");
		user.setAccountId(122);
		return user;
	}
	
}
