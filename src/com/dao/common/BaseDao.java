package com.dao.common;

import java.util.List;
import java.io.Serializable;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public interface BaseDao<T>
{
	T get(Class<T> entityClazz , Serializable id);
	Serializable save(T entity);
	void update(T entity);
	void delete(T entity);
	void delete(Class<T> entityClazz , Serializable id);
	List<T> findAll(Class<T> entityClazz);
	long findCount(Class<T> entityClazz);
	List<T> find(String hql);
	Object merge(T entity);
	void saveAll(List <T>list);
	public List<T> findByPage(String hql,
			 int pageNo, int pageSize);
}
