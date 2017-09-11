package com.daoimple;
import org.springframework.stereotype.Repository;

import com.dao.LoginDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.Account;
@Repository
public class LoginDaoImple extends BaseDaoHibernate4<Account>implements LoginDao{

	public LoginDaoImple() {
		// TODO 自动生成的构造函数存根
	}

}
