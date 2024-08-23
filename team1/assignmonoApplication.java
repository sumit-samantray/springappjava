package com.oracle.team1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class assignmonoApplication {

	public static void main(String[] args) {;
		SpringApplication.run(assignmonoApplication.class, args);
		// AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
//		User user = context.getBean(User.class);
//		LoginResponse loginResponse = context.getBean(LoginResponse.class);
	}

}
