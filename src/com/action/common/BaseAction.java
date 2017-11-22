package com.action.common;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.stereotype.Controller;

import com.model.Request;
import com.service.AccountManage.LoginService;
import com.service.AccountManage.UserInforService;
import com.service.CommodityService.CommodityService;
import com.service.OrderManage.OrderService;
import com.service.OrderManage.RequestService;
import com.service.ShoppingCart.ShoppingCartService;
import com.service.SnacksManage.SnacksService;

@Controller
public class BaseAction implements SessionAware{
	@Resource
	protected ShoppingCartService shoppingCartService;
	@Resource
	protected UserInforService userInforService;
	@Resource
	protected LoginService loginService;
	@Resource
	protected SnacksService snacksService;
	@Resource
	protected CommodityService commodityService;
	@Resource
	protected RequestService requestService;
	@Resource
	protected OrderService orderService;

	protected Map<String, Object> session;
	public BaseAction() {
		// TODO Auto-generated constructor stub
	}
	
	public UserInforService getUserInforService() {
		return userInforService;
	}
	public void setUserInforService(UserInforService userInforService) {
		this.userInforService = userInforService;
	}
	public RequestService getRequestService() {
		return requestService;
	}
	public void setRequestService(RequestService requestService) {
		this.requestService = requestService;
	}
	public LoginService getLoginService() {
		return loginService;
	}
	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public SnacksService getSnacksService() {
		return snacksService;
	}
	public void setSnacksService(SnacksService snacksService) {
		this.snacksService = snacksService;
	}
	public CommodityService getCommodityService() {
		return commodityService;
	}
	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}
	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}
	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}
	public OrderService getOrderService() {
		return orderService;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

}
