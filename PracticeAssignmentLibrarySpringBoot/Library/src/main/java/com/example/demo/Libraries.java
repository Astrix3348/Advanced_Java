package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Libraries {

	@Id
	int id;
	String b_name;
	String author;
	int price;

	public Libraries() {

	}

	public Libraries(int id, String b_name, String author, int price) {

		this.id = id;
		this.b_name = b_name;
		this.author = author;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getB_name() {
		return b_name;
	}

	public void setB_name(String b_name) {
		this.b_name = b_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
