package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.messaging.support.IdTimestampMessageHeaderInitializer;
@Entity
public class Request {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String specification;//特殊说明
	private String address;//送货地址
	private Integer number;
	private double price;
	@OneToOne
	@JoinColumn(name="commodity_id",referencedColumnName="commodity_id")
	private Commodity commodity;
	public Request() {
	}
	public void intial(ShoppingCart shoppingCart){
		this.number=shoppingCart.getNumber();
		this.price=shoppingCart.getPrice();
		this.commodity=shoppingCart.getCommodity();
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
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

}
