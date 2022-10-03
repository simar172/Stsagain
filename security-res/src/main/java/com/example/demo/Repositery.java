package com.example.demo;

import com.example.demo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface Repositery extends CrudRepository<User, String>{


}
