package com.example.ytproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.example.ytproj.entities.Post;
import com.example.ytproj.payload.PostDto;
import com.example.ytproj.repositries.Categoryrepo;
import com.example.ytproj.service.PostService;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService ps;

    @Autowired
    Categoryrepo cr;

    @PostMapping("/user/{uid}/category/{cid}")
    public ResponseEntity<PostDto> createUser(@RequestBody PostDto pt, @PathVariable("uid") int uid,
            @PathVariable("cid") int cid) {
        PostDto np = ps.createPost(pt, uid, cid);
        return new ResponseEntity<PostDto>(np, HttpStatus.OK);
    }

    @GetMapping("/user/{uid}/posts")
    public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable int uid) {
        List<PostDto> li = ps.getAllPostByUser(uid);
        return new ResponseEntity<List<PostDto>>(li, HttpStatus.OK);
    }

    @GetMapping("/category/{cid}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable int cid) {
        List<PostDto> li = ps.getPostByCategory(cid);
        return new ResponseEntity<List<PostDto>>(li, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> getAllPost() {
        List<PostDto> li = ps.getAllPost();
        return new ResponseEntity<List<PostDto>>(li, HttpStatus.OK);
    }

    @GetMapping("/post/{pid}")
    public ResponseEntity<PostDto> getPostbyId(@PathVariable int pid) {
        PostDto p = ps.getPost(pid);
        return new ResponseEntity<PostDto>(p, HttpStatus.OK);
    }

    @PostMapping("/post/{pid}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto pd, @PathVariable int pid) {
        PostDto np = ps.updatePost(pd, pid);
        return new ResponseEntity<PostDto>(np, HttpStatus.OK);
    }

    @DeleteMapping("/post/{pid}")
    public void deletePostById(int pid) {
        ps.deletePost(pid);
    }

}
