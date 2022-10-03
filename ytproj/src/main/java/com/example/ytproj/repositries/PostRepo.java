package com.example.ytproj.repositries;

import org.springframework.data.repository.CrudRepository;
import java.util.*;

import com.example.ytproj.entities.Catrgory;
import com.example.ytproj.entities.Post;
import com.example.ytproj.entities.User;

public interface PostRepo extends CrudRepository<Post, Integer> {
    List<Post> findByU(User u);

    List<Post> findByCt(Catrgory ct);
}
