package com.daoimple;

import org.springframework.stereotype.Repository;

import com.dao.CommodityDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.Commodity;
@Repository
public class CommodityDaoImple extends BaseDaoHibernate4<Commodity> implements CommodityDao{

	public CommodityDaoImple() {
		// TODO �Զ����ɵĹ��캯�����
	}

}
