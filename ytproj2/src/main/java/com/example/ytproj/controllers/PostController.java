package com.example.ytproj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.StreamUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.example.ytproj.config.Constants;
import com.example.ytproj.payload.PostDto;
import com.example.ytproj.payload.PostResponse;
import com.example.ytproj.repositries.Categoryrepo;
import com.example.ytproj.service.PostService;
import com.example.ytproj.upload.ImageService;

@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    PostService ps;
    @Value("${project.image}")
    String path;

    @Autowired
    Categoryrepo cr;

    @Autowired
    ImageService ig;

    @PostMapping("/user/{uid}/category/{cid}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto pt, @PathVariable("uid") int uid,
            @PathVariable("cid") int cid) {
        PostDto np = ps.createPost(pt, uid, cid);
        return new ResponseEntity<PostDto>(np, HttpStatus.CREATED);
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
    public ResponseEntity<PostResponse> getAllPost(
            @RequestParam(defaultValue = Constants.PageNo, value = "pagenumber", required = false) int pn,
            @RequestParam(defaultValue = Constants.PageSize, value = "pagesize", required = false) int ps,
            @RequestParam(defaultValue = Constants.sortBy, value = "sortby", required = false) String sort,
            @RequestParam(defaultValue = Constants.sortDir, value = "sortdir", required = false) String dir) {
        PostResponse pr = this.ps.getAllPost(ps, pn, sort, dir);
        return new ResponseEntity<PostResponse>(pr, HttpStatus.OK);

    }

    @GetMapping("/post/{pid}")
    public ResponseEntity<PostDto> getPostbyId(@PathVariable int pid) {
        PostDto p = ps.getPost(pid);
        return new ResponseEntity<PostDto>(p, HttpStatus.OK);
    }

    @PutMapping("/updatePost/{pid}")
    public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto pd, @PathVariable int pid) {
        PostDto np = ps.updatePost(pd, pid);
        return new ResponseEntity<PostDto>(np, HttpStatus.OK);
    }

    @DeleteMapping("/post/{pid}")
    public void deletePostById(@PathVariable int pid) {
        ps.deletePost(pid);
    }

    @GetMapping("/search/post/{key}")
    public ResponseEntity<List<PostDto>> searchByKeyWords(@PathVariable String key) {
        List<PostDto> li = ps.searchPost(key);
        return new ResponseEntity<List<PostDto>>(li, HttpStatus.OK);
    }

    @PostMapping("/post/store/{pid}/{uname}")
    public ResponseEntity<PostDto> storeImage(@RequestParam("image") MultipartFile mf, @PathVariable int pid,
            @PathVariable("uname") String uname)
            throws IOException {
        String imageName = ig.uploadImage(mf, uname);
        PostDto pt = ps.getPost(pid);
        pt.setImagename(imageName);
        PostDto up = ps.updatePost(pt, pid);
        return new ResponseEntity<PostDto>(up, HttpStatus.OK);
    }

    @GetMapping(value = "/post/show/{imageName}/{uname}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void showImage(@PathVariable String imageName, HttpServletResponse hr, @PathVariable("uname") String uname)
            throws IOException {
        try {
            InputStream is = ig.serveImage(imageName,uname);
            hr.setContentType(MediaType.IMAGE_JPEG_VALUE);
            org.hibernate.engine.jdbc.StreamUtils.copy(is, hr.getOutputStream());
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
        }
    }

}