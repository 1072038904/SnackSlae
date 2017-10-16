package com.service.AccountManage;

import com.model.UserInfor;

public interface RegisterService {
/**
 * 判断账号是否注册成功 
 * @return 1:成功 2:失败
 */
	int isRegister(UserInfor userInfor);
	/**
	 * 判断客户注册信息的账号是否存在
	 * 
	 * @param userInfor
	 * @return true:存在 false:不存在
	 */
	boolean isExisted(UserInfor userInfor);
	void saveUserInfor(UserInfor userInfor);
}
