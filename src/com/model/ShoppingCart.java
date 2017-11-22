package com.model;

import java.io.Serializable;
import javax.persistence.*;
@Entity
public class ShoppingCart implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8282460473588733175L;
	@Id@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private Integer number;
	private double price;
	@OneToOne
	@JoinColumn(name="commodity_id",referencedColumnName="commodity_id")
	private Commodity commodity=new Commodity();
	@OneToOne
	@JoinColumn(name="account_id",referencedColumnName="id")
	private Account account;
	public ShoppingCart() {
		// TODO �Զ����ɵĹ��캯�����
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
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Commodity getCommodity() {
		return commodity;
	}
	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}
	

}
