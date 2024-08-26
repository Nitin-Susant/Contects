package com.smart;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.smart.helper.ContectHelper;
import com.smart.services.UserService;
import com.smart.servicesimpl.ContectServiceImpl;

import lombok.ToString;

@Component
@ToString
public class runner implements CommandLineRunner {
 
	 @Autowired
	ContectServiceImpl contectRepo;
	
	@Autowired
	UserService  service;
	
	public void run(String... args) throws Exception {
 
//	       File f = new ClassPathResource("").getFile();
//	       System.out.println(f.toString());
	       
	        
	       List<ContectHelper> contects = contectRepo.getContects();
	        contects.forEach(e -> System.out.println(e));
	       
//	       UserHelper userById = service.getUserById(4);
//	       System.out.println(userById);
//	        List<User> findAll = urpo.findAll();
//	     
//	    	  System.out.println(findAll);
//	     User findbyemail = urpo.findbyemail("manash@gmail");
//	       System.out.println(findbyemail);
	  	 
	}

	 
}
