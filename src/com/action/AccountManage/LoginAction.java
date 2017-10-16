package com.action.AccountManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.model.Account;
import com.service.AccountManage.LoginService;
@Controller
public class LoginAction{

	@Autowired
	private LoginService loginService;
	private Account account;
	public LoginAction(LoginService loginService, Account account) {
		super();
		this.loginService = loginService;
		this.account = account;
	}
	public Account getAccount() {
		return account;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
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
		System.out.println(loginService.isValid(account));
		if(loginService==null)
		{
			return "eorror";
		}
		if(loginService.isValid(account)==1)
		return "success";
		else
			return "error";
	}
}
