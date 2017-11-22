package com.service.common;

import java.util.List;

import com.model.Account;
import com.util.PageBean;


public interface BaseService<T> {
	
void saveNewEntity(T entity);
/**
 * 返回 1即是存在 
 * 返回 2即是不存在
 * @param T
 * @return
 */
List <T>findAllEntity(Class<T> entityClazz);
public T findEnetityById(Integer id,Class<T> entityClazz);
void deleteEntity(T entity);
void updateEntity(T entity);
PageBean findEntityByPage(Class<T> entityClazz, Integer currentPage, Integer pageSize);
PageBean findEntityPageByName(String name,Class<T> entityClazz,Integer currentPage, Integer pageSize);
public PageBean findEntityPageById(String name,Class<T> entityClazz,Integer currentPage, Integer pageSize);
T findEnetityByAccount(Account account,Class <T>entityClazz);
PageBean findEntityPageByAccount(Account account,Class<T> entityClazz,Integer currentPage, Integer pageSize);
}
