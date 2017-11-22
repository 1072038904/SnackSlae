package com.dao.OrderManage.imple;

import org.springframework.stereotype.Repository;

import com.dao.OrderManage.OrderDao;
import com.dao.common.imple.BaseDaoHibernate4;
import com.model.OrderForm;
@Repository
public class OrderDaoImple extends BaseDaoHibernate4<OrderForm> implements OrderDao{

	public OrderDaoImple() {
		
	}

}
