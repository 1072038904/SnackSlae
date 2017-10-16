<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
		<div>
<s:form action="isregister" method="post">
		<label>账号: </label><input type="text" name="userInfor.account.account"/><br>
		<label>密码: </label><input type="password" name="userInfor.account.password"/><br>
		<label>姓名: </label><input type="text" name="userInfor.name"/><br>
		<label>电话: </label><input type="text" name="userInfor.telephone"/><br>
		<label>地址: </label><input type="text" name="userInfor.address"/><br>
		<input	type="submit" value="注册"/>
	</s:form>
	</div>
</body>
</html>