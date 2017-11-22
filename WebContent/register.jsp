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
<title>用户个人信息</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>files/adminindex/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>files/form/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>files/h/styles.css" type="text/css" rel="stylesheet"/>
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
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
        					<li><a href="User/findAllUserCommodity.action" >商品首页</a></li>
       						<li><a href="#" >XXXXX</a></li>
        					<li><a href="#" >我的订单</a></li>
       						<li><a href="#" >公告</a></li>
        					<li><a href="searchShopingCartByPageAccount.action" >我的购物车</a></li> 
						</ul>
					</div>  
 					<form class="navbar-form navbar-left"  action="searchCommodity" method="post"  role="search">
					<div class="form-group">
						<label class="sr-only"></label>
						<input name="commodity.name" class="form-control" value="请输入查询商品的名字">
					</div>
<button type="submit" class="btn btn-default navbar-btn">搜索</button>
<a href="findUserInfor.action" >
<button type="button" id="search" class="btn btn-default btn-sm">
    <span class="glyphicon glyphicon-user">未登录，请登录</span>	
</button>     </a>         
</form>
</div>
</div>  
</div>
</div>
<div>
     <div class="main">
      <div class="shop_top">
	     <div class="container">
						<form action="isregister"> 
								<div class="register-top-grid">
										<h3>PERSONAL INFORMATION</h3>
										<div>
											<span>姓名：<label>*</label></span>
											<input type="text" name="userInfor.name" maxlength="6"> 
										</div>
										<div>
											<span>电话：<label>*</label></span>
											<input type="text" name="userInfor.telephone" maxlength="11"> 
										</div>
										<div>
											<span>地址：<label>*</label></span>
											<input type="text" name="userInfor.address"> 
										</div>
								</div>
								<div class="clear"> </div>
								<div class="register-bottom-grid">
										<h3>LOGIN INFORMATION</h3>
										<div>
											<span>账号：<label>*</label></span>
											<input type="text" name="userInfor.account.account">
										</div>
										<div>
											<span>密码：<label>*</label></span>
											<input type="text" name="userInfor.account.password">
										</div>
										<div class="clear"> </div>
								</div>
								<div class="clear"> </div>
								<input  class="btn btn-danger" type="submit" value="注册信息"/>
						</form>
					</div>
		   </div>
	  </div>

</body>	
</html>