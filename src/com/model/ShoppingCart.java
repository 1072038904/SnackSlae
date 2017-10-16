package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

public class ShoppingCart {
	@Id
	private Integer id;
	@Id
	private Integer number;
	private double price;
	private String remark;
	@OneToMany(targetEntity=Commodity.class)
	@JoinColumns({
		@JoinColumn(name="commodity_id",referencedColumnName="commodity_id"),
		@JoinColumn(name="commodity_name",referencedColumnName="commodity_name")
	})
	private Set<Commodity> commodities=new HashSet<>();
	@OneToOne
	@JoinColumn(name="account",referencedColumnName="account",unique=true)
	private Account account;
	public ShoppingCart() {
		// TODO 自动生成的构造函数存根
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Set<Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(Set<Commodity> commodities) {
		this.commodities = commodities;
	}
	

}
