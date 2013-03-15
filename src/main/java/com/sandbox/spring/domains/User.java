package com.sandbox.spring.domains;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * class user domain model
 * @author neo
 */
@XmlRootElement(name = "user")
public class User {
	
	private int id = 0;
	
	@Min(21)
	private int age = 0;
	
	private int accountId = 0;
	
	@NotNull
	private String name = null;
	@NotNull
	private String lastName = null;

	public int getId() {
		return this.id;
	}
	
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return this.age;
	}
	@XmlElement
	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return this.name;
	}
	
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@XmlElement
	public int getAccountId() {
		return this.accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	
	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fieldNames name="); 
        sb.append("'").append(id).append("', ");
        sb.append("'").append(age).append("', ");
        sb.append("'").append(accountId).append("', ");
        sb.append("'").append(name).append("', ");
        sb.append("'").append(lastName).append("', ");
        return sb.toString();
	}
}
