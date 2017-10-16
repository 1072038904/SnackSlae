package com.daoimple;

import org.springframework.stereotype.Repository;

import com.dao.RequestDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.Request;
@Repository
public class RequestDaoImple extends BaseDaoHibernate4<Request> implements RequestDao{

	public RequestDaoImple() {
		// TODO 自动生成的构造函数存根
	}

}
