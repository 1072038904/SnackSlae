package com.service.CommodityService;

import java.util.List;

import com.model.Commodity;
import com.service.common.BaseService;



public interface CommodityService extends BaseService<Commodity>{
void saveNewCommodity(Commodity commodity);
int isCommodityExisted(Commodity commodity);
public Commodity findCommodity(Commodity commodity);
List <Commodity>findAllCommodity();

}
