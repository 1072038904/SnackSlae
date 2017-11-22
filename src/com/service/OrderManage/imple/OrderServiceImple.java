package com.service.OrderManage.imple;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.dao.OrderManage.OrderDao;
import com.model.Account;
import com.model.OrderForm;
import com.service.OrderManage.OrderService;
import com.service.common.imple.BaseServiceImple;
import com.util.PageBean;
@Service
@Transactional
public class OrderServiceImple  extends BaseServiceImple<OrderForm> implements OrderService{

private OrderDao orderDao;
	public OrderServiceImple() {
	}

	public OrderDao getOrderDao() {
		return orderDao;
	}
	@Resource
	public void setOrderDao(OrderDao orderDao) {
		super.setBaseDao(orderDao);
		this.orderDao = orderDao;
	}

	@Override
	public void confirmOrder(OrderForm orderForm) {
		// TODO Auto-generated method stub
		orderDao.update(orderForm);
	}

	@Override
	public PageBean findPastOrderPage(Account account, Class<OrderForm> entityClazz, Integer currentPage,Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
	    //Set Parameters totalRows
	    Long totalRows = orderDao.findCount(entityClazz);
	    pageBean.setAllRow(totalRows);
	    pageBean.setCurrentPage(currentPage.intValue());
	    pageBean.setPageSize(pageSize.intValue()); 
	    //Initialize PageBean
	    pageBean.init();
	    //get the resultSet
	    List<OrderForm> resultList = orderDao.findByPage("from "+entityClazz.getSimpleName()+" as a where a.account.id ='"+account.getId()+
	    		"'and a.transactionStaus!='待确认'"
	    		, currentPage, pageSize);
	    pageBean.setList(resultList);
	    return pageBean;
	}

	@Override
	public PageBean findEvalOrderPage(Account account, Class<OrderForm> entityClazz, Integer currentPage,
			Integer pageSize) {
		// TODO Auto-generated method stub
				PageBean pageBean = new PageBean();
			    //Set Parameters totalRows
			    Long totalRows = orderDao.findCount(entityClazz);
			    pageBean.setAllRow(totalRows);
			    pageBean.setCurrentPage(currentPage.intValue());
			    pageBean.setPageSize(pageSize.intValue()); 
			    //Initialize PageBean
			    pageBean.init();
			    //get the resultSet
			    List<OrderForm> resultList = orderDao.findByPage("from "+entityClazz.getSimpleName()+" as a where a.account.id ='"+account.getId()+
			    		"'and a.transactionStaus='商家已经确认'"
			    		, currentPage, pageSize);
			    pageBean.setList(resultList);
			    return pageBean;
	}

	@Override
	public PageBean findPayOrderPage(Account account, Class<OrderForm> entityClazz, Integer currentPage,
			Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
	    //Set Parameters totalRows
	    Long totalRows = orderDao.findCount(entityClazz);
	    pageBean.setAllRow(totalRows);
	    pageBean.setCurrentPage(currentPage.intValue());
	    pageBean.setPageSize(pageSize.intValue()); 
	    //Initialize PageBean
	    pageBean.init();
	    //get the resultSet
	    List<OrderForm> resultList = orderDao.findByPage("from "+entityClazz.getSimpleName()+" as a where a.account.id ='"+account.getId()+
	    		"'and a.transactionStaus='用户已经付款'"
	    		, currentPage, pageSize);
	    pageBean.setList(resultList);
	    return pageBean;
	}

	@Override
	public PageBean findUnFirmOrderPage(Account account, Class<OrderForm> entityClazz, Integer currentPage,
			Integer pageSize) {
		// TODO Auto-generated method stub
				PageBean pageBean = new PageBean();
			    //Set Parameters totalRows
			    Long totalRows = orderDao.findCount(entityClazz);
			    pageBean.setAllRow(totalRows);
			    pageBean.setCurrentPage(currentPage.intValue());
			    pageBean.setPageSize(pageSize.intValue()); 
			    //Initialize PageBean
			    pageBean.init();
			    //get the resultSet
			    List<OrderForm> resultList = orderDao.findByPage("from "+entityClazz.getSimpleName()+" as a where a.account.id ='"+account.getId()+
			    		"'and a.transactionStaus='待确认'"
			    		, currentPage, pageSize);
			    pageBean.setList(resultList);
			    return pageBean;
	}

}
