package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.mysql.fabric.xmlrpc.base.Data;

public class Order {
	@Id
	private Integer orderNumber;
	private Data creation;
	private String ContactName;
	private String ContactTele;
	//订单状态
	private String TransactionStaus;
	@OneToOne
	@JoinColumn(name="request_id")
	private Request request;
	@OneToOne
	@JoinColumn(name="account",referencedColumnName="account",unique=true)
	private Account account;
	public Order() {
		// TODO 自动生成的构造函数存根
	}
	public Integer getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(Integer orderNumber) {
		this.orderNumber = orderNumber;
	}
	public Data getCreation() {
		return creation;
	}
	public void setCreation(Data creation) {
		this.creation = creation;
	}
	public String getContactName() {
		return ContactName;
	}
	public void setContactName(String contactName) {
		ContactName = contactName;
	}
	public String getContactTele() {
		return ContactTele;
	}
	public void setContactTele(String contactTele) {
		ContactTele = contactTele;
	}
	public String getTransactionStaus() {
		return TransactionStaus;
	}
	public void setTransactionStaus(String transactionStaus) {
		TransactionStaus = transactionStaus;
	}
	public Request getRequest() {
		return request;
	}
	public void setRequest(Request request) {
		this.request = request;
	}

}
