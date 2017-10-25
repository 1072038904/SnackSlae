<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
<s:form action="isvalid" method="post">
		<label style="float:left">账号:</label><input type="text" name="account.account"/><br>
		<label>密码:</label><input type="password" name="account.password"/><br>
		<input	type="submit" value="登录"/>
	</s:form>
</div>
</body>
</html>