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
		// TODO �Զ����ɵĹ��캯�����
	}
	public CommodityDao getCommodityDao() {
		return commodityDao;
	}
	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}
	@Override
	public void SaveNewCommodity(Commodity commodity) {
		// TODO �Զ����ɵķ������
		commodityDao.save(commodity);
	}

}
