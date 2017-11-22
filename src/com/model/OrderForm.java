	package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class OrderForm {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String orderId;
	private String creationDate;//订单创建日期
	private String contactName;//订单联系人
	private String contactTele;//订单联系方式
	private String transactionStaus;//订单状态
	@OneToOne(targetEntity=Request.class)
	@JoinColumn(name="request_id",referencedColumnName="id")
	private Request request;
	@OneToOne(targetEntity=Account.class)
	@JoinColumn(name="account_id",referencedColumnName="id")
	private Account account;
	public OrderForm() {
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getOrderId() {
		return orderId;
	}



	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	public String getContactName() {
		return contactName;
	}



	public void setContactName(String contactName) {
		this.contactName = contactName;
	}



	public String getContactTele() {
		return contactTele;
	}



	public void setContactTele(String contactTele) {
		this.contactTele = contactTele;
	}



	public String getTransactionStaus() {
		return transactionStaus;
	}



	public void setTransactionStaus(String transactionStaus) {
		this.transactionStaus = transactionStaus;
	}



	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
