package com.homify.HomifyRestfulServices;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.homify.service.ProfessionalService;
import com.homify.service.ProjectService;

@Configuration
public class HomifyConfig {

	  @Bean
	    public ProfessionalService professionalService() {
	        return new ProfessionalService();
	    }
	  
	  @Bean
	    public ProjectService projectService() {
	        return new ProjectService();
	    }
	  
}
