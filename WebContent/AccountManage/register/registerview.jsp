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
		<label>�˺�: </label><input type="text" name="userInfor.account.account"/><br>
		<label>����: </label><input type="password" name="userInfor.account.password"/><br>
		<label>����: </label><input type="text" name="userInfor.name"/><br>
		<label>�绰: </label><input type="text" name="userInfor.telephone"/><br>
		<label>��ַ: </label><input type="text" name="userInfor.address"/><br>
		<input	type="submit" value="ע��"/>
	</s:form>
	</div>
</body>
</html>