package com.hsbc.bts.dao;

import java.util.List;

import com.hsbc.bts.models.User;

public interface UserDAO {
	void createConnection();
	void createRole();
	void createUser();
	void addUser(String email,String name,String roleName);
	boolean setPassword(String email,String roleName,String password);
	boolean checkUser(String email);
	User getUser(String email);
	User getUser(int userId);
	List<User> getAllUsers(String roleName);
	void closeConnection();
}
