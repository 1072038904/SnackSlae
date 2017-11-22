package com.action.AccountManage;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.action.common.BaseAction;
import com.model.UserInfor;
import com.service.AccountManage.RegisterService;

@Controller
public class RegisterAction extends BaseAction{
	@Resource
private RegisterService registerService;
	private UserInfor userInfor= new UserInfor();

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
	}
	public String execute() throws Exception{
		return "error";
	}
	public String Register()throws Exception{
		if(loginService.isExisted(userInfor.getAccount())==1){
			return "existed";
		}
		else{
			userInfor.getAccount().setJurisdiction(2);
			loginService.saveAccount(userInfor.getAccount());
			userInforService.saveNewEntity(userInfor);
			return "success";
		}
	}
	
}
