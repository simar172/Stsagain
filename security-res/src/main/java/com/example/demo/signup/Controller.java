package com.example.demo.signup;

import java.util.*;
import com.example.demo.Repositery;
import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping("/signup")
public class Controller {
    @Autowired
    Repositery res;
    @Autowired
    BCryptPasswordEncoder bc;

    List<String> roles;

    @RequestMapping("/")
    public String signup(Model m) {
        User u = new User();
        m.addAttribute("user", u);
        roles = new ArrayList<>();
        roles.add("NORMAL");
        roles.add("ADMIN");
        m.addAttribute("list", roles);
        return "signup";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("user") User u) {
        System.out.println("simar");
        User u1 = new User();
        u1.setEmail(u.getEmail());
        u1.setPassword(bc.encode(u.getPassword()));
        u1.setRole("ROLE_" + u.getRole());
        u1.setUsername(u.getUsername());
        u1.setConfPass(bc.encode(u.getConfPass()));
        res.save(u1);
        return "redirect:/signup/";
    }

}
