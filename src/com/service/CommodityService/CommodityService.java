package com.service.CommodityService;

import com.model.Commodity;
import com.service.common.BaseService;
import com.util.PageBean;



public interface CommodityService extends BaseService<Commodity>{
int isCommodityExisted(Commodity commodity);
public Commodity findCommodity(Commodity commodity);
public Commodity findCommodityById(Commodity commodity);
public Commodity findCommodityByPri(String  secClass);
public PageBean findCommodityByPageSecCategory(String category,Class<Commodity> entityClazz,Integer currentPage, Integer pageSize);
public PageBean findCommodityByPagePackMethod(String category,Class<Commodity> entityClazz,Integer currentPage, Integer pageSize);
}
