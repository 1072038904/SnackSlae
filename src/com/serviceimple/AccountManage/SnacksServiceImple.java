package com.serviceimple.AccountManage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.SnacksDao;
import com.model.Snacks;
import com.service.AccountManage.SnacksService;
import com.util.GeneratedHql;
@Service
@Transactional
public class SnacksServiceImple implements SnacksService{
	@Autowired
	private SnacksDao snacksDao;
	public SnacksServiceImple() {
		// TODO 自动生成的构造函数存根
	}
	public SnacksDao getSnacksDao() {
		return snacksDao;
	}
	public void setSnacksDao(SnacksDao snacksDao) {
		this.snacksDao = snacksDao;
	}
@Override
public void saveNewSnacks(Snacks snacks) {
	// TODO 自动生成的方法存根
	snacksDao.save(snacks);
}
@Override
public Snacks findSnacks(Snacks snacks) {
	// TODO 自动生成的方法存根
	snacksDao.find(GeneratedHql.genHql("Snacks", "name",snacks.getName()));
	return null;
}
}
