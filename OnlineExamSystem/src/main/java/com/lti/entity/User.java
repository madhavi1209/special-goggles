package com.lti.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="table_user")
public class User {

	@Id
	@Column(name="user_id")
	private int userId;
	
	private String password;
	private String name;
	private String email;
	private String mobile;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	
	private String state;
	private String city;
	private String qualification;
	
	@Column(name="year_of_qualification")
	private LocalDate yearOfQualification;
	
	@OneToMany(mappedBy="user",cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	private List<CTest> tests;
	
	/*@OneToOne(mappedBy="user",cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	private Report report;*/

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public LocalDate getYearOfQualification() {
		return yearOfQualification;
	}

	public void setYearOfQualification(LocalDate yearOfQualification) {
		this.yearOfQualification = yearOfQualification;
	}

	public List<CTest> getTests() {
		return tests;
	}

	public void setTests(List<CTest> tests) {
		this.tests = tests;
	}

	/*public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}
	*/
	
}
