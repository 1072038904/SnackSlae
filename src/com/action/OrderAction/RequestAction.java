package com.action.OrderAction;

import com.action.common.BaseAction;
import com.model.Request;
import com.model.UserInfor;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class RequestAction extends BaseAction{
	private Request request=new Request();

	public RequestAction() {
		// TODO Auto-generated constructor stub
	}
	
	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}

	public String saveRequest(){
		
		return "success";
	}
}
