package com.service.ShoppingCart;

import com.model.ShoppingCart;
import com.service.common.BaseService;
import com.util.PageBean;

public interface  ShoppingCartService extends BaseService<ShoppingCart>{
	ShoppingCart findShopingCartByAccountAndCommodity(ShoppingCart shoppingCart);
	PageBean findShopingCartByPageAccount(String account, Class<ShoppingCart> entityClazz, Integer currentPage,Integer pageSize);

}
