package com.serviceimple.CommodityServiceImple;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CommodityManage.CommodityDao;
import com.model.Commodity;
import com.model.Snacks;
import com.util.GeneratedHql;
@Service
@Transactional
public class CommodityServiceImple implements com.service.CommodityService.CommodityService {
	@Autowired
	private CommodityDao commodityDao;
	public CommodityServiceImple() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveNewCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		commodityDao.save(commodity);
		
	}

	public CommodityDao getCommodityDao() {
		return commodityDao;
	}

	public void setCommodityDao(CommodityDao commodityDao) {
		this.commodityDao = commodityDao;
	}

	@Override
	public int isCommodityExisted(Commodity commodity) {
		// TODO Auto-generated method stub
		List<Commodity> ple=commodityDao.find(GeneratedHql.genHql("Commodity", "name",commodity.getName()));
		if(ple.isEmpty()==true){
			return 1;
		}
		return 2;
	}

	@Override
	public Commodity findCommodity(Commodity commodity) {
		// TODO Auto-generated method stub
		List<Commodity> ple=commodityDao.find(GeneratedHql.genHql("Commodity", "name",commodity.getName()));
		for(Object ele:ple){
			Commodity p=(Commodity)ele;
			return p;
		}
		return null;
	}
	

}
