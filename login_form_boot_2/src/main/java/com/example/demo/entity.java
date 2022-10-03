package com.example.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reg")
public class entity {
@Id
@Column(name="username")
String username;
@Column(name="password")
String password;
@Override
public String toString() {
	return "entity [username=" + username + ", password=" + password + "]";
}
public entity() {
	super();
	// TODO Auto-generated constructor stub
}
public entity(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
