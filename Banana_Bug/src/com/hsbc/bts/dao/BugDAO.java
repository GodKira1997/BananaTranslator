package com.hsbc.bts.dao;

import java.util.List;

import com.hsbc.bts.models.Bug;
import com.hsbc.bts.models.Project;

public interface BugDAO {
	void createConnection();
	void createBug();
	void addBug(String title, String description, Project project, int userId, String openDate,String severityLevel);
	List<Bug> getAllBugs(int projectId);
	void assignBug(int userId,int bugId);
	void markByDev(int userId,int bugId);
	void confirmClose(int userId,int bugId);
	void closeConnection();
}
