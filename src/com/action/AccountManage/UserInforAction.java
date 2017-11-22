package com.action.AccountManage;

import org.springframework.stereotype.Controller;

import com.action.common.BaseAction;
import com.model.Account;
import com.model.UserInfor;
import com.sun.org.apache.bcel.internal.generic.NEW;

@Controller
public class UserInforAction extends BaseAction{
	private UserInfor userInfor=new UserInfor();
	private Account account=new Account();
	public UserInforAction() {
		// TODO Auto-generated constructor stub
	}
	public UserInfor getUserInfor() {
		return userInfor;
	}
	
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public void setUserInfor(UserInfor userInfor) {
		this.userInfor = userInfor;
	}
	public String saveUserInfor(){
		account=(Account) session.get("account");
		account=loginService.findAccount(account);
		userInfor.setAccount(account);
		if(userInfor!=null){
			userInforService.updateEntity(userInfor);
			session.put("userInfor",userInfor);
		}
		return "success";
	}
	
	public String findUserInfor(){
		account=(Account) session .get("account");
		userInfor=userInforService.findEnetityByAccount(account, UserInfor.class);
		session.put("userInfor",userInfor);
		return "success";
	}
}
