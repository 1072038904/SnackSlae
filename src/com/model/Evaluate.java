package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
@Entity
public class Evaluate {
@Id@Column
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
private String Content;
@OneToOne(targetEntity=Account.class)
@JoinColumn(name="account_id",referencedColumnName="id")
private Account account;
@ManyToOne
@JoinColumn(name="commodity_id",referencedColumnName="commodity_id")
private Commodity commodity;
private int score;

	public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getContent() {
	return Content;
}

public void setContent(String content) {
	Content = content;
}

public int getScore() {
	return score;
}

public Account getAccount() {
	return account;
}

public void setAccount(Account account) {
	this.account = account;
}

public Commodity getCommodity() {
	return commodity;
}

public void setCommodity(Commodity commodity) {
	this.commodity = commodity;
}

public void setScore(int score) {
	this.score = score;
}

	public Evaluate() {
		// TODO Auto-generated constructor stub
	}

}
