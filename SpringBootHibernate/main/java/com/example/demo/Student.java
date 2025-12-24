package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Student {

	@Id
	int s_id;
	String s_name;
	String s_course;

	public Student() {
		
	}

	public Student(int s_id, String s_name, String s_course) {

		this.s_id = s_id;
		this.s_name = s_name;
		this.s_course = s_course;
	}

	public int getS_id() {
		return s_id;
	}

	public void setS_id(int s_id) {
		this.s_id = s_id;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_course() {
		return s_course;
	}

	public void setS_course(String s_course) {
		this.s_course = s_course;
	}
}
