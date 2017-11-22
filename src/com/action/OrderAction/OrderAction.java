package com.action.OrderAction;

import org.springframework.stereotype.Controller;

import com.action.common.BaseAction;
import com.model.Account;
import com.model.Commodity;
import com.model.OrderForm;
import com.model.Request;
import com.model.ShoppingCart;
import com.model.UserInfor;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.util.OrderFormUtil;
import com.util.PageBean;

@Controller
public class OrderAction extends BaseAction {
	private ShoppingCart shoppingCart = new ShoppingCart();
	private Integer currentPage = new Integer(1);
	private OrderForm orderForm = new OrderForm();
	private Request request = new Request();
	private String temp;// 需求说明
	private String id;// 需求id
	private Integer orderFormId = new Integer(0);
	private Commodity commodity;

	public OrderAction() {
		// TODO Auto-generated constructor stub
	}

	public Integer getOrderFormId() {
		return orderFormId;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public void setOrderFormId(Integer orderFormId) {
		this.orderFormId = orderFormId;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public ShoppingCart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(ShoppingCart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public String saveOrderForm() {
		// 找出对应的购物车对象
		OrderForm orderForm = new OrderForm();
		Request request = new Request();
		ShoppingCart tempCart = shoppingCartService.findEnetityById(shoppingCart.getId(), ShoppingCart.class);
		// 保存cart持久化对象
		// orderForm.getRequest().setShoppingCart(tempCart);
		Commodity commodity = commodityService.findCommodityById(tempCart.getCommodity());
		if (commodity.getStock() != 0) {
			commodity.setStock(commodity.getStock() - 1);
			commodity.setSalesVolume(commodity.getSalesVolume() + 1);
		}
		commodityService.updateEntity(commodity);
		request.intial(tempCart);
		UserInfor temp = (UserInfor) session.get("userInfor");
		request.setAddress(temp.getAddress());
		request.setSpecification(request.getSpecification());
		// 保存地址
		if (requestService != null)
			requestService.saveNewEntity(request);
		orderForm.setRequest(request);
		// 订单需求保存完毕
		// 订单信息保存开始
		Account account = (Account) session.get("account");
		String id = OrderFormUtil.getRandomNumber(account.getAccount()) + tempCart.getId();// 生成订单号+加上购物车id保证唯一性
		orderForm.setOrderId(id);// 保存订单号
		orderForm.setAccount(loginService.findAccount(account));// 保存账号外键
		orderForm.setCreationDate(OrderFormUtil.getDat());// 保存创建日期
		orderForm.setContactTele(temp.getTelephone());
		orderForm.setContactName(temp.getName());
		orderForm.setTransactionStaus("待确认");
		orderService.saveNewEntity(orderForm);
		return "success";
	}

	public String findOrderPageByAccount() {
		Account account = (Account) session.get("account");
		PageBean pageBean = orderService.findEntityPageByAccount(account, OrderForm.class, currentPage, 5);
		session.put("order", pageBean);
		return "success";
	}

	public String confirmOrder() {
		System.out.println(id + temp);
		request = requestService.findEnetityById(Integer.valueOf(id), Request.class);
		request.setSpecification(temp);
		requestService.updateEntity(request);
		orderForm = orderService.findEnetityById(orderFormId, OrderForm.class);
		orderForm.setTransactionStaus("用户已经付款");
		orderService.updateEntity(orderForm);
		return "success";
	}

	public String deleteOrder() {
		orderService.deleteEntity(orderForm);
		return "success";
	}

	public String findPastOrderPage() {
		Account account = (Account) session.get("account");
		PageBean pageBean = orderService.findPastOrderPage(account, OrderForm.class, currentPage, 5);
		System.out.println(pageBean.getList().size());
		session.put("order", pageBean);
		return "success";
	}

	public String findPayOrderPage() {
		Account account = (Account) session.get("account");
		PageBean pageBean = orderService.findPayOrderPage(account, OrderForm.class, currentPage, 5);
		System.out.println(pageBean.getList().size());
		session.put("order", pageBean);
		return "success";
	}

	public String findEvalOrderPage() {
		Account account = (Account) session.get("account");
		PageBean pageBean = orderService.findEvalOrderPage(account, OrderForm.class, currentPage, 5);
		System.out.println(pageBean.getList().size());
		session.put("order", pageBean);
		return "success";
	}

	public String findUnFirmOrderPage() {
		Account account = (Account) session.get("account");
		PageBean pageBean = orderService.findUnFirmOrderPage(account, OrderForm.class, currentPage, 5);
		System.out.println(pageBean.getList().size());
		session.put("order", pageBean);
		return "success";
	}

	public String returnOrder() {
		Request request = requestService.findEnetityById(Integer.valueOf(id), Request.class);
		Commodity temp = commodityService.findCommodityById(commodity);
		temp.setStock(temp.getStock() + 1);
		temp.setSalesVolume(temp.getSalesVolume() - 1);
		OrderForm orderForm = orderService.findEnetityById(orderFormId, OrderForm.class);
		orderService.deleteEntity(orderForm);
		requestService.deleteEntity(request);
		findPayOrderPage();
		return "success";
	}

}
