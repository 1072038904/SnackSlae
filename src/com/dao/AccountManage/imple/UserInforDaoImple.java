package com.dao.AccountManage.imple;


import org.springframework.stereotype.Repository;

import com.dao.AccountManage.UserInforDao;
import com.dao.common.imple.BaseDaoHibernate4;
import com.model.UserInfor;
@Repository
public class UserInforDaoImple extends BaseDaoHibernate4<UserInfor> implements UserInforDao{

	public UserInforDaoImple() {
		// TODO Auto-generated constructor stub
	}


}
