package com.example.ytproj.service;

import java.util.*;

import com.example.ytproj.entities.Post;
import com.example.ytproj.payload.PostDto;

public interface PostService {
    PostDto createPost(PostDto pt, int uid, int cid);

    PostDto updatePost(PostDto pt, int id);

    void deletePost(int id);

    PostDto getPost(int id);

    List<PostDto> getAllPost(int ps,int pn);

  

    List<PostDto> getPostByCategory(int cid);

    List<PostDto> getAllPostByUser(int uid);

    List<PostDto> searchPost(String key);
}
