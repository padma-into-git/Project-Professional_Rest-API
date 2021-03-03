package com.homify.HomifyRestfulServices;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.homify.model.Contact;
import com.homify.model.Professional;
import com.homify.model.Project;
import com.homify.service.ProfessionalService;
import com.homify.service.ProjectService;


@RestController
public class WelcomeController {

@Autowired
ProfessionalService professionalService;

@Autowired
ProjectService projectService;

private static Timestamp currentTime = new Timestamp(new Date().getTime());
	
	@PostMapping("/createProfessional")	
	public Professional createProfessional(@RequestBody Professional professional) {
		if(null == professional) {
			return null;
		}
		
		if(professional.getContact()!= null) {
			Contact contact = null;
			contact = professionalService.createContact(professional.getContact());
			professional.setContact(contact);
		}
		
		professional.setUpdatedDate(currentTime);
		
		return professionalService.createProfessional(professional);
	}
	
	@PostMapping("/updateProfessional")
	public Professional updateProfessional(@RequestBody Professional professional) {
		if(null == professional) {
			return null;
		}
		professional.setUpdatedDate(currentTime);
		
		return professionalService.updateProfessional(professional);
	}
	
	@PostMapping("/deleteProfessional")
	public Professional deleteProfessional(@RequestBody Professional professional) {
		if(null == professional) {
			return null;
		}
		   List<Project> projList = findProjectByProfessionalId(professional.getProfessionalId()) ;
	          if(projList != null && !projList.isEmpty()) {
	        	  for(Project prj :projList) {
	        		  deleteProject(prj);
	        	  }
	          }
		return professionalService.deleteProfessional(professional);
	}
	
	@GetMapping("/findProfessionalById{professionalId}")
	public Professional findProfessionalById(Integer professionalId) {
		if(null == professionalId) {
			return null;
		}
	
		return professionalService.findProfessionalById(professionalId);
	}
	
	
	@GetMapping(path = "/findProfessionalByPeriod/{startDate}/{endDate}")
	public List<Professional> findProfessionalByPeriod(@PathVariable  String startDate, @PathVariable  String endDate) {
		if(null == startDate || null == endDate) {
			return null;
		}
		
		Timestamp st = null;
		Timestamp end = null;
		try {
			st = new Timestamp(getDate(startDate).getTime());
			end = new Timestamp(getDate(endDate).getTime());	
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return professionalService.findProfessionalByPeriod(st,end);
	}
	
	@GetMapping("/findProfessionalByType{type}")
	public List<Professional> findProfessionalByType(String type) {
		if(null == type ) {
			return null;
		}
		return professionalService.findProfessionalByType(type);
	}
	
	@RequestMapping(path = "/findProfessionalByLocation/{latitude}/{longitude}", method = RequestMethod.GET)
	public List<Professional> findProfessionalByLocation(@PathVariable  Integer latitude, @PathVariable  Integer longitude) {
		if(null == latitude || null == longitude) {
			return null;
		}
		return professionalService.findProfessionalByLocation(latitude,longitude);
	}
	

	@PostMapping("/createProject")	
	public Project createProject(@RequestBody Project project) {
		if(null == project) {
			return null;
		}
	
		return projectService.createProject(project);
	}
	
	@PostMapping("/updateProject")
	public Project updateProject(@RequestBody Project project) {
		if(null == project) {
			return null;
		}
		
		return projectService.updateProject(project);
	}
	
	@PostMapping("/deleteProject")
	public Project deleteProject(@RequestBody Project project) {
		if(null == project) {
			return null;
		}
		
		return projectService.deleteProject(project);
	}
	
	@GetMapping("/findProjectById{projectId}")
	public Project findProjectById(Integer projectId) {
		if(null == projectId) {
			return null;
		}
	
		return projectService.findProjectById(projectId);
	}
	
	@GetMapping("/findProjectByProfessionalId{professionalId}")
	public List<Project> findProjectByProfessionalId(Integer professionalId) {
		if(null == professionalId) {
			return null;
		}
	
		return projectService.findProjectByProfessionalId(professionalId);
	}
	
	@GetMapping("/findProjectByDuration{duration}")
	public List<Project> findProjectByDuration(String duration) {
		if(null == duration ) {
			return null;
		}
		return projectService.findProjectByDuration(duration);
	}
	
	@GetMapping("/findProjectByTypes{types}")
	public List<Project> findProjectByTypes(String types) {
		if(null == types ) {
			return null;
		}
		return projectService.findProjectByTypes(types);
	}
	
	private Date getDate(String str) throws ParseException {
		
		return new SimpleDateFormat("yyyy-mm-dd").parse(str);
	}
	
}

