package com.daoimple;

import org.springframework.stereotype.Repository;

import com.dao.OrderDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.OrderForm;
@Repository
public class OrderDaoImple extends BaseDaoHibernate4<OrderForm> implements OrderDao{

	public OrderDaoImple() {
		// TODO �Զ����ɵĹ��캯�����
	}

}
