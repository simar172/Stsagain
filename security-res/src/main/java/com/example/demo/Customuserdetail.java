package com.example.demo;

import java.util.*;

import com.example.demo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Customuserdetail implements UserDetails {

	public Customuserdetail(User u) {
		super();
		this.u = u;
	}

	User u;

	public String getusername() {
		return this.u.getUsername();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		HashSet<SimpleGrantedAuthority> hs = new HashSet<>();
		hs.add(new SimpleGrantedAuthority(u.getRole()));
		return hs;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return u.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return u.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
