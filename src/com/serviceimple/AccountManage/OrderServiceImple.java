package com.serviceimple.AccountManage;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.OrderDao;
import com.service.AccountManage.OrderService;
@Service
@Transactional
public class OrderServiceImple implements OrderService {
@Autowired
private OrderDao orderDao;
	public OrderServiceImple() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

}
