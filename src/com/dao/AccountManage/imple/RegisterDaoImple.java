package com.dao.AccountManage.imple;

import org.springframework.stereotype.Repository;

import com.dao.AccountManage.RegisterDao;
import com.dao.common.imple.BaseDaoHibernate4;
import com.model.UserInfor;
@Repository
public class RegisterDaoImple extends BaseDaoHibernate4<UserInfor> implements RegisterDao{

	public RegisterDaoImple() {
		// TODO �Զ����ɵĹ��캯�����
	}

}
