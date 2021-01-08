package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//@Entity
//@Table(name="table_report")
public class Report {

	@Id
	@Column(name="report_id")
	private int reportId;

	private int score;
	private String status;
	
	@JoinColumn(name="user_id")
	@OneToOne
	private User user;
	
	@JoinColumn(name="test_id")
	@OneToOne
	private CTest test;

	public int getReportId() {
		return reportId;
	}

	public void setReportId(int reportId) {
		this.reportId = reportId;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CTest getTest() {
		return test;
	}

	public void setTest(CTest test) {
		this.test = test;
	}
	
	
}
