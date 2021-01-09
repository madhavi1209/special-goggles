package com.lti.entity;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="table_subject")
public class Subject {
	
	@Id
	@GeneratedValue	
	@Column(name="subject_id")
	private int subjectId;
	
	@Column(name="subject_name")
	private String subjecName;
	
	@Column(name="no_of_questions")
	private int noOfQuestions;
	
	@Column(name="test_level")
	private int level;
	
	@Column(name="test_duration")
	private double duration;
	
	@OneToMany(mappedBy="subject",cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	private List<Question> questions;

	public int getSubject_id() {
		return subjectId;
	}

	public void setSubject_id(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjecName() {
		return subjecName;
	}

	public void setSubjecName(String subjecName) {
		this.subjecName = subjecName;
	}

	public int getNoOfQuestions() {
		return noOfQuestions;
	}

	public void setNoOfQuestions(int noOfQuestions) {
		this.noOfQuestions = noOfQuestions;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	
}
