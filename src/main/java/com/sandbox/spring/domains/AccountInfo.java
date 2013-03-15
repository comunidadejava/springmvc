package com.sandbox.spring.domains;

import java.math.BigDecimal;

/**
 * Account Information
 * @author neo
 */

public class AccountInfo {
	private int id;
	private User user;
	private BigDecimal balance;
	
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public BigDecimal getBalance() {
		return this.balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	
	@Override
	public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fieldNames name="); 
        sb.append("'").append(id).append("', ");
        sb.append("'").append(user.toString()).append("', ");
        sb.append("'").append(balance).append("', ");
        return sb.toString();
	}
}
