package com.lti.test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.junit.Test;

import com.lti.dao.GenericDao;
import com.lti.entity.CTest;
import com.lti.entity.User;

public class OnlineExamSystemTest {

	@Test
	public void addUser() {
		
		User user=new User();
		user.setUserId(102);
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
	public void addTest() {
		CTest test =new CTest();
		test.setTestId(201);
		test.setSubjectName("JAVA");
		test.setSubjectId(2011);
		test.setDuration(2.5);
		test.setDateAndTimeOfTest(LocalDateTime.now());
		test.setLevel(1);
		
		GenericDao dao=new GenericDao();
		User user=(User) dao.fetch(User.class, 102);
		
		test.setUser(user);
		dao.store(test);
	}
}
