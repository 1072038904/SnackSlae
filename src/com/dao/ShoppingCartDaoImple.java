package com.dao;

import org.springframework.stereotype.Repository;

import com.dao.common.imple.BaseDaoHibernate4;
import com.model.ShoppingCart;
@Repository
public class ShoppingCartDaoImple extends BaseDaoHibernate4<ShoppingCart> implements ShoppingCartDao{

	public ShoppingCartDaoImple() {
	}

	public static void main(String[] args) {

	}

}
