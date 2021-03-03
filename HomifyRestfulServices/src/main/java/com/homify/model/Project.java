package com.homify.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "project")
@NamedQuery(query = "select p from Project p", name = "query_find_all_projects")
public class Project {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int projectId;
	
	@Column(name = "header")
	private String header;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "duration")
	private String duration;
	
	@Column(name = "types")
	private String types;
	
	@JoinColumn(name="project_ownerid")
	@ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH},targetEntity=Professional.class)
	private Professional professional;
	
	public Professional getProfessional() {
		return professional;
	}
	public void setProfessional(Professional professional) {
		this.professional = professional;
	}
	public String getHeader() {
		return header;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public void setHeader(String header) {
		this.header = header;
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
}
