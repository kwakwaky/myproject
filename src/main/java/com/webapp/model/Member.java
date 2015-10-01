package com.webapp.model;

import java.util.Date;

public class Member {
	// model class의 변수는 private해줘야함 (보안)
	
	private int num;
	private String email;
	private String password;
	private String name;
	private String phone;
	private String gender;
	private String birth;
	private String choice;
	private Date enter;
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
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
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public Date getEnter() {
		return enter;
	}
	public void setEnter(Date enter) {
		this.enter = enter;
	}
	
}
