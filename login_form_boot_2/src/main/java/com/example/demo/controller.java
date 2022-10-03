package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
	@Autowired
	reps r;

	@RequestMapping("/login")
	public String login(Model m) {
		entity e=new entity();
		m.addAttribute("entity", e);
		return "login";
	}
	
	@PostMapping("/login/handle")
	public String login_back(@ModelAttribute entity e) {
		String user=e.getUsername();
		entity e1=r.findById(user).get();
		if(e.getPassword().equals(e1.getPassword())) {
			return "home";
		}
		return "error";
	}
}
