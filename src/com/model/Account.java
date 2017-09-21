package com.model;


import java.io.Serializable;

import javax.persistence.*;
@Entity
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2046045738166618185L;
	@Id@Column(name="account_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private  Integer account;
	private String password;
	private Integer jurisdiction;
	public Integer getId() {
		return id;
	}
	public Integer getJurisdiction() {
		return jurisdiction;
	}
	public void setJurisdiction(Integer jurisdiction) {
		this.jurisdiction = jurisdiction;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getAccount() {
		return account;
	}
	public void setAccount(Integer account) {
		this.account = account;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
