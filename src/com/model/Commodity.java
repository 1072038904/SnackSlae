package com.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Commodity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3961378819735222556L;
	private Integer id;
	@Id@Column(name="commodity_name")
	private String name;
	private String shelfTime;
	private double price;
	private int salesVolume;
	private int stock;
	private String picturePath;
	@OneToOne(targetEntity=Snacks.class)
	@JoinColumn(name="snacks_name",referencedColumnName="snacks_name")
	private Snacks snacks;
	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	

	public Snacks getSnacks() {
		return snacks;
	}
	public void setSnacks(Snacks snacks) {
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
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getShelfTime() {
		return shelfTime;
	}
	public void setShelfTime(String shelfTime) {
		this.shelfTime = shelfTime;
	}
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
