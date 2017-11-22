package com.filter;

import com.model.Account;
import com.opensymphony.xwork2.*;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import java.util.*;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author  Yeeku.H.Lee kongyeeku@163.com
 * @version  1.0
 */
// Ȩ�޼���������̳�AbstractInterceptor��
public class AuthorityInterceptor
	extends AbstractInterceptor
{
	// ����Action��������ط���
	public String intercept(ActionInvocation invocation)
		throws Exception
	{
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
		Account user = (Account)session.get("account");
		if (user!= null)
		{
			return invocation.invoke();
		}
		session.put("message",true);
		return Action.LOGIN;
	}
}
