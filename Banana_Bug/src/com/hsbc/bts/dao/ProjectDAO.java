package com.hsbc.bts.dao;

import java.util.List;

import com.hsbc.bts.models.Project;

public interface ProjectDAO {
	void createConnection();
	void createProject();
	void addProject(String name,String date,int userId); //Manager UserId
	void assignProject(int userId,int projectId);
	List<Project> getAllProjects(int userId);
	void updateStatus(int projectId,String status);
	void closeConnection();
}
