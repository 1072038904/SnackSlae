package com.model;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Commodity {
	@Id@Column(name="commodity_name")
	private String name;
	private String shelfTime;
	private double price;
	private int salesVolume;
	private int Stock;
	@OneToMany(targetEntity=Snacks.class)
	@JoinColumn(name="commodity_name",referencedColumnName="commodity_name")
	private Set<Snacks> snacks=new HashSet<>();
	public String getName() {
		return name;
	}
	
	public Set<Snacks> getSnacks() {
		return snacks;
	}

	public void setSnacks(Set<Snacks> snacks) {
		this.snacks = snacks;
	}

	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getSalesVolume() {
		return salesVolume;
	}
	public void setSalesVolume(int salesVolume) {
		this.salesVolume = salesVolume;
	}
	public int getStock() {
		return Stock;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public String getShelfTime() {
		return shelfTime;
	}
	public void setShelfTime(String shelfTime) {
		this.shelfTime = shelfTime;
	}
	
}
