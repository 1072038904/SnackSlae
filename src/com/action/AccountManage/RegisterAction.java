package com.action.AccountManage;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import com.model.UserInfor;
import com.service.AccountManage.LoginService;
import com.service.AccountManage.RegisterService;

@Controller
public class RegisterAction {
	@Resource
private RegisterService registerService;
	@Resource
	private LoginService loginService;
	private UserInfor userInfor;
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public RegisterService getRegisterService() {
		return registerService;
	}
	public void setRegisterService(RegisterService registerService) {
		this.registerService = registerService;
	}
	public UserInfor getUserInfor() {
		return userInfor;
	}
	public void setUserInfor(UserInfor userInfor) {
		this.userInfor = userInfor;
	}
	public RegisterAction() {
		// TODO 自动生成的构造函数存根
	}
	public String execute() throws Exception{
		return "error";
	}
	public String Register()throws Exception{
		int judge=registerService.isRegister(userInfor);
		System.out.println(userInfor.getAccount().getAccount());
		if(judge==1){
			loginService.saveAccount(userInfor.getAccount());
			registerService.saveUserInfor(userInfor);
			return "success";
		}
		return "eorror";
	}
	
}
