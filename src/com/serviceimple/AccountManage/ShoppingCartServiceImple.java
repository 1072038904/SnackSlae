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
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

}
