package com.hsbc.bts.services;

import java.util.List;

import com.hsbc.bts.models.Bug;
import com.hsbc.bts.models.Project;

public interface ProjectService {
	void storeProject(String name,String date,int userId); //Manager UserId
	void assignDeveloper(int userId,int projectId);
	void assignTester(int userId,int projectId);
	List<Project> displayAllProjects(int userId);
	void setStatus(int projectId,String status);
	
	//Tester userId
	void setBug(String title, String description, Project project, int userId, String openDate,String severityLevel);
	List<Bug> displayAllBugs(int projectId);
	void assignToDev(int userId,int bugId);
	void markCloseByDev(int userId,int bugId);
	void closeBug(int userId,int bugId);
}
