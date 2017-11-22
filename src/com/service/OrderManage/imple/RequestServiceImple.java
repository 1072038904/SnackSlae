package com.service.OrderManage.imple;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dao.OrderManage.RequestDao;
import com.model.Request;
import com.service.OrderManage.RequestService;
import com.service.common.imple.BaseServiceImple;
@Transactional
@Service
public class RequestServiceImple extends BaseServiceImple<Request> implements RequestService{
	@Resource
	private RequestDao requestDao;
	public RequestServiceImple() {
		// TODO Auto-generated constructor stub
	}
	public RequestDao getRequestDao() {
		return requestDao;
	}
	@Resource
	public void setRequestDao(RequestDao requestDao) {
		super.setBaseDao(requestDao);
		this.requestDao = requestDao;
	}

}
