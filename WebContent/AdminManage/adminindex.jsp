<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上零食销售首页</title>
<link href="<%=basePath%>files/adminindex/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>files/h/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="<%=basePath%>css/style.css" rel='stylesheet' type='text/css' />
</head>
<body>
<!-- 导航栏 -->
<div class="header">
		<div class="container">
			<div class="row">
			  <div class="col-md-12">
					 <div class="menu">
		<ul class="nav navbar-nav">
        <li><a href="searchCommodity.jsp" >商品管理</a></li>
        <li><a href="#" >零食管理</a></li>
        <li><a href="#" >订单管理</a></li>
        <li><a href="#" >公告管理</a></li>
        <li><a href="#" >售后服务管理</a></li> 
</ul> 
</div>  
 <form class="navbar-form navbar-left"  action="searchCommodity" method="post"  role="search">
<div class="form-group">
<label class="sr-only"></label>
<s:textfield name="commodity.name" class="form-control" value="请输入查询商品的名字" />
</div>
<button type="submit" class="btn btn-default navbar-btn">搜索</button>                  
</form>
</div>
</div>  
</div>
</div>
<div class="normal">
<ul class="nav nav-tabs">
<li><a href="addCommodity.action">添加商品</a></li>
<li><a href="findAllSnacks.action">删除商品</a></li>
<li><a href="findAllSnacks.action">修改商品</a></li>
<li><a href="findAllCommodity.jsp">所有商品</a></li>
</ul>
</div>

</body>
</html>