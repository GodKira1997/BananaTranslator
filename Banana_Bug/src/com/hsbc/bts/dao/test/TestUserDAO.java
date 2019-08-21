package com.hsbc.bts.dao.test;

import com.hsbc.bts.dao.UserDAO;
import com.hsbc.bts.dao.impl.UserDAOImpl;

public class TestUserDAO {

	public static void main(String[] args) {
		UserDAO dao = new UserDAOImpl();
		
		dao.addUser("dsasad", "fdsfsdfs", "manager");
	}

}
