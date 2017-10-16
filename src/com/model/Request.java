package com.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
@Entity
public class Request {
	@Id@Column(name="request_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String specification;
	private int number;
	private String address;
	@OneToMany(targetEntity=Commodity.class)
	@JoinColumn(name="request_id",referencedColumnName="request_id")
	private Set<Commodity> commodities=new HashSet<>();
	public Request() {
		// TODO 自动生成的构造函数存根
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSpecification() {
		return specification;
	}
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Set<Commodity> getCommodities() {
		return commodities;
	}
	public void setCommodities(Set<Commodity> commodities) {
		this.commodities = commodities;
	}

}
