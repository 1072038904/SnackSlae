<%@ page contentType="text/html; charset=GBK" language="java" errorPage="" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="isvalid" method="post">
		<input type="text" name="account.userphone"/><br>
		<input type="password" name="account.password"/><br>
		<input	type="submit" value="Ìá½»"/>
	</s:form>

</body>
</html>