package com.service.OrderManage;

import com.model.Account;
import com.model.OrderForm;
import com.service.common.BaseService;
import com.util.PageBean;

public interface OrderService extends BaseService<OrderForm>{

void confirmOrder(OrderForm orderForm);
PageBean findPastOrderPage(Account account, Class<OrderForm> entityClazz, Integer currentPage,Integer pageSize);
PageBean findEvalOrderPage(Account account, Class<OrderForm> entityClazz, Integer currentPage,Integer pageSize);
PageBean findPayOrderPage(Account account, Class<OrderForm> entityClazz, Integer currentPage,Integer pageSize);
PageBean findUnFirmOrderPage(Account account, Class<OrderForm> entityClazz, Integer currentPage,Integer pageSize);
}
