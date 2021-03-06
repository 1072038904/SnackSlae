package com.service.AccountManage.imple;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.AccountManage.LoginDao;
import com.model.Account;
import com.service.AccountManage.LoginService;
@Service
@Transactional
public class LoginServiceImple implements LoginService {
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
		// TODO �Զ����ɵķ������
		loginDao.save(account);
	}

	@Override
	public int isExisted(Account account) {
		// TODO Auto-generated method stub
		List<Account> pl =loginDao.find("from Account where account='"+account.getAccount()+"'");	
		if(pl.isEmpty()!=true){
			return 1;
		}
		return 2;
	}

	@Override
	public Account findAccount(Account account) {
		// TODO Auto-generated method stub
		List<Account> pl =loginDao.find("from Account where account='"+account.getAccount()+"'");	
			for (Object ele : pl)
		{
			Account p = (Account)ele;
			return p;
		}
		return null;

	}
	
}
