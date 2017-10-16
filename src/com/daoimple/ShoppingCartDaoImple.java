package com.daoimple;

import org.springframework.stereotype.Repository;

import com.dao.ShoppingCartDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.ShoppingCart;
@Repository
public class ShoppingCartDaoImple extends BaseDaoHibernate4<ShoppingCart> implements ShoppingCartDao{

	public ShoppingCartDaoImple() {
		// TODO 自动生成的构造函数存根
	}

	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
