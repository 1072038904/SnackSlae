package com.model;


import java.io.Serializable;

import javax.persistence.*;
@Entity
public class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2046045738166618185L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	//账号ֵ
	private String userphone;
	//密码ֵ
	private String password;
	//权限ֵ
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
	
	public String getUserphone() {
		return userphone;
	}
	public void setUserphone(String userphone) {
		this.userphone = userphone;
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
