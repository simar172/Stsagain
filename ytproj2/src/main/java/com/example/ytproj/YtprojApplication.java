package com.example.ytproj;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.example.ytproj.entities.User;
import com.example.ytproj.repositries.PostRepo;
import com.example.ytproj.repositries.Repo;

@SpringBootApplication
public class YtprojApplication {

    @Autowired
    PasswordEncoder pass;

    @Autowired
    Repo r;

    public static void main(String[] args) {
        SpringApplication.run(YtprojApplication.class, args);
    }

    @Bean
    public ModelMapper modelmap() {
        return new ModelMapper();
    }

}
