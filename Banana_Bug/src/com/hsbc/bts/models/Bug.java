package com.hsbc.bts.models;

public class Bug {
	private int bugId;
	private String title;
	private String description;
	private Project project;
	private User createdBy; //Tester
	private String openDate;// can be edited
	private boolean markForClosing;
	private String closedOn; //Date
	private String status ; // open/close
	private String severityLevel; //critical/major/minor/trivial
	private User assignedTo; //Developer
	private User closedBy; //Manager
	
	public Bug() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Bug(String title, String description, Project project, User createdBy, String openDate,
			String severityLevel) {
		super();
		this.title = title;
		this.description = description;
		this.project = project;
		this.createdBy = createdBy;
		this.openDate = openDate;
		this.severityLevel = severityLevel;
	}

	public Bug(int bugId, String title, String description, Project project, User createdBy, String openDate,
			boolean markForClosing, String closedOn, String status, String severityLevel, User assignedTo,
			User closedBy) {
		super();
		this.bugId = bugId;
		this.title = title;
		this.description = description;
		this.project = project;
		this.createdBy = createdBy;
		this.openDate = openDate;
		this.markForClosing = markForClosing;
		this.closedOn = closedOn;
		this.status = status;
		this.severityLevel = severityLevel;
		this.assignedTo = assignedTo;
		this.closedBy = closedBy;
	}

	public int getBugId() {
		return bugId;
	}

	public void setBugId(int bugId) {
		this.bugId = bugId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public boolean isMarkForClosing() {
		return markForClosing;
	}

	public void setMarkForClosing(boolean markForClosing) {
		this.markForClosing = markForClosing;
	}

	public String getClosedOn() {
		return closedOn;
	}

	public void setClosedOn(String closedOn) {
		this.closedOn = closedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSeverityLevel() {
		return severityLevel;
	}

	public void setSeverityLevel(String severityLevel) {
		this.severityLevel = severityLevel;
	}

	public User getAssignedTo() {
		return assignedTo;
	}

	public void setAssignedTo(User assignedTo) {
		this.assignedTo = assignedTo;
	}

	public User getClosedBy() {
		return closedBy;
	}

	public void setClosedBy(User closedBy) {
		this.closedBy = closedBy;
	}

	@Override
	public String toString() {
		return "Bug [bugId=" + bugId + ", title=" + title + ", description=" + description + ", project=" + project
				+ ", createdBy=" + createdBy + ", openDate=" + openDate + ", markForClosing=" + markForClosing
				+ ", closedOn=" + closedOn + ", status=" + status + ", severityLevel=" + severityLevel + ", assignedTo="
				+ assignedTo + ", closedBy=" + closedBy + "]";
	}
}
