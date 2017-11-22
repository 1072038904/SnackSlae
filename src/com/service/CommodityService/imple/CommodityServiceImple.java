package com.service.CommodityService.imple;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dao.CommodityManage.CommodityDao;
import com.model.Commodity;
import com.service.common.imple.BaseServiceImple;
import com.util.GeneratedHql;
import com.util.PageBean;
@Service
@Transactional
public class CommodityServiceImple extends BaseServiceImple <Commodity>implements com.service.CommodityService.CommodityService {
	
	private CommodityDao commodityDao;
	public CommodityServiceImple() {
		// TODO Auto-generated constructor stub
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
	public Commodity findCommodityById(Commodity commodity) {
		// TODO Auto-generated method stub
		List<Commodity> ple=commodityDao.find(GeneratedHql.genHql("Commodity", "id",commodity.getId().toString()));
		for(Object ele:ple){
			Commodity p=(Commodity)ele;
			return p;
		}
		return null;
	}


	@Override
	public Commodity findCommodityByPri(String secClass) {
		// TODO Auto-generated method stub
		List<Commodity> ple=commodityDao.find(GeneratedHql.genHql("Commodity", "secClassification",secClass));
		for(Object ele:ple){
			Commodity p=(Commodity)ele;
			return p;
		}
		return null;
	}


	@Override
	public PageBean findCommodityByPageSecCategory(String category,Class<Commodity> entityClazz,Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
	    //Set Parameters totalRows
	    Long totalRows = commodityDao.findCount(entityClazz);
	    pageBean.setAllRow(totalRows);
	    pageBean.setCurrentPage(currentPage.intValue());
	    pageBean.setPageSize(pageSize.intValue()); 
	    //Initialize PageBean
	    pageBean.init();
	    //get the resultSet
	    List<Commodity> resultList = commodityDao.findByPage(GeneratedHql.genHql(entityClazz.getSimpleName()+" as s", "s.snacks.secClassification",category), currentPage, pageSize);
	    pageBean.setList(resultList);
	    return pageBean;
	}


	@Override
	public PageBean findCommodityByPagePackMethod(String category, Class<Commodity> entityClazz, Integer currentPage,
			Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
	    //Set Parameters totalRows
	    Long totalRows = commodityDao.findCount(entityClazz);
	    pageBean.setAllRow(totalRows);
	    pageBean.setCurrentPage(currentPage.intValue());
	    pageBean.setPageSize(pageSize.intValue()); 
	    //Initialize PageBean
	    pageBean.init();
	    //get the resultSet
	    List<Commodity> resultList = commodityDao.findByPage(GeneratedHql.genHql(entityClazz.getSimpleName()+" as s", "s.snacks.packMethod",category), currentPage, pageSize);
	    pageBean.setList(resultList);
	    return pageBean;
	}





}
