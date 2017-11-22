package com.action;


import java.util.Map;
import org.springframework.stereotype.Controller;

import com.action.common.BaseAction;
import com.model.Account;
import com.model.Commodity;
import com.model.ShoppingCart;
import com.opensymphony.xwork2.ActionContext;
import com.service.AccountManage.LoginService;
import com.service.CommodityService.CommodityService;
import com.service.ShoppingCart.ShoppingCartService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.PageBean;


@Controller
public class ShoppingCartAction extends BaseAction{
	private Integer id=new Integer(0);
	private Integer currentPage=new Integer(1);
	private ShoppingCart shoppingCart=new ShoppingCart();
	private PageBean pageBean=new PageBean();
	private Commodity commodity=new Commodity();
	private int number;
	public ShoppingCartAction() {
		// TODO Auto-generated constructor stub
	}

	public int getNumber() {
		return number;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public ShoppingCartService getShoppingCartService() {
		return shoppingCartService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}


	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}



	public CommodityService getCommodityService() {
		return commodityService;
	}

	public void setCommodityService(CommodityService commodityService) {
		this.commodityService = commodityService;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String saveShoppingCart(){
		Account account=(Account) session.get("account");
		System.out.println(account.getId());
		shoppingCart.setNumber(1);
		shoppingCart.setAccount(loginService.findAccount(account));
		Commodity tempCom=commodityService.findCommodityById(shoppingCart.getCommodity());
		shoppingCart.setCommodity(tempCom);
		ShoppingCart tempShoppingCart=shoppingCartService.findShopingCartByAccountAndCommodity(shoppingCart);
		if(tempShoppingCart!=null){
			tempShoppingCart.setNumber(tempShoppingCart.getNumber()+1);
			tempShoppingCart.setPrice(tempShoppingCart.getPrice()*tempShoppingCart.getNumber());
			shoppingCartService.updateEntity(tempShoppingCart);
			return "success";
		}
		shoppingCart.setPrice(tempCom.getPrice());
		System.out.println("2次"+shoppingCart.getAccount().getId());
		shoppingCartService.saveNewEntity(shoppingCart);
		findShoppingCartPage();
		return "success";
		
	}
	public String updateShoppingCart(){
		shoppingCart=shoppingCartService.findEnetityById(shoppingCart.getId(), ShoppingCart.class);
		shoppingCart.setNumber(number);
		shoppingCart.setPrice(shoppingCart.getCommodity().getPrice()*shoppingCart.getNumber());
		shoppingCartService.updateEntity(shoppingCart);
		return "success";
		
	}
	public String findShoppingCartPage(){
		Account account=(Account) session.get("account");
		if(shoppingCartService!=null)
		pageBean=shoppingCartService.findShopingCartByPageAccount(account.getAccount().toString(),ShoppingCart.class, currentPage, 5);
		session.put("pageBean", pageBean);
		return "success";
		
	}
	public String deleteShoppingCart(){
		shoppingCart=shoppingCartService.findEnetityById(shoppingCart.getId(), ShoppingCart.class);
		shoppingCartService.deleteEntity(shoppingCart);
		//删除之后要对缓存中数据进行更新
		return "success";
	}
	
}
