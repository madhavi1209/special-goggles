package com.lti.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Table_test")
public class CTest {

	@Id
	@Column(name="test_id")
	private int testId;
	
	@Column(name="subject_name")
	private String subjectName;
	
	@Column(name="subject_id")
	private int subjectId;
	
	@Column(name="test_duration")
	private double duration;
	
	@Column(name="test_level")
	private int level;
	
	@Column(name="date_and_time_of_test")
	private LocalDateTime dateAndTimeOfTest;
	
	@JoinColumn(name="user_id")
	@ManyToOne
	private User user;
	
	/*@OneToMany(mappedBy="test",cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	private List<Question> questions;
	
	@OneToOne(mappedBy="test",cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	private Report report;*/

	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double d) {
		this.duration = d;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public LocalDateTime getDateAndTimeOfTest() {
		return dateAndTimeOfTest;
	}

	public void setDateAndTimeOfTest(LocalDateTime dateAndTimeOfTest) {
		this.dateAndTimeOfTest = dateAndTimeOfTest;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/*public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Report getReport() {
		return report;
	}

	public void setReport(Report report) {
		this.report = report;
	}*/
	
	
}
