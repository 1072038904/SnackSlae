package com.daoimple.CommodityManage;

import org.springframework.stereotype.Repository;

import com.dao.CommodityManage.CommodityDao;
import com.daoimple.common.BaseDaoHibernate4;
import com.model.Commodity;
@Repository
public class CommodityDaoImple extends BaseDaoHibernate4<Commodity> implements CommodityDao{

	public CommodityDaoImple() {
	}

}
