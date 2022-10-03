package com.example.demo;

import javax.servlet.http.HttpSession;

//import com.example.demo.security.Customuserdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/public")
public class PublicControl {
	@Autowired
	Repositery rs;

	@GetMapping("/home")
	public String home(HttpSession hs, Model m, @AuthenticationPrincipal Customuserdetail ud) {
		String u = "Welcome!! "+ud.getUsername();
		System.out.println("name "+u);
		List<User> li=(List<User>)rs.findAll();
		m.addAttribute("uname", u);
		m.addAttribute("list",li);
		hs.invalidate();
		return "Home";
	}
}
