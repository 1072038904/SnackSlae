<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
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
<title>商品管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>

<link href="<%=basePath%>files/adminindex/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>files/form/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>files/h/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>css/bootstrap.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="<%=basePath%>css/style.css" rel='stylesheet' type='text/css' />
<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.8.0.js">
</script>
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
        <li><a href="conFirmOrder.jsp" >订单管理</a></li>
        <li><a href="#" >公告管理</a></li>
        <li><a href="shoppingCart.jsp" >售后服务管理</a></li> 
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
    <span class="glyphicon glyphicon-user">&nbsp;${account.account}</span>	
</button></a>      
</form>

</div>
</div>  
</div>
</div>
<div>

<div class="container">

<div  class="table table-striped table-hover table-bordered">
<table class="table" >

    <caption>商品列表</caption>
    <thead >
      <tr >
      <th>
      <input type="checkbox" id="allCheck" class="ck"/>全选
      </th>   
      	<th class=" text-center">商品序号</th>
        <th class=" col-sm-2 text-center">商品名称</th>
        <th class=" text-center">图片</th>
        <th class=" text-center">数量</th>
        <th class=" text-center">价格</th>
        <th class=" text-center">小计</th>
        <th class=" text-center">操作</th>      
        </tr> 
    </thead>
     <tbody  id="tbody" > 
<c:forEach items="${pageBean.list}" var="sorder" varStatus="num">
<tr >
<td>
<input type="checkbox" class="ck"/>
</td>
<td class=" text-center">${num.count}</td>
<td class=" text-center">${sorder.commodity.name}</td>
<td class=" text-center"><img src='<%=basePath%>${sorder.commodity.picturePath}' height="80" width="100" alt=""/></td>
<td class=" text-center">
<form action="updateShoppingCartNumber.action">
<input type="hidden" name="shoppingCart.id" value="${sorder.id }"/>  
<button  class="btn btn-default btn-xs" type="submit" name="number" value="${sorder.number+1}">+</button>
<label>${sorder.number}</label><button class="btn btn-default btn-xs" type="submit" name="number" value="${sorder.number-1}">-</button></form>
</td>
<td class=" text-center">${sorder.commodity.price}</td>
<td class=" text-center">${sorder.price}</td>
<td style='display:none;'>${sorder.id}</td>
<td>
<form action="deleteShoppingCart" id="s_id" class=" text-center">
<button class="btn btn-danger" type="submit" name="shoppingCart.id" value="${sorder.id}">删除</button>

</form>
</td>


</tr>
</c:forEach>
</tbody>
</table>
<div class="container">
<div class=" pull-right">
<label class="btn btn-success">总价格：￥<span id="totalPrice">0</span></label>
<a href="#"><button class=" btn btn-danger" id="clearCart">结算</button></a>
</div>
</div>
<table>
<tr>
    <td style="width:100px">
    <c:choose>
                <c:when test="${pageBean.firstPage}">
                    <c:url var="getUsers_first" value="searchShopingCartByPageAccount.action">
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
                <c:when test='${pageBean.hasPreviousPage}'>
                    <c:url var="getUsers_previous" value="searchShopingCartByPageAccount.action">
                        <c:param name="currentPage"  value='${pageBean.currentPage-1}'></c:param>
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
                <c:when test="${pageBean.hasNextPage}">
                    <c:url var="getUsers_next" value="searchShopingCartByPageAccount.action">
                        <c:param name="currentPage" value="${pageBean.currentPage+1}"></c:param>
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
                <c:when test="${sessionScope.pageBean.lastPage}">
                    <c:url var="getUsers_last" value="searchShopingCartByPageAccount.action">
                        <c:param name="currentPage" value="${pageBean.totalPage}"></c:param>
                    </c:url>
                    <a href="${getUsers_last}">末页</a>
                </c:when>
                <c:otherwise>
                    末页
                </c:otherwise>
                </c:choose>
            </td>
            <td style="width:100px">当前第<span>${pageBean.currentPage}</span>页</td>
            <td style="width:100px">共<span>${pageBean.totalPage}</span>页</td>
        </tr>
        </table>

</div>
</div>
</div>
</body>
 <script type="text/javascript">
 /*
 功能：计算总价格
*/
var cks = document.querySelectorAll("tbody .ck");
function getTotalPrice() {
 var sum = 0;
 for(var i = 0, len = cks.length; i < len; i++) {
     if(cks[i].checked) { //如果当前被选中
         var tr = cks[i].parentNode.parentNode;
         var temp = tr.children[6].innerHTML;
         sum = Number(temp) + sum;
     }
 }
 return sum;
}
/*循环遍历为每一个checkbox添加一个onchange事件*/
for(var i = 0, len = cks.length; i < len; i++) {
 cks[i].onchange = function() {
     checkAllChecked();
     totalPrice.innerHTML = getTotalPrice();
 }
}
/*结算按钮*/
 
clearCart.onclick=function(){
	if(confirm("添加进订单？")){
	 for(var i = 0, len = cks.length; i < len; i++) {
     if(cks[i].checked) { //如果当前被选中
    	 var tr = cks[i].parentNode.parentNode;
         var temp = tr.children[7].innerHTML;
         $.ajax({url:"saveOrderForm.action?shoppingCart.id="+temp,async:false});
         $.ajax({url:"deleteShoppingCart.action?shoppingCart.id="+temp,async:false});
         }
	 }
	 window.location.href='searchShopingCartByPageAccount.action';
	}
}
/*全选实现*/
allCheck.onchange = function() {
	//alert("已经添加进购物车");
 if(this.checked) {
     for(var i = 0, len = cks.length; i < len; i++) {
         cks[i].checked = true;
     }
 } else {
     for(var i = 0, len = cks.length; i < len; i++) {
         cks[i].checked = false;
     }
 }
 totalPrice.innerHTML = getTotalPrice();
}
/*检测是否要全选*/
function checkAllChecked() {
    var isSelected = true; //全选是否会选中
    for(var j = 0, len = cks.length; j < len; j++) {
        if(cks[j].checked == false) {
            isSelected = false;
            break;
        }
    }
    allCheck.checked = isSelected;
}
 </script>	
</html>