package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="table_user_answer")
public class UserAnswer {

	@Id
	@GeneratedValue
	@Column(name="user_answer_id")
	private int userAnswerId;
	
	@Column(name="option_chosen")
	private String optionChosen;
	
	@Column(name="marks_obtained")
	private int marksObtained;
	
	@JoinColumn(name="question_id")
	@OneToOne
	private Question question;

	public int getUserAnswerId() {
		return userAnswerId;
	}

	public void setUserAnswerId(int userAnswerId) {
		this.userAnswerId = userAnswerId;
	}

	public String getOptionChosen() {
		return optionChosen;
	}

	public void setOptionChosen(String optionChosen) {
		this.optionChosen = optionChosen;
	}

	public int getMarksObtained() {
		return marksObtained;
	}

	public void setMarksObtained(int marksObtained) {
		this.marksObtained = marksObtained;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	
}
