package com.hsbc.bts.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.hsbc.bts.dao.ProjectDAO;
import com.hsbc.bts.models.Bug;
import com.hsbc.bts.models.Project;

public class ProjectDAOImpl implements ProjectDAO {
	private static final String url = "jdbc:derby:C:\\ProjectBugDB;create=true";
	private Connection conn = null;
	
	public ProjectDAOImpl() {
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
	public void createProject() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addProject(String name, String date, int userId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void assignProject(int userId, int projectId) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Project> getAllProjects(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatus(int projectId, String status) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createBug() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addBug(String title, String description, Project project, int userId, String openDate,
			String severityLevel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Bug> getAllBugs(int projectId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void assignBug(int userId, int bugId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void markByDev(int userId, int bugId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmClose(int userId, int bugId) {
		// TODO Auto-generated method stub
		
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
