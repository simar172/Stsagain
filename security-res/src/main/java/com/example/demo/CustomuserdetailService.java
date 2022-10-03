package com.example.demo;

import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomuserdetailService implements UserDetailsService {
	@Autowired
	Repositery rs;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User u = rs.findById(username).get();
		if (u == null) {
			throw new UsernameNotFoundException("Not found");
		}
		System.out.println( "simar here "+new Customuserdetail(u).getusername());
//		Model m=new Model();
		return new Customuserdetail(u);
	}

}
