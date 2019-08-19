package com.hsbc.bts.services;

import com.hsbc.bts.models.User;

public interface LoginService {
	int login(String email,String password); //returns userId
	User getUserDetails(String email);
	User getUserDetails(int userId);
}
