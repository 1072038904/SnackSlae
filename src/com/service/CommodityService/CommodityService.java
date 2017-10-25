package com.service.CommodityService;

import com.model.Commodity;
import com.model.Snacks;

public interface CommodityService {
void saveNewCommodity(Commodity commodity);
int isCommodityExisted(Commodity commodity);
public Commodity findCommodity(Commodity commodity);
}
