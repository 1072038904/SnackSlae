package com.service.common;

import java.util.List;

import javax.persistence.Entity;

import com.model.Commodity;
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
void deleteEntity(T entity);
void updateEntity(T entity);
PageBean findEntityByPage(Class<T> entityClazz, Integer currentPage, Integer pageSize);
 PageBean findEntityByPage(String name,Class<T> entityClazz,Integer currentPage, Integer pageSize);

}
