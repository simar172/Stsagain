package com.example.ytproj.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.ytproj.payload.PostDto;
import com.example.ytproj.payload.UserDto;
import com.example.ytproj.repositries.Repo;
import com.example.ytproj.service.Service;
import com.example.ytproj.upload.ImageServiceImpl;

@CrossOrigin
@RestController
public class UserController {
    @Autowired
    Service s;
    @Autowired
    ImageServiceImpl ig;

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

//    @PreAuthorize("hasRole('ADMIN')")
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

    @PutMapping(value = "/profile/image/{uid}", consumes = "multipart/form-data")
    public ResponseEntity<UserDto> storeImage(@RequestParam("image") MultipartFile mf, @PathVariable int uid)
            throws IOException {
        String imageName = ig.profileImage(mf);
        UserDto ut = s.getuserbyid(uid);
        ut.setImagename(imageName);
        System.out.println(ut.getImagename());
        UserDto nut = s.updateuser(ut, uid);
        return new ResponseEntity<UserDto>(nut, HttpStatus.OK);
    }

    @PutMapping(value = "/profile/testimage/{uid}", consumes = "multipart/form-data")
    public ResponseEntity<UserDto> testimage(@RequestParam("image") MultipartFile mf, @PathVariable int uid,
            String name)
            throws IOException {
        String imageName = ig.profileImage(mf);
        UserDto ut = s.getuserbyid(uid);
        ut.setImagename(imageName);
        System.out.println(ut.getImagename());
        UserDto nut = s.updateuser(ut, uid);
        return new ResponseEntity<UserDto>(nut, HttpStatus.OK);
    }

    @GetMapping(value = "/profile/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void showImage(@PathVariable String imageName, HttpServletResponse hr) throws IOException {
        try {
            InputStream is = ig.serveProfileImage(imageName);
            hr.setContentType(MediaType.IMAGE_JPEG_VALUE);
            org.hibernate.engine.jdbc.StreamUtils.copy(is, hr.getOutputStream());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }
}