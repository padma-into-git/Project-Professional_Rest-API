package com.homify.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.homify.HomifyRestfulServices.AppConfig;
import com.homify.model.Project;

@Service
@Repository
@Transactional
public class ProjectService extends HomifyService{
	
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);
      EntityManagerFactory emf = context.getBean(EntityManagerFactory.class);
	
	public Project createProject(Project project) {
          nativeQuery(emf, "SHOW TABLES");
          nativeQuery(emf, "SHOW COLUMNS from project");
        
		  persistEntity(emf, project);
		  return project;
	}
	
		public Project updateProject(Project project) {
	          nativeQuery(emf, "SHOW TABLES");
	          nativeQuery(emf, "SHOW COLUMNS from project");
	        
			  mergeEntity(emf, project);
			  return project;
		}
		
		
		public Project deleteProject(Project project) {
	          nativeQuery(emf, "SHOW TABLES");
	          nativeQuery(emf, "SHOW COLUMNS from project");
	        
			  removeEntity(emf, project);
			  return project;
		}
		

	public Project findProjectById(Integer projectId) {
		
		 EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	     
		Project proj = em.find(Project.class, projectId);
		 em.close();
		 return proj;
	}
	

	public List<Project> findProjectByProfessionalId(Integer professionalId) {

		EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	      
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
	    Root<Project> from = criteria.from(Project.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("professional"), professionalId));
	    
	    TypedQuery<Project> typed = em.createQuery(criteria);
	    
	    
	    try {
	        return typed.getResultList();
	    } catch (final NoResultException nre) {
	        return null;
	    }
	}

	public List<Project> findProjectByDuration(String duration) {

		EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	      
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
	    Root<Project> from = criteria.from(Project.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("duration"), duration));
	    
	    TypedQuery<Project> typed = em.createQuery(criteria);
	    
	    
	    try {
	        return typed.getResultList();
	    } catch (final NoResultException nre) {
	        return null;
	    }
	}

	public List<Project> findProjectByTypes(String types) {

		EntityManager em = emf.createEntityManager();
	      em.getTransaction().begin();
	      
		CriteriaBuilder builder = em.getCriteriaBuilder();
		CriteriaQuery<Project> criteria = builder.createQuery(Project.class);
	    Root<Project> from = criteria.from(Project.class);
	    criteria.select(from);
	    criteria.where(builder.equal(from.get("types"), types));
	    
	    TypedQuery<Project> typed = em.createQuery(criteria);
	    
	    try {
	        return typed.getResultList();
	    } catch (final NoResultException nre) {
	        return null;
	    }
	}

	
	
}
