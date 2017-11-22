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
        <li><a href="searchSnacks.jsp" >零食管理</a></li>
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
<li><a href="addSnacks.jsp">添加零食</a></li>
<li><a href="findAllSnacks.action">所有零食</a></li>
</ul>
</div>
 <s:iterator value="%{commodity}" var="sa">
 <div class="main">
      <div class="shop_top">
		<div class="container">
			<div class="row shop_box-top">
		<div class="col-md-3 shop_box"><a href="<%=basePath%>${commodity.picturePath}">
					<img src="<%=basePath%>${commodity.picturePath}" class="img-responsive" alt=""/></a>
					<span class="new-box">
						<span class="new-label">New</span>
					</span>
					<div class="shop_desc">
						<h3> <s:property value="#sa.name"/></h3>
						<p>上架时间:<s:property value="#sa.shelfTime"/></p>
						<p>销售量:<s:property value="#sa.salesVolume" />
						库存:<s:property value="#sa.stock" /></p>						
						<span class="actual">￥<s:property value="#sa.price" /></span><br>
						<ul class="buttons">
							<li class="cart"><a href="#">添加进购物车</a></li>
							<li class="shop_btn"><a href="#">Read More</a></li>					
					    </ul>
				    </div>
				</div>
				</div>
				</div>
				</div>
</div>			
	</s:iterator>
</body>
</html>