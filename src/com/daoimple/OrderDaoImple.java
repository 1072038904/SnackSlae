package com.daoimple;

import org.springframework.stereotype.Repository;

import com.dao.OrderDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.Order;
@Repository
public class OrderDaoImple extends BaseDaoHibernate4<Order> implements OrderDao{

	public OrderDaoImple() {
		// TODO 自动生成的构造函数存根
	}

}
