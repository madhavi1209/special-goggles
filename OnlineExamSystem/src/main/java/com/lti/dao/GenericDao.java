package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class GenericDao {

	/* STORE */
	public Object store(Object obj) {
		
		EntityManagerFactory emf=null;
		EntityManager em =null;
		
		try {
			emf = Persistence.createEntityManagerFactory("online-exam");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			Object objUpdate=em.merge(obj);
			tx.commit();
			return objUpdate;
		} 

		finally {
			em.close();
			emf.close();
		}

	}

	/* FETCH */
	public Object fetch(Class clazz, Object pk) {
		
		EntityManagerFactory emf=null;
		EntityManager em=null;
		
		try {
			emf = Persistence.createEntityManagerFactory("online-exam");
			em = emf.createEntityManager();
			Object obj = em.find(clazz, pk);
			return obj;
		} 		
		finally {
			em.close();
			emf.close();
		}
	}
}
