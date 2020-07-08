package com.cloudxpert.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cloudxpert.rest.model.StudentRepository;

@SpringBootApplication
public class SpringBootRestServiceApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServiceApplication.class, args);
	}

}
