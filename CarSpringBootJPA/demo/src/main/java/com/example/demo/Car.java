package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Car {
	@Id
	public int id;
	public String brand;
	public int cost;
	
	public Car() {
		
	}

	public Car(int id, String brand, int cost) {
		this.id = id;
		this.brand = brand;
		this.cost = cost;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
