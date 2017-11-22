package com.dao.OrderManage.imple;

import org.springframework.stereotype.Repository;

import com.dao.OrderManage.RequestDao;
import com.dao.common.imple.BaseDaoHibernate4;
import com.model.Request;
@Repository
public class RequestDaoImple extends BaseDaoHibernate4<Request>implements RequestDao{

	public RequestDaoImple() {
		// TODO Auto-generated constructor stub
	}

}
