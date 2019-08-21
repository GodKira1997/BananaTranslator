package com.hsbc.bts.dao;

import java.util.List;

import com.hsbc.bts.models.Bug;
import com.hsbc.bts.models.Project;

public interface ProjectDAO {
	void createConnection();
	
	void createProject();
	void addProject(String name,String date,int userId); //Manager UserId
	void assignProject(int userId,int projectId);
	List<Project> getAllProjects(int userId);
	void updateStatus(int projectId,String status);
	
	void createBug();
	void addBug(String title, String description, Project project, int userId, String openDate,String severityLevel);
	List<Bug> getAllBugs(int projectId);
	void assignBug(int userId,int bugId);
	void markByDev(int userId,int bugId);
	void confirmClose(int userId,int bugId);
	
	void closeConnection();
}
