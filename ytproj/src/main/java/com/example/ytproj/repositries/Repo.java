package com.example.ytproj.repositries;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.ytproj.entities.User;
@Repository
public interface Repo extends CrudRepository<User, Integer> {

}
