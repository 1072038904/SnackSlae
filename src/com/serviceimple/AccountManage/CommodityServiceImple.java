package com.serviceimple.AccountManage;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommodityDao;
import com.model.Commodity;
import com.service.AccountManage.CommodityService;
@Service
@Transactional
public class CommodityServiceImple implements CommodityService {
	@Autowired
private CommodityDao commodityDao;
	public CommodityServiceImple() {
		// TODO 自动生成的构造函数存根
	}
	public CommodityDao getCommodityDao() {
		return commodityDao;
	}
	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}
	@Override
	public void SaveNewCommodity(Commodity commodity) {
		// TODO 自动生成的方法存根
		commodityDao.save(commodity);
	}

}
