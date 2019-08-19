package com.hsbc.bts.models;

public class Project {
	private int projectId;
	private int name;
	private int status;
	private String date; //Edit as per your need
	
	public Project() {
		super();
	}

	public Project(int name, int status, String date) {
		super();
		this.name = name;
		this.status = status;
		this.date = date;
	}

	public Project(int projectId, int name, int status, String date) {
		super();
		this.projectId = projectId;
		this.name = name;
		this.status = status;
		this.date = date;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", status=" + status + ", date=" + date + "]";
	}
	
}
