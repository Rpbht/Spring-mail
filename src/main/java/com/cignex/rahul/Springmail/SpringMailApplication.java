package com.cignex.rahul.Springmail;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMailApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringMailApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Called.....");
		EmailServiceImpl emailServiceImpl = new EmailServiceImpl();
		emailServiceImpl.sendSimpleMessage("ReciepentEmail", "Demo", "Hello Rahul");
	}

}
