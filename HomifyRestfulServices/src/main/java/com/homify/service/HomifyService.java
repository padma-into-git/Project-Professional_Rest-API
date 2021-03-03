package com.homify.service;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class HomifyService {
	 static void persistEntity(EntityManagerFactory emf, Object obj) {
	      EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	      em.persist(obj);
	      em.getTransaction().commit();
	      em.close();
	  }
	
	 static void mergeEntity(EntityManagerFactory emf, Object obj) {
	      EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	      em.merge(obj);
	      em.getTransaction().commit();
	      em.close();
	  }
	
	 static void removeEntity(EntityManagerFactory emf, Object obj) {
	      EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	  
	      em.remove(em.contains(obj) ? obj : em.merge(obj));	      
	      em.getTransaction().commit();
	      em.close();
	  }
	  static void nativeQuery(EntityManagerFactory emf, String s) {
	      EntityManager em = emf.createEntityManager();
	      Query query = em.createNativeQuery(s);
	      List list = query.getResultList();
	      for (Object o : list) {
	          if (o instanceof Object[]) {
	              System.out.println(Arrays.toString((Object[]) o));
	          } else {
	              System.out.println(o);
	          }
	      }
	      em.close();
	  }

}
