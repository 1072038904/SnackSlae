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
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
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
        <li><a href="allUserCommodity.jsp" >商品首页</a></li>
        <li><a href="searchSnacks.jsp" >零食管理</a></li>
        <li><a href="findOrderPage" >订单管理</a></li>
        <li><a href="#" >公告管理</a></li>
        <li><a href="shoppingCart.jsp" >售后服务管理</a></li> 
</ul> 
</div> 

 <form class="navbar-form navbar-left"  action="searchCommodityPage" method="post"  role="search">
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
<div class="breadcrumb">
     <c:forEach items="${a}" var="entry">
     	<li class="active">${entry.pri}</li>
     <c:forEach items="${entry.sec}" var="se">
		<li><a href="searchCommodityBySec.action?secClass=${se}">${se}</a></li>
     </c:forEach><br>
     </c:forEach>
     <br>
	<ul>
		<li class="active">商品:包装方式</li>
		<li><a href="searchCommodityByPackMethod.action?methodPack=散称">散称</a></li>
		<li><a href="searchCommodityByPackMethod.action?methodPack=袋装">袋装</a></li>
	</ul>
</div>

     <div class="main">
      <div class="shop_top">
		<div class="container">
			<div class="row shop_box-top">
<c:forEach items="${goods.list}" varStatus="num" var="sorder" >
		<div class="col-md-3 shop_box"><a href="<%=basePath%>${sorder.picturePath}">
					<img src="<%=basePath%>${sorder.picturePath}" height="200" width="200" alt=""/></a>
					<span class="new-box">
						<span class="new-label">New</span>
					</span>						
					<div class="shop_desc">
						<h3>${sorder.name}</h3>
						<p>上架时间:${sorder.shelfTime}</p>
						<p>销售量:${ sorder.salesVolume}/>
						库存:${sorder.stock }</p>						
						<span class="actual">￥${sorder.price }</span><br>
						<ul class="buttons">
							<li class="cart">
						<li><form  action="saveUserShoppingCart.action" method="post">
						<!-- 需要传入的参数有 商品id  -->					
						<input  type="hidden" name="shoppingCart.commodity.id" value="${sorder.id}"/>
						<input class="btn btn-default navbar-btn" type="submit" value="添加进购物车"></form></li>		
					    </ul>
				    </div>
</div>
</c:forEach>
</div>
<table>
<tr>
    <td style="width:100px">
    <c:choose>
                <c:when test="${goods.firstPage}">
                    <c:url var="getUsers_first" value="findAllUserCommodity.action">
                        <c:param name="currentPage" value="1"></c:param>
                    </c:url>
                    <a href="${getUsers_first}">首页</a>
                </c:when>
                <c:otherwise>
                    首页
                </c:otherwise>
                </c:choose>
                </td>
            <td style="width:100px">
            <c:choose>
                <c:when test='${goods.hasPreviousPage}'>
                    <c:url var="getUsers_previous" value="findAllUserCommodity.action">
                        <c:param name="currentPage"  value='${goods.currentPage-1}'></c:param>
                    </c:url>
                    <a href="${getUsers_previous}">上页</a>
                </c:when>
                <c:otherwise>
                    上页
                </c:otherwise>
                </c:choose>
            </td>
            <td style="width:150px">
            <c:choose>
                <c:when test="${goods.hasNextPage}">
                    <c:url var="getUsers_next" value="findAllUserCommodity.action">
                        <c:param name="currentPage" value="${goods.currentPage+1}"></c:param>
                    </c:url>
                    <a href="${getUsers_next}">下页</a>
                </c:when>
                <c:otherwise>
                    下页
                </c:otherwise>
                </c:choose>
            </td>
            <td style="width:50px">
            <c:choose>
                <c:when test="${sessionScope.goods.lastPage}">
                    <c:url var="getUsers_last" value="findAllUserCommodity.action">
                        <c:param name="currentPage" value="${goods.totalPage}"></c:param>
                    </c:url>
                    <a href="${getUsers_last}">末页</a>
                </c:when>
                <c:otherwise>
                    末页
                </c:otherwise>
                </c:choose>
            </td>
            <td style="width:100px">当前第<span>${goods.currentPage}</span>页</td>
            <td style="width:100px">共<span>${goods.totalPage}</span>页</td>
        </tr>
        </table>
				</div>
				</div>
				</div>

    

</body>
</html>