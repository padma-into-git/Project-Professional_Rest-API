package com.homify.HomifyRestfulServices;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.homify.model.Contact;
import com.homify.model.Professional;
import com.homify.model.Project;
import com.homify.service.ProfessionalService;
import com.homify.service.ProjectService;
@Ignore
public class HomifyRestfulServicesApplicationTests {
    
    
    private MockMvc mockMvc;
    
    @Mock
    @Autowired
    private ProfessionalService profService;
    
    @Mock
    @Autowired
    private ProjectService projService;
    
    @InjectMocks
    @Autowired
    private WelcomeController wcCont;
    
    @Autowired
    private Professional prof;
    
    @Autowired
    private Project proj;
    
    @Autowired
    private Contact contact;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(wcCont)
//                .addFilters(new CORSFilter())
                .build();
    }
    
	@Test
	public void contextLoads() {
	}
	
    @Test
    public void test_create_find_professional() throws Exception {
        
    	prof.setProfessionalId(0);
	  	prof.setFirstName("Padma");
	  	prof.setLastName("Jayakumar");
	  	prof.setUserName("msg2padhu");
	  	prof.setCompanyName("Cognizant");
	  	prof.setHeader("Engineer");
	  	prof.setLatitude(11);
	  	prof.setLongitude(9);
	  	prof.setTypes("Architecture");
	  	
	    contact.setCity("Chennai");
	    contact.setCountry("India");
	    contact.setEmail("msg2padhu@gmail.com");
	    contact.setPhone("9942040230");
	    contact.setWebsite("www.msg2padhu.com");
	    
	    prof.setContact(contact);
	    
	  	prof = profService.createProfessional(prof);

        mockMvc.perform(
                get("/findProfessionalById/{prof.getProfessionalId()}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].firstName", is("PADMA")))
                .andExpect(jsonPath("$[0].lastName", is("JAYAKUMAR")));

    }
    
    @Test
    public void test_create_find_project() throws Exception {
    	
    	proj.setProjectId(0);
    	proj.setHeader("Zurich NA");
    	proj.setDescription("Zurich North America Insurance");
    	proj.setTitle("NA Application Development");
    	proj.setDuration("6 Months");
    	proj.setTypes("Fixed Fee");

    	prof.setProfessionalId(2);
	  	prof.setFirstName("Padma");
	  	prof.setLastName("Jayakumar");
	  	prof.setUserName("msg2padhu");
	  	prof.setCompanyName("Cognizant");
	  	prof.setHeader("Engineer");
	  	prof.setLatitude(11);
	  	prof.setLongitude(9);
	  	prof.setTypes("Architecture");
	  	
	    contact.setCity("Chennai");
	    contact.setCountry("India");
	    contact.setEmail("msg2padhu@gmail.com");
	    contact.setPhone("9942040230");
	    contact.setWebsite("www.msg2padhu.com");
	    
	    prof.setContact(contact);
	    proj.setProfessional(prof);
	    
	  	proj = projService.createProject(proj);

        mockMvc.perform(
                get("/findProjectById/{proj.getProjectId()}"))
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].header", is("ZURICH NA")));

    }

}
