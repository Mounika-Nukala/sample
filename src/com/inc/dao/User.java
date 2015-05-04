package com.inc.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="user_tbl")
@Entity
public class User 
{
@Column
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int uid;

@Column
private String fname;
@Column
private String lname;
@Column
private String email; 

public String getFname() {
	return fname;
}
public void setFname(String fname) {
	this.fname = fname;
}
public String getLname() {
	return lname;
}
public void setLname(String lname) {
	this.lname = lname;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
}
