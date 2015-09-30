package com.webapp.command;

//import java.util.Date;

import com.webapp.model.Member;

public class RegistCommand {
	
	String email;
	
	String password;
	String passwordcheck;
	
	String name;
	String phone;
	String gender;

	String birth;
//	Date birth;
	
	String choice;
	
	public Member getMember() {
		
		Member m = new Member();
		
		m.setEmail(this.email);
		m.setPassword(this.password);
		m.setName(this.name);
		m.setPhone(this.phone);
		m.setGender(this.gender);
		m.setBirth(this.birth);
		m.setChoice(this.choice);
		
		return m;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordcheck() {
		return passwordcheck;
	}
	public void setPasswordcheck(String passwordcheck) {
		this.passwordcheck = passwordcheck;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
//	public Date getBirth() {
//		return birth;
//	}
//	public void setBirth(Date birth) {
//		this.birth = birth;
//	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	
	
	
}
