package com.serviceimple.CommodityServiceImple;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dao.CommodityManage.CommodityDao;
import com.model.Commodity;
import com.serviceimple.common.BaseServiceImple;
import com.util.GeneratedHql;
import com.util.PageBean;
@Service
@Transactional
public class CommodityServiceImple extends BaseServiceImple <Commodity>implements com.service.CommodityService.CommodityService {
	
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
	@Resource
	public void setCommodityDao(CommodityDao commodityDao) {
		super.setBaseDao(commodityDao);
		this.commodityDao = commodityDao;
	}

	@Override
	public int isCommodityExisted(Commodity commodity) {
		// TODO Auto-generated method stub
		List<Commodity> ple=commodityDao.find(GeneratedHql.genHql("Commodity", "name",commodity.getName()));
		if(ple.isEmpty()!=true){
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

	@Override
	public List<Commodity> findAllCommodity() {
		// TODO Auto-generated method stub	
		return commodityDao.findAll(Commodity.class);
	}




}
