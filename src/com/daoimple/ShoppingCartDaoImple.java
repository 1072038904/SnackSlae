package com.daoimple;

import org.springframework.stereotype.Repository;

import com.dao.ShoppingCartDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.ShoppingCart;
@Repository
public class ShoppingCartDaoImple extends BaseDaoHibernate4<ShoppingCart> implements ShoppingCartDao{

	public ShoppingCartDaoImple() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

}
