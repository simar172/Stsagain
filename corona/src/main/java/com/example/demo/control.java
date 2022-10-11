package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class control {
	@Autowired
	service s;

	@RequestMapping("/page")
	public String page(Model m) {
		List<getset> li = s.getLi();
	    long sum=0;
		Model mo = m.addAttribute("li",li);
		for(int i=0;i<li.size();i++) {
			sum+=li.get(i).Case;
		}
		 m.addAttribute("case",sum);
		return "home";
	}
}
