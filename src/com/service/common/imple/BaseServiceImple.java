package com.service.common.imple;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.transaction.Transactional;


import com.dao.common.BaseDao;
import com.model.Account;
import com.service.common.BaseService;
import com.util.GeneratedHql;
import com.util.PageBean;
@Transactional
public class BaseServiceImple <T>implements BaseService<T> {
	private BaseDao<T> baseDao;
	public BaseServiceImple() {
		// TODO Auto-generated constructor stub
	}
	
	public BaseDao<T> getBaseDao() {
		return baseDao;
	}

	public void setBaseDao(BaseDao<T> baseDao) {
		this.baseDao = baseDao;	
	}

	@Override
	public void saveNewEntity(T entity) {
		// TODO Auto-generated method stub
		baseDao.save(entity);
	}
	@Override
	public List<T> findAllEntity(Class<T> entityClazz) {
		// TODO Auto-generated method stub
		List<T> ple=baseDao.findAll(entityClazz);
		return ple;
	}

	@Override
	public void deleteEntity(T entity) {
		// TODO Auto-generated method stub
		baseDao.delete(entity);
		
	}

	@Override
	public void updateEntity(T entity) {
		// TODO Auto-generated method stub
		baseDao.update(entity);
	}

	@Override
	public PageBean findEntityByPage(Class<T> entityClazz,Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
	    //Set Parameters totalRows
	    Long totalRows = baseDao.findCount(entityClazz);
	    pageBean.setAllRow(totalRows);
	    pageBean.setCurrentPage(currentPage.intValue());
	    pageBean.setPageSize(pageSize.intValue()); 
	    //Initialize PageBean
	    pageBean.init();
	    //get the resultSet
	    List<T> resultList = baseDao.findByPage("from "+ entityClazz.getSimpleName(), currentPage, pageSize);
	    pageBean.setList(resultList);
	    return pageBean;
	}

	@Override
	public PageBean findEntityPageByName(String name,Class<T> entityClazz,Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
	    //Set Parameters totalRows
	    Long totalRows = baseDao.findCount(entityClazz);
	    pageBean.setAllRow(totalRows);
	    pageBean.setCurrentPage(currentPage.intValue());
	    pageBean.setPageSize(pageSize.intValue()); 
	    //Initialize PageBean
	    pageBean.init();
	    //get the resultSet
	    List<T> resultList = baseDao.findByPage(GeneratedHql.genHql(entityClazz.getSimpleName(), "name",name), currentPage, pageSize);
	    pageBean.setList(resultList);
	    return pageBean;
	}
	@Override
	public PageBean findEntityPageById(String name,Class<T> entityClazz,Integer currentPage, Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
	    //Set Parameters totalRows
	    Long totalRows = baseDao.findCount(entityClazz);
	    pageBean.setAllRow(totalRows);
	    pageBean.setCurrentPage(currentPage.intValue());
	    pageBean.setPageSize(pageSize.intValue()); 
	    //Initialize PageBean
	    pageBean.init();
	    //get the resultSet
	    List<T> resultList = baseDao.findByPage(GeneratedHql.genHql(entityClazz.getSimpleName(), "id",name), currentPage, pageSize);
	    pageBean.setList(resultList);
	    return pageBean;
	}

	@Override//有问题
	public T findEnetityByAccount(Account account,Class<T> entityClazz) {
		// TODO Auto-generated method stub
		System.out.println("from "+entityClazz.getSimpleName()+" as a where a.account.id ='"+account.getId()+"'");
		List<T> ple=baseDao.find("from "+entityClazz.getSimpleName()+" as a where a.account.id ='"+account.getId()+"'");
		for(Object ele:ple){
			@SuppressWarnings("unchecked")
			T t=(T) ele;
			return t;
		}
		return null;
	}
	@Override
	public T findEnetityById(Integer id,Class<T> entityClazz) {
		// TODO Auto-generated method stub
		//System.out.println("from "+entityClazz.getSimpleName()+" as a a.account.account ='"+account.getAccount()+"'");
		List<T> ple=baseDao.find("from "+entityClazz.getSimpleName()+" where id ='"+id.toString()+"'");
		for(Object ele:ple){
			@SuppressWarnings("unchecked")
			T t=(T)ele;
			return t;
		}
		return null;
	}

	@Override
	public PageBean findEntityPageByAccount(Account account, Class<T> entityClazz, Integer currentPage,
			Integer pageSize) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
	    //Set Parameters totalRows
	    Long totalRows = baseDao.findCount(entityClazz);
	    pageBean.setAllRow(totalRows);
	    pageBean.setCurrentPage(currentPage.intValue());
	    pageBean.setPageSize(pageSize.intValue()); 
	    //Initialize PageBean
	    pageBean.init();
	    //get the resultSet
	    List<T> resultList = baseDao.findByPage("from "+entityClazz.getSimpleName()+" as a where a.account.id ='"+account.getId()+"'"
	    		, currentPage, pageSize);
	    pageBean.setList(resultList);
	    return pageBean;
	}
	
}
