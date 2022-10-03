package com.example.demo;

import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.signup", "com.example.demo"})
public class Security2Application {
	@Autowired
	Repositery rs;

	@Autowired
	BCryptPasswordEncoder ps;

	public static void main(String[] args) {
		SpringApplication.run(Security2Application.class, args);
	}



}
