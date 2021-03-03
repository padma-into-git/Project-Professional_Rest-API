package com.homify.model;

import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professional")
@NamedQuery(query = "select p from Professional p", name = "query_find_all_professionals")
public class Professional {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int professionalId;
	
	@Column(name = "header")
	private String header;
	
	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "companyname")
	private String companyName;
	
	@Column(name = "latitude")
	private Integer latitude;
	
	@Column(name = "longitude")
	private Integer longitude;
	
	@Column(name = "updateddate")
	private Timestamp updatedDate;
	
	@Column(name = "types")
	private String types;
	
	//@ManyToMany(mappedBy = "types")
//	private ArrayList<String> types;
	//@ManyToMany(mappedBy = "projects")
//	private List<Project> projects;
	
		
//    @JoinTable(
//	    name = "contact",
//	    joinColumns = @JoinColumn(
//	            name = "contactid",
//	            referencedColumnName = "contactid"
//	    )
//	    inverseJoinColumns = @JoinColumn(
//	            name = "TASK_ID",
//	            referencedColumnName = "TID"
//	    )
//    )
//    @OneToManys

	public String getTypes() {
		return types;
	}
	public void setTypes(String types) {
		this.types = types;
	}
	@JoinColumn(name="prof_contactid")
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH},targetEntity=Contact.class)
	private Contact contact;
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}

	public int getProfessionalId() {
		return professionalId;
	}
	public void setProfessionalId(int professionalId) {
		this.professionalId = professionalId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Integer getLatitude() {
		return latitude;
	}
	public void setLatitude(Integer latitude) {
		this.latitude = latitude;
	}
	public Integer getLongitude() {
		return longitude;
	}
	public void setLongitude(Integer longitude) {
		this.longitude = longitude;
	}
	public Timestamp getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Timestamp updatedDate) {
		this.updatedDate = updatedDate;
	}
//	public ArrayList<String> getTypes() {
//		return types;
//	}
//	public void setTypes(ArrayList<String> types) {
//		this.types = types;
//	}
//	public ArrayList<Project> getProjects() {
//		return projects;
//	}
//	public void setProjects(ArrayList<Project> projects) {
//		this.projects = projects;
//	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}	
	
}
