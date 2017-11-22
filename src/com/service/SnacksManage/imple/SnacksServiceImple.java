package com.service.SnacksManage.imple;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SnacksManage.SnacksDao;
import com.model.Snacks;
import com.service.SnacksManage.SnacksService;
import com.service.common.imple.BaseServiceImple;
import com.util.GeneratedHql;
@Service
@Transactional
public class SnacksServiceImple extends BaseServiceImple<Snacks>implements SnacksService{
	
	private SnacksDao snacksDao;
	public SnacksServiceImple() {
	}
	public SnacksDao getSnacksDao() {
		return snacksDao;
	}
	@Resource
	public void setSnacksDao(SnacksDao snacksDao) {
		super.setBaseDao(snacksDao);
		this.snacksDao = snacksDao;
		
	}
@Override
public void saveNewSnacks(Snacks snacks) {
	snacksDao.save(snacks);
}
@Override
public void mergeNewSnacks(Snacks snacks) {
	snacksDao.merge(snacks);
}
@Override
public int isSnacksExisted(Snacks snacks) {
	List <Snacks>ple=snacksDao.find(GeneratedHql.genHql("Snacks", "name",snacks.getName()));
	if(ple.isEmpty()==true){
	return 1;
	}
	else{
		return 2;
	}
}
@Override
public void saveAllSnacks(List<Snacks> list) {
	// TODO Auto-generated method stub
	snacksDao.saveAll(list);
}
@Override
public List<Snacks> findAllSnacks() {
	// TODO Auto-generated method stub
	List <Snacks> ple=snacksDao.find("from Snacks");
	//System.out.println(ple.size());
	return ple;
}
@Override
public Snacks findSnacks(Snacks snacks) {
	// TODO Auto-generated method stub
	List <Snacks>ple=snacksDao.find(GeneratedHql.genHql("Snacks", "name",snacks.getName()));
	System.out.println(snacks.getName()+ple.size());
	for(Object obj:ple){
		Snacks p=(Snacks) obj;
		return p;
	}
	return null;
}
}
