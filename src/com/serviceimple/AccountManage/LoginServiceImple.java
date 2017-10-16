package com.serviceimple.AccountManage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AccountManage.LoginDao;
import com.model.Account;
import com.service.AccountManage.LoginService;
@Service
@Transactional
public class LoginServiceImple implements LoginService{
@Autowired
	private LoginDao loginDao;
	public LoginServiceImple() {
		// TODO 
	}

	public LoginServiceImple(LoginDao loginDao) {
		super();
		this.loginDao = loginDao;
	}
	@Override
	public int isValid(Account account) {
		// TODO 
		List<Account> pl =loginDao.find("from Account where account='"+account.getAccount()+"'");	
			if(pl.isEmpty()!=true){
				for (Object ele : pl)
			{
				Account p = (Account)ele;
				if(account.getPassword().equals(p.getPassword()))
				return 1;
			}
			}
			return 2;
	}

	@Override
	public void saveAccount(Account account) {
		// TODO 自动生成的方法存根
		loginDao.save(account);
	}
	
}
