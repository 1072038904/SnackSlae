package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Snacks {
	@Id@Column(name="snacks_name")
	private String name;
	private String priClassification;
	private String secClassification;
	private String packMethod;
	private double price;
	public String getName() {
		return name;
	}
	public String getPriClassification() {
		return priClassification;
	}
	public void setPriClassification(String priClassification) {
		this.priClassification = priClassification;
	}
	public String getSecClassification() {
		return secClassification;
	}
	public void setSecClassification(String secClassification) {
		this.secClassification = secClassification;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPackMethod(String packMethod) {
		this.packMethod = packMethod;
	}
	public String getPackMethod() {
		return packMethod;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Snacks() {
		// TODO 自动生成的构造函数存根
	}

}
