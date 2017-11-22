<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="s" uri="/struts-tags"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html >
<html>
<head>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>files/form/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="<%=basePath%>css/style.css" rel='stylesheet' type='text/css' />
    <link rel="<%=basePath%>stylesheet" type="text/css" href="css/reset.css" media="screen" />
    <link rel="<%=basePath%>stylesheet" type="text/css" href="css/text.css" media="screen" />	
    <link href="css/table/demo_page.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript">
      
      function add(id){
    	  document.shoppingcart.action="saveUserShoppingCart.action";
    	  document.shoppingcart.submit();
    	  alert("已经添加进购物车");
			return true;
    	  }
        $(document).ready(function () {
            setupLeftMenu();

            $('.datatable').dataTable();
			setSidebarHeight();


        });</script>
<title>所有商品显示</title>

</head>

<body>
<!-- 导航栏 -->
<div class="header">
		<div class="container">
			<div class="row">
			  <div class="col-md-12">
					 <div class="menu">
		<ul class="nav navbar-nav">
        <li><a href="searchUserCommodity.jsp" >商品首页</a></li>
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
<a href="findUserInfor.action" >
<button type="button" class="btn btn-default btn-sm">
	<c:if test="${account!=null}">
    <span class="glyphicon glyphicon-user">&nbsp;${account.account}</span>	
    </c:if>
    <c:if test="${account==null}">
    <span class="glyphicon glyphicon-user">未登录,请登录</span>	
    </c:if>
</button></a>                 
</form>
</div>
</div>  
</div>
</div>

<!-- 
<div class="container">
<form class="navbar-form navbar-left"  action="searchCommodityPage" method="post"  role="search">
<s:textfield name="commodity.name" class="form-control" value="请输入查询商品的名字" />
<button type="submit" class="btn btn-default navbar-btn">搜索</button>                  
</form>
<div  style="width:600px;"class="table table-bordered ">

 -->

<div class="breadcrumb">
<s:iterator value="commodityClassifications" >

<li class="active"><s:property value="pri"/></li>
     <c:forEach items="${sec}" var="item" varStatus="status">
     	<li><a href="#?pri=${item}">${item}</a></li>
     </c:forEach>
     <br>
</s:iterator>
</div>
 <form class="navbar-form navbar-left"  action="searchCommodityPage" method="post"  role="search">
<s:textfield name="commodity.name" class="form-control" value="请输入查询商品的名字" />
<button type="submit" class="btn btn-default navbar-btn">搜索</button>  
</form>

     <div class="main">
      <div class="shop_top">
		<div class="container">
			<div class="row shop_box-top">
<s:iterator value="pageBean.list" >
		<div class="col-md-3 shop_box"><a href="<%=basePath%>${picturePath}">
					<img src="<%=basePath%>${picturePath}" height="200" alt=""/></a>
					<span class="new-box">
						<span class="new-label">New</span>
					</span>
					<form id="shoppingcart" action="saveUserShoppingCart.action" method="post">
					<!-- 需要传入的参数有 商品id  -->					
						<input type="hidden" name="id" value="<s:property value="id"/>"/>
					<div class="shop_desc">
						<h3> <s:property value="name"/></h3>
						<p>上架时间:<s:property value="shelfTime"/></p>
						<p>销售量:<s:property value="salesVolume" />
						库存:<s:property value="stock" /></p>						
						<span class="actual">￥<s:property value="price" /></span><br>
						
						<ul class="buttons">
							<li class="cart">
						<li><input class="btn btn-default navbar-btn" type="submit" value="添加进购物车"></li>
							<li class="shop_btn"><s:url var="addshoppingcart" value="findAllUserCommodity.action">
                        <s:param name="currentPage" value="pageBean.currentPage-1"></s:param>
                    </s:url>				
					    </ul>
				    </div></form>
</div>
</s:iterator>
</div>
<td style="width:100px">
                <s:if test="pageBean.firstPage">
                    <s:url var="getUsers_first" value="findAllUserCommodity.action">
                        <s:param name="currentPage" value="1"></s:param>
                    </s:url>
                    <s:a href="%{getUsers_first}">首页</s:a>
                </s:if>
                <s:else>
                    首页
                </s:else>
                </td>
            <td style="width:100px">
                <s:if test="pageBean.hasPreviousPage">
                    <s:url var="getUsers_previous" value="findAllUserCommodity.action">
                        <s:param name="currentPage" value="pageBean.currentPage-1"></s:param>
                    </s:url>
                    <s:a href="%{getUsers_previous}">上页</s:a>
                </s:if>
                <s:else>
                    上页
                </s:else>
            </td>
            <td style="width:150px">
                <s:if test="pageBean.hasNextPage">
                    <s:url var="getUsers_next" value="findAllUserCommodity.action">
                        <s:param name="currentPage" value="pageBean.currentPage+1"></s:param>
                    </s:url>
                    <s:a href="%{getUsers_next}">下页</s:a>
                </s:if>
                <s:else>
                    下页
                </s:else>
            </td>
            <td style="width:50px">
                <s:if test="pageBean.lastPage">
                    <s:url var="getUsers_last" value="findAllUserCommodity.action">
                        <s:param name="currentPage" value="pageBean.totalPage"></s:param>
                    </s:url>
                    <s:a href="%{getUsers_last}">末页</s:a>
                </s:if>
                <s:else>
                    末页
                </s:else>
            </td>
            <td style="width:100px">共<s:property value="pageBean.totalPage"/>页</td>
            <td style="width:300px">共<s:property value="pageBean.allRow"/>条记录</td>

        </tr>

				</div>
				</div>
				</div>

    

</body>
</html>