package com.service;

import com.model.Account;

public interface LoginService {


/**
 * @param 判断账号是否正确
 * @return String success or error
 * */
	public  int IsValid(Account account);
}
