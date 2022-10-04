package com.example.ytproj.payload;

import java.util.Date;

import javax.persistence.ManyToOne;

import com.example.ytproj.entities.Catrgory;
import com.example.ytproj.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
public class PostDto {
    int id;
    String title;
    String content;
    String imagename;
    Date date;

    CategoryDto ct;

     UserDto u;
}
