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
<title>商品管理-添加商品</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link href="<%=basePath%>files/form/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="<%=basePath%>css/style.css" rel='stylesheet' type='text/css' />
</head>
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
<li><a href="updateAllCommodity.action">修改商品</a></li>
<li><a href="searchCommodity.jsp">所有商品</a></li>
</ul>
</div>

<form class="bootstrap-frm" role="form" action="saveCommodity" method="post" enctype="multipart/form-data">
<s:textfield name="commodity.name" value="大袋牛肉干" />
<s:textfield name="commodity.shelfTime"  value="2017-10-24"/>
<s:textfield value="10.00" name="commodity.price"/>
<s:textfield value="1000" name="commodity.stock"/>
<s:label>选择商品的样品图片</s:label>
<s:file name="upload"  accept="image/gif,image/jpeg,image/jpg,image/png,image/svg" />
<s:select name="snacksName" list="snacks2" listKey="name" listValue="name"/>
      <button type="submit" class="btn btn-default">提交</button>
</form>

</body>
</html>