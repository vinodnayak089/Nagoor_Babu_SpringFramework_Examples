package com.durgasoft.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.durgasoft.controller.StudentController;
import com.durgasoft.controller.StudentControllerImpl;
import com.durgasoft.repository.StudentRepo;
import com.durgasoft.repository.StudentRepoImpl;
import com.durgasoft.service.StudentService;
import com.durgasoft.service.StudentServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean
	public StudentRepo studentRepo() {
		StudentRepo studentRepo=new StudentRepoImpl();
		return studentRepo;	
	}
	
	@Bean
	public StudentService studentService() {
		StudentService studentService=new StudentServiceImpl();
		return studentService;	
	}
	
	@Bean
	public StudentController studentController() {
		StudentController studentController=new StudentControllerImpl();
		return studentController;	
	}

}
