package com.lti.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.dao.TestDao;
import com.lti.entity.CTest;
import com.lti.entity.Question;
import com.lti.entity.Report;
import com.lti.entity.Subject;
import com.lti.entity.User;
import com.lti.entity.UserAnswer;

public class OnlineExamSystemTest {

	@Test
	public void addUser() {
		
		User user=new User();
		user.setName("Siddhi");
		user.setPassword("abc123");
		user.setCity("Pune");
		user.setEmail("siddhii@lti.com");
		user.setMobile("1234567890");
		user.setDateOfBirth(LocalDate.of(2010, 12, 12));
		user.setQualification("B.E");
		user.setYearOfQualification(LocalDate.of(2020, 10, 10));
		user.setState("Maharashtra");
		
		GenericDao dao=new GenericDao();
		dao.store(user);
	}
	
	@Test
	public void addSubjectAndQuestions() {
		
		GenericDao dao=new GenericDao();
		
		Subject subject=new Subject();
		subject.setSubjecName("JAVA");
		subject.setNoOfQuestions(2);
		subject.setLevel(1);
		subject.setDuration(1.0);
		
		List<Question> questions=new ArrayList<Question>();
		
		Question q1=new Question();
		q1.setQuestionName("Which of the following is not a Java features?");
		q1.setOption1("Dynamic");
		q1.setOption2("Architecture Neutral");
		q1.setOption3("Use of pointers");
		q1.setOption4("Object-oriented");
		q1.setCorrectAnswer("Use of pointers");
		q1.setLevel(1);
		q1.setMarks(2);
		q1.setSubject(subject);
		
		Question q2=new Question();
		q2.setQuestionName(" Which of the following is a valid long literal?");
		q2.setOption1("ABH8097");
		q2.setOption2("L990023");
		q2.setOption3("904423");
		q2.setOption4("0xnf029L");
		q2.setCorrectAnswer("0xnf029L");
		q2.setLevel(1);
		q2.setMarks(2);
		q2.setSubject(subject);
		
		questions.add(q1);
		questions.add(q2);
		
		subject.setQuestions(questions);
		

		dao.store(subject);
	}
	
	@Test
	public void addTest() {
		CTest test=new CTest();
		test.setLevel(1);
		test.setDateAndTimeOfTest(LocalDateTime.now());
		
		GenericDao dao=new GenericDao();
		User user=(User) dao.fetch(User.class,156);
		Subject subject=(Subject) dao.fetch(Subject.class, 157);
		
		test.setUser(user);
		test.setSubject(subject);
		
		dao.store(test);
	}
	
	@Test
	public void giveTest() {
		TestDao dao=new TestDao();
		CTest test=(CTest) dao.fetch(CTest.class,160);
		
		List<Question> list=dao.fetchQuestions(test.getSubject().getSubject_id());
		
		Report report =new Report();
		report.setTest(test);
		report.setUser(test.getUser());
		
		int score=0;
		
		for(Question q:list) {
			UserAnswer ua=new UserAnswer();
			ua.setQuestion(q);
			ua.setOptionChosen("Use of pointers");
			if(ua.getQuestion().getCorrectAnswer().equals(ua.getOptionChosen())) {
				ua.setMarksObtained(2);
				score=score+2;
			}
			dao.store(ua);
			
		}
		report.setClearedLevel(1);
		report.setTestScore(score);
		dao.store(report);
	}
	
	@Test
	public void showReport() {
		TestDao dao=new TestDao();
		Report report=(Report) dao.fetch(Report.class, 163);
		System.out.println("User Name : "+report.getUser().getName() );
		System.out.println("Test Subject : "+report.getTest().getSubject().getSubjecName());
		System.out.println("Score : "+report.getTestScore()+" out of "+report.getTest().getSubject().getNoOfQuestions()*2);
	}
	}
