package com.hsbc.bts.models;

public class User {
	private String email;
	private String name;
	private String password;
	private int available;
	private Role role;
	private String timestamp;
	
	public User() {
		super();
	}

	public User(String email, String name, int available, Role role) {
		super();
		this.email = email;
		this.name = name;
		this.available = available;
		this.role = role;
		this.password = null;
		this.timestamp = null;
	}

	public User(String email, String name, int available, Role role, String timestamp) {
		super();
		this.email = email;
		this.name = name;
		this.available = available;
		this.role = role;
		this.timestamp = timestamp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTimestamp() {
		return timestamp;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", available=" + available + ", role=" + role
				+ ", timestamp=" + timestamp + "]";
	}
	
}
