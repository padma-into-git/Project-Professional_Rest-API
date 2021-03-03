package com.homify.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homify.HomifyRestfulServices.AppConfig;
import com.homify.model.Contact;
import com.homify.model.Professional;

@Service
@Repository
@Transactional
public class ProfessionalService extends HomifyService{

		
	      AnnotationConfigApplicationContext context =
	              new AnnotationConfigApplicationContext(AppConfig.class);
	      EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
		
		public Professional createProfessional(Professional professional) {
	          nativeQuery(emf, "SHOW TABLES");
	          nativeQuery(emf, "SHOW COLUMNS from professional");
			  persistEntity(emf, professional);
			  return professional;
		}
		
		public Contact createContact(Contact contact) {
	          nativeQuery(emf, "SHOW TABLES");
	          nativeQuery(emf, "SHOW COLUMNS from contact");
			  persistEntity(emf, contact);
			  return contact;
		}

		
		  
			public Professional updateProfessional(Professional professional) {
		          nativeQuery(emf, "SHOW TABLES");
		          nativeQuery(emf, "SHOW COLUMNS from professional");
				  mergeEntity(emf, professional);
				  return professional;
			}
			
			public Contact updateContact(Contact contact) {
		          nativeQuery(emf, "SHOW TABLES");
		          nativeQuery(emf, "SHOW COLUMNS from contact");
				  mergeEntity(emf, contact);
				  return contact;
			}
		
		
			
			public Professional deleteProfessional(Professional professional) {
		          nativeQuery(emf, "SHOW TABLES");
		          nativeQuery(emf, "SHOW COLUMNS from professional");
				  removeEntity(emf, professional);
				  return professional;
			}
			
			public Contact deleteContact(Contact contact) {
		          nativeQuery(emf, "SHOW TABLES");
		          nativeQuery(emf, "SHOW COLUMNS from contact");
				  removeEntity(emf, contact);
				  return contact;
			}
		
	
		public Professional findProfessionalById(Integer professionalId) {
			 EntityManager em = emf.createEntityManager();
		      em.getTransaction().begin();
		     
			Professional prof = em.find(Professional.class, professionalId);
			 em.close();
			 return prof;
		}
		
		public List<Professional> findProfessionalByPeriod(Timestamp startDate, Timestamp endDate) {
			EntityManager em = emf.createEntityManager();
		      em.getTransaction().begin();
		      
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Professional> criteria = builder.createQuery(Professional.class);
		    Root<Professional> from = criteria.from(Professional.class);
		    criteria.select(from);
		    List<Professional> profList = null;
		    
		    criteria.where(builder.greaterThanOrEqualTo(from.get("updatedDate"), startDate));
		    
		    TypedQuery<Professional> typed = em.createQuery(criteria);
		    
		    try {
		    	profList =  typed.getResultList();
		    	if(null != profList && !profList.isEmpty()) {
		    		return profList.stream().filter(prof ->prof.getUpdatedDate().before(endDate)).collect(Collectors.toList());
		    	}
		    } catch (final NoResultException nre) {
		        return null;
		    }
		    return profList;
		}
		

		public List<Professional> findProfessionalByType(String type) {
			EntityManager em = emf.createEntityManager();
		      em.getTransaction().begin();
		      
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Professional> criteria = builder.createQuery(Professional.class);
		    Root<Professional> from = criteria.from(Professional.class);
		    criteria.select(from);
		    criteria.where(builder.equal(from.get("types"), type));
		    
		    TypedQuery<Professional> typed = em.createQuery(criteria);
		    
		    
		    try {
		        return typed.getResultList();
		    } catch (final NoResultException nre) {
		        return null;
		    }
		}

		public List<Professional> findProfessionalByLocation(Integer latitude, Integer longitude) {
			EntityManager em = emf.createEntityManager();
		      em.getTransaction().begin();
		      
			CriteriaBuilder builder = em.getCriteriaBuilder();
			CriteriaQuery<Professional> criteria = builder.createQuery(Professional.class);
		    Root<Professional> from = criteria.from(Professional.class);
		    criteria.select(from);
		    criteria.where(builder.equal(from.get("latitude"), latitude));
			criteria.where(builder.equal(from.get("longitude"), longitude));
		    
		    TypedQuery<Professional> typed = em.createQuery(criteria);
		    
		    
		    try {
		        return typed.getResultList();
		    } catch (final NoResultException nre) {
		        return null;
		    }
		} 

}
