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
        					<li><a href="findAllUserCommodity.action" >商品首页</a></li>
       						<li><a href="searchSnacks.jsp" >零食管理</a></li>
        					<li><a href="#" >我的订单</a></li>
       						<li><a href="#" >公告</a></li>
        					<li><a href="searchShopingCartByPageAccount.action" >售后服务</a></li> 
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
    <span class="glyphicon glyphicon-user">未登录,请登录</span>	
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
			<div class="col-md-6">
				 <div class="login-page">
					<h4 class="title">New Customers</h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis</p>
					<div class="button1">
					   <a href="register.jsp"><input type="submit" name="Submit" value="Create an Account"></a>
					 </div>
					 <div class="clear"></div>
				  </div>
				</div>
				<div class="col-md-6">
				 <div class="login-title">
	           		<h4 class="title">Registered Customers</h4>
					<div id="loginbox" class="loginbox">
						<form action="isvalid" method="post" name="login" id="login-form">
						  <fieldset class="input">
						    <p id="login-form-username">
						      <label for="modlgn_username">Account</label>
						      <input id="modlgn_username" type="text" name="account.account" class="inputbox" size="18" autocomplete="off">
						    </p>
						    <p id="login-form-password">
						      <label for="modlgn_passwd">Password</label>
						      <input id="modlgn_passwd" type="password" name="account.password" class="inputbox" size="18" autocomplete="off">
						    </p>
						    <div class="remember">
							    <p id="login-form-remember">
							      <label for="modlgn_remember"><a href="#">Forget Your Password ? </a></label>
							   </p>
							    <input type="submit" name="Submit" class="button" value="Login"><div class="clear"></div>
							 </div>
						  </fieldset>
						 </form>
					</div>
			      </div>
				 <div class="clear"></div>
			  </div>
			</div>
		  </div>
	  </div>
</div>
</body>
</html>