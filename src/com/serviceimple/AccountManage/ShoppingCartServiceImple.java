package com.serviceimple.AccountManage;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.ShoppingCartDao;
import com.service.AccountManage.ShoppingCartService;
@Service
@Transactional
public class ShoppingCartServiceImple implements ShoppingCartService {
@Autowired
private ShoppingCartDao shoppingCartDao;
	public ShoppingCartServiceImple() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

}
