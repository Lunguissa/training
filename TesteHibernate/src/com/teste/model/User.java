package com.teste.model;

public class User {
	String username,password;
	boolean priveleges;
	public User(String username, String password, boolean priveleges) {
		super();
		this.username = username;
		this.password = password;
		this.priveleges = priveleges;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean isPriveleges() {
		return priveleges;
	}
	public void setPriveleges(boolean priveleges) {
		this.priveleges = priveleges;
	}
	@Override
	public String toString() {
		return "User [username=" + username + "]";
	}
	
	

}
