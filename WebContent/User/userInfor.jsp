<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link href="<%=basePath%>files/adminindex/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>files/form/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>files/h/styles.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<%=basePath%>css/style.css" rel='stylesheet' type='text/css' />

</head>		    
<!-- 导航栏 -->
<div class="header">
		<div class="container">
		<div class="menu">
		<ul class="nav navbar-nav">
        <li><a href="findAllUserCommodity.action" >商品首页</a></li>
        <li><a href="searchSnacks.jsp" >零食管理</a></li>
        <li><a href="#" >我的订单</a></li>
        <li><a href="#" >公告管理</a></li>
        <li><a href="searchShopingCartByPageAccount.action" >售后服务</a></li> 
</ul> 
</div>  
 <form class="navbar-form navbar-left"  action="searchCommodity" method="post"  role="search">
<div class="form-group">
<label class="sr-only"></label>
<s:textfield name="commodity.name" class="form-control" value="请输入查询商品的名字" />
</div>
<button type="submit" class="btn btn-default navbar-btn">搜索</button>    
<a href="userInfor.jsp" >
<button type="button" class="btn btn-default btn-sm">
    <span class="glyphicon glyphicon-user">&nbsp;${account.account}</span>	
</button>     </a>               
</form>
</div>
</div>  
<div class="normal">
<ul class="nav nav-tabs">
</ul>
</div>
			<div class="">
 				<form class="bootstrap-frm" role="form" action="saveUserInfor.action">
 					<fieldset>
					<legend>我的信息</legend>
					</fieldset>
									<input type="hidden" name="userInfor.id" value="${userInfor.id }">
 					<div class="form-group">
 						请输入姓名：<input name="userInfor.name" value="${userInfor.name }">
					</div>
					<div class="form-group">
 						请输入电话：<input name="userInfor.telephone" value="${userInfor.telephone }">
					</div>
					<div class="form-group">
 						请输入地址：<input name="userInfor.address" value="${ userInfor.address}">
					</div>
					<button id="saveInfor" class="btn btn-default">保存信息</button>
				</form>	
			</div>
</body>
	<script type="text/javascript">
	$('#saveInfor').click(function() {
		$('#saveInfor').submit();
	});
	</script>
</html>