package com.daoimple.AccountManage;

import org.springframework.stereotype.Repository;

import com.dao.AccountManage.RegisterDao;
import com.daoimple.common.BaseDaoHibernate4;

import com.model.UserInfor;
@Repository
public class RegisterDaoImple extends BaseDaoHibernate4<UserInfor> implements RegisterDao{

	public RegisterDaoImple() {
		// TODO �Զ����ɵĹ��캯�����
	}

}
