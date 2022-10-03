package com.example.ytproj.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ytproj.payload.UserDto;
import com.example.ytproj.repositries.Repo;
import com.example.ytproj.service.Service;

@RestController
public class UserController {
    @Autowired
    Service s;

    @PostMapping("/")
    public ResponseEntity<UserDto> createuser(@Valid @RequestBody UserDto ut) {
        UserDto nut = s.createuser(ut);
        return new ResponseEntity<UserDto>(nut, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateuse(@Valid @RequestBody UserDto ud, @PathVariable("id") int id) {
        UserDto nut = s.updateuser(ud, id);
        return ResponseEntity.ok(nut);
    }

    @DeleteMapping("/{id}")
    public void deleteuser(@PathVariable("id") int id) {
        s.deleteuser(id);
    }

    @GetMapping("/")
    public ResponseEntity<List<UserDto>> getallusers() {
        List<UserDto> li = s.getall();
        return ResponseEntity.ok(li);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getuserbyid(@PathVariable int id) {
        UserDto u = s.getuserbyid(id);
        return ResponseEntity.ok(u);
    }
}
