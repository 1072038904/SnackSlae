package com.action.AccountManage;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.ParentPackage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.action.common.BaseAction;
import com.model.Account;
import com.model.UserInfor;
import com.opensymphony.xwork2.ActionContext;
import com.service.AccountManage.LoginService;
import com.service.AccountManage.UserInforService;

@Controller
public class LoginAction extends BaseAction{
	private Account account =new Account();
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
	public LoginAction() {
	}
	public String execute() throws Exception{
		return "error";
	}
	public String Login()throws Exception{	
		if(loginService.isValid(account)==1){
			session.clear();
			account=loginService.findAccount(account);
			UserInfor userInfor=userInforService.findEnetityByAccount(account, UserInfor.class);
			session.put("account",account);
			session.put("userInfor", userInfor);
			if(account.getJurisdiction()==1)
			return "admin";
			else
			return "success";
		}
		else
			return "error";
	}
}
