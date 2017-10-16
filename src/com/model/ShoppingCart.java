package com.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
public class ShoppingCart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8282460473588733175L;
	@Id@Column(name="shoppingCart_id")
	private Integer id;
	@Id@Column(name="shoppingCart_name")
	private Integer number;
	private double price;
	private String remark;
	@OneToMany(targetEntity=Commodity.class)
	@JoinColumns({
		@JoinColumn(name="shoppingCart_id",referencedColumnName="shoppingCart_id"),
		@JoinColumn(name="shoppingCart_name",referencedColumnName="shoppingCart_name")
	})
	private Set<Commodity> commodities=new HashSet<>();
	@OneToOne
	@JoinColumn(name="account",referencedColumnName="account")
	private Account account;
	public ShoppingCart() {
		// TODO 自动生成的构造函数存根
	}
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj!=null&&obj.getClass()==ShoppingCart.class){
			ShoppingCart target= (ShoppingCart) obj;
			return target.getId().equals(this.id)&&target.getNumber().equals(this.number);
		}
		return false;
	}
	public int hashCode(){
		return getId().hashCode() *31+getNumber().hashCode();
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
