package com.example.ytproj.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "category")
@Getter
@Setter
@NoArgsConstructor

public class Catrgory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String title;
    String description;
    @OneToMany(mappedBy = "ct", cascade = CascadeType.ALL)
    List<Post> li=new ArrayList<>();
}
