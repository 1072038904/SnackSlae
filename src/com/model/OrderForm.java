package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class OrderForm {
	@Id@Column(name="order_number")
	private Integer number;
	private String creationDate;
	private String ContactName;
	private String ContactTele;
	private String TransactionStaus;
	@OneToOne(targetEntity=Request.class)
	@JoinColumn(name="request_id",referencedColumnName="request_id")
	private Request request;
	@OneToOne(targetEntity=Account.class)
	@JoinColumn(name="account",referencedColumnName="account")
	private Account account;
	public OrderForm() {
		// TODO 自动生成的构造函数存根
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
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

	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
