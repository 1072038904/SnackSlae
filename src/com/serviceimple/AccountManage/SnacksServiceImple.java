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
		// TODO �Զ����ɵĹ��캯�����
	}
	public SnacksDao getSnacksDao() {
		return snacksDao;
	}
	public void setSnacksDao(SnacksDao snacksDao) {
		this.snacksDao = snacksDao;
	}
@Override
public void saveNewSnacks(Snacks snacks) {
	// TODO �Զ����ɵķ������
	snacksDao.save(snacks);
}
@Override
public Snacks findSnacks(Snacks snacks) {
	// TODO �Զ����ɵķ������
	snacksDao.find(GeneratedHql.genHql("Snacks", "name",snacks.getName()));
	return null;
}
}
