package com.example.ytproj;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class YtprojApplication {

	public static void main(String[] args) {
		SpringApplication.run(YtprojApplication.class, args);
	}
   @Bean
	public ModelMapper modelmap() {
	    return new ModelMapper();
	}
}
