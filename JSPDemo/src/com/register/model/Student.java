package com.register.model;

public class Student {
	private String name;
	private String mail;
	private String pass;
	private String mob;
	private String course;
	private String year;
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, String mail, String pass, String mob, String course, String year) {
		super();
		this.name = name;
		this.mail = mail;
		this.pass = pass;
		this.mob = mob;
		this.course = course;
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getMob() {
		return mob;
	}
	public void setMob(String mob) {
		this.mob = mob;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	

}
