package com.model;
import java.io.Serializable;
import java.rmi.server.ObjID;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.OneToMany;

@Entity
public class Commodity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3961378819735222556L;
	@Id@Column(name="commodity_id")
	private Integer id;
	@Id@Column(name="commodity_name")
	private String name;
	private String shelfTime;
	private double price;
	private int salesVolume;
	private int Stock;
	@OneToMany(targetEntity=Snacks.class)
	@JoinColumns({
	@JoinColumn(name="commodity_id",referencedColumnName="commodity_id"),
	@JoinColumn(name="commodity_name",referencedColumnName="commodity_name")
	})
	
	private Set<Snacks> snacks=new HashSet<>();
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj!=null&&obj.getClass()==Commodity.class){
			Commodity target= (Commodity) obj;
			return target.getId().equals(this.id)&&target.getName().equals(this.name);
		}
		return false;
	}
	public int hashCode(){
		return getId().hashCode() *31+getName().hashCode();
	}

	public String getName() {
		return name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
