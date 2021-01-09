package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Question;

public class TestDao extends GenericDao{

	public List<Question> fetchQuestions(int subjectId) {
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		try {
		emf = Persistence.createEntityManagerFactory("online-exam");
		em = emf.createEntityManager();
		
		Query q = em.createQuery("select s.questions from Subject s where s.subjectId=:subjectId");
		q.setParameter("subjectId",subjectId);
			
		List<Question> list = q.getResultList();
		return list;
		}
		
		finally {
		em.close();
		emf.close();
		}
}
}
