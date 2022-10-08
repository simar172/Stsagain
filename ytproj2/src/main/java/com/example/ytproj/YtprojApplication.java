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

import com.example.ytproj.entities.User;
import com.example.ytproj.repositries.PostRepo;
import com.example.ytproj.repositries.Repo;

@SpringBootApplication
public class YtprojApplication implements CommandLineRunner {

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

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
//        User user = r.findByEmail("simar@gmail.com");
//        System.out.println(user);
//        System.out.println(l.);
        System.out.println(pass.matches("simar", "$2a$10$sWNpe.zS210w7nXNPQjIfem82EzUJHbNCjLK9ATPN.6OA9TnzI566"));
//        System.out.println(pass.matches("$2a$10$KHbjZgKtizFwM7O9BV.zN.oYi6iZaPqlQf.qP9epK.NDT.mX5QEiO","simar"));
//        pass.
    }

}
