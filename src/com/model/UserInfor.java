package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class UserInfor {
	@Id@Column(name="userInfor_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String telephone;
	private String address;
	@OneToOne(targetEntity=Account.class) 
	@JoinColumn(name="account",referencedColumnName="account",unique=true)
	private Account account;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public UserInfor() {
		// TODO 自动生成的构造函数存根
	}

}
