package com.serviceimple.AccountManage;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.RequestDao;
import com.service.AccountManage.RequestService;
@Service
@Transactional
public class RequestServiceImple implements RequestService {
@Autowired
private RequestDao requestDao;
	public RequestServiceImple() {
		// TODO �Զ����ɵĹ��캯�����
	}

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������

	}

	public RequestDao getRequestDao() {
		return requestDao;
	}

	public void setRequestDao(RequestDao requestDao) {
		this.requestDao = requestDao;
	}

}
