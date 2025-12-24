package com.example.demo;



public class Student {
	String s_name;
	int s_prn;
	
	public Student(String s_name, int s_prn) {
		this.s_name = s_name;
		this.s_prn = s_prn;
	}

	public Student() {
		
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public int getS_prn() {
		return s_prn;
	}

	public void setS_prn(int s_prn) {
		this.s_prn = s_prn;
	}
	
	
}
