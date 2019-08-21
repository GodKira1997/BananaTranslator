package com.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hsbc.bts.dao.UserDAO;
import com.hsbc.bts.models.Role;
import com.hsbc.bts.models.User;

public class UserDAOImpl implements UserDAO {
	private static final String url = "jdbc:derby:C:\\ProjectBugDB;create=true";
	private Connection conn = null;
	
	public UserDAOImpl() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			System.out.println("YES!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void createConnection() {
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void createRole() {
		try {
			createConnection();
			ResultSet res = conn.getMetaData().getTables(null, "APP", "ROLE", null);
			if(res.next())
				System.out.println("TABLE Role ALREADY EXISTS");
			else{
				String sql = "Create table Role(role_id int not null GENERATED ALWAYS AS IDENTITY primary key, role_name varchar(20) not null unique)";
				try {
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.clearParameters();
					if(statement.execute())
						System.out.println("TABLE Role CREATED");
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}

	@Override
	public void createUser() {
		try {
			createConnection();
			ResultSet res = conn.getMetaData().getTables(null, "APP", "USER", null);
			if(res.next())
				System.out.println("TABLE User ALREADY EXISTS");
			else{
				String sql = "Create table Users(user_id int not null GENERATED ALWAYS AS IDENTITY primary key, user_name varchar(20) not null, email varchar(30) not null, password varchar(20) ,role_id int , available int not null,last_login timestamp,FOREIGN KEY (role_id) REFERENCES Role(role_id))";
				try {
					PreparedStatement statement = conn.prepareStatement(sql);
					statement.clearParameters();
					if(statement.execute())
						System.out.println("TABLE User CREATED");
				}
				catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		finally {
			closeConnection();
		}

	}

	@Override
	public void addUser(String email, String name, String roleName) {
		int roleId = 0;
		String sql1 = "Insert into Role(role_name) values (?)";
		String sql2 = "Select role_id from Role where role_name = ?";
		String sql3 = "Insert into User(user_name,email,password,role_id,available) VALUES (?,?,?,?,?)";
		
		createConnection();
		try {
			PreparedStatement statement1 = conn.prepareStatement(sql2);
			statement1.clearParameters();
			statement1.setString(1, roleName);
			ResultSet rs = statement1.executeQuery();
			if(rs.next())
				roleId = rs.getInt("role_id");
			else {
				PreparedStatement statement2 = conn.prepareStatement(sql1);
				statement2.clearParameters();
				statement2.setString(1, roleName);
				int count = statement2.executeUpdate();
				if(count <= 0)
					throw new SQLException();
				else {
					statement1.clearParameters();
					statement1.setString(1, roleName);
					ResultSet rs2 = statement1.executeQuery();
					if(rs.next())
						roleId = rs2.getInt("role_id");
					else
						throw new SQLException();
				}
			}
			
			statement1 = conn.prepareStatement(sql3);
			statement1.clearParameters();
			statement1.setString(1, name);
			statement1.setString(2, email);
			statement1.setString(3, "admin");
			statement1.setInt(4, roleId);
			
			if(roleName.toLowerCase().equals("manager"))
				statement1.setInt(5, 4);
			else if(roleName.toLowerCase().equals("tester"))
				statement1.setInt(5, 2);
			else
				statement1.setInt(5, 1);
			
			int count = statement1.executeUpdate();
			if(count > 0)
				System.out.println("USER INSERTED TO TABLE!");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
	}

	@Override
	public boolean setPassword(String email, String roleName, String password) {
		String sql = "Select roleName from User,Role where User.role_id = Role.role_id AND email = ?";
		String sql2 = "Update User set password = ? where email = ?";
		
		createConnection();
		try {
			PreparedStatement statement1 = conn.prepareStatement(sql);
			statement1.clearParameters();
			statement1.setString(1, email);
			ResultSet rs = statement1.executeQuery();
			if(rs.next()) {
				if(rs.getString("role_name").equals(roleName)) {
					statement1 = conn.prepareStatement(sql2);
					statement1.clearParameters();
					statement1.setString(1, password);
					statement1.setString(2, email);
					int count = statement1.executeUpdate();
					if(count > 0)
						return true;
				}
			}			
		}
		catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		finally {
			closeConnection();
		}
		return false;
	}

	@Override
	public boolean checkUser(String email) {
		String sql = "Select * from User where email = ?";
		
		createConnection();
		try {
			PreparedStatement statement1 = conn.prepareStatement(sql);
			statement1.clearParameters();
			statement1.setString(1, email);
			ResultSet rs = statement1.executeQuery();
			if(rs.next()) {
				return true;
			}			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return false;
	}

	@Override
	public User getUser(String email) {
		String sql = "Select * from User,Role where User.role_id = Role.role_id AND email = ?";
		User user = null;
		
		createConnection();
		try {
			PreparedStatement statement1 = conn.prepareStatement(sql);
			statement1.clearParameters();
			statement1.setString(1, email);
			ResultSet rs = statement1.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("email"), rs.getString("user_name"), rs.getInt("available"), new Role(rs.getInt("User.role_id"), rs.getString("role_name")), rs.getString("last_login"));
			}			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return user;
	}

	@Override
	public User getUser(int userId) {
		String sql = "Select * from User,Role where User.role_id = Role.role_id AND user_id = ?";
		User user = null;
		
		createConnection();
		try {
			PreparedStatement statement1 = conn.prepareStatement(sql);
			statement1.clearParameters();
			statement1.setInt(1, userId);
			ResultSet rs = statement1.executeQuery();
			if(rs.next()) {
				user = new User(rs.getInt("user_id"), rs.getString("email"), rs.getString("user_name"), rs.getInt("available"), new Role(rs.getInt("User.role_id"), rs.getString("role_name")), rs.getString("last_login"));
			}			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return user;
	}

	@Override
	public List<User> getAllUsers(String roleName) {
		String sql1 = "Select role_id from Role where role_name = ?";
		String sql2 = "Select * from User where role_id = ?";
		List<User> userList = new ArrayList<>();
		
		createConnection();
		try {
			PreparedStatement statement1 = conn.prepareStatement(sql1);
			statement1.clearParameters();
			statement1.setString(1, roleName);
			ResultSet rs = statement1.executeQuery();
			if(rs.next()) {
				int roleId = rs.getInt("role_id");
				statement1 = conn.prepareStatement(sql2);
				statement1.clearParameters();
				statement1.setInt(1, roleId);
				ResultSet rs2 = statement1.executeQuery();
				while(rs2.next())
					userList.add(new User(rs2.getInt("user_id"), rs2.getString("email"), rs2.getString("user_name"), rs2.getInt("available"), new Role(roleId, roleName), rs2.getString("last_login")));
			}			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			closeConnection();
		}
		
		return userList;
	}

	@Override
	public void closeConnection() {
		if(conn != null)
		{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
