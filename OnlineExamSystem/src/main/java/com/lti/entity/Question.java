package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="table_question")
public class Question {

	@Id
	@Column(name="question_id")
	private int questionId;
	
	@Column(name="question_name")
	private String questionName;
	
	@Column(name="option1")
	private String option1;
	
	@Column(name="option2")
	private String option2;
	
	@Column(name="option3")
	private String option3;
	
	@Column(name="option4")
	private String option4;
	
	@Column(name="correct_answer")
	private String correctAnswer;
	
	@Column(name="marks")
	private int marks;
	
	@Column(name="test_level")
	private int level;
	
	@JoinColumn(name="test_id")
	@ManyToOne
	private CTest test;

	@OneToOne(mappedBy="question",cascade= {CascadeType.MERGE,CascadeType.PERSIST})
	private UserAnswer userAnswer;

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionName() {
		return questionName;
	}

	public void setQuestionName(String questionName) {
		this.questionName = questionName;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getCorrectAnswer() {
		return correctAnswer;
	}

	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public CTest getTest() {
		return test;
	}

	public void setTest(CTest test) {
		this.test = test;
	}

	public UserAnswer getUserAnswer() {
		return userAnswer;
	}

	public void setUserAnswer(UserAnswer userAnswer) {
		this.userAnswer = userAnswer;
	}
	
	
}
