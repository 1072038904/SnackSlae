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
<title>订单管理</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link href="<%=basePath%>files/adminindex/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>files/form/styles.css" type="text/css" rel="stylesheet"/>
<link href="<c:url value='/css/style.css'/>" type="text/css" rel="stylesheet"/>
<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<link href="<c:url value='/css/bootstrap.css'/>" rel='stylesheet' type='text/css' />
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
        						<li><a href="searchUserCommodity.jsp" >商品管理</a></li>
        						<li><a href="searchSnacks.jsp" >零食管理</a></li>
       	 						<li><a href="findOrderPage.action" >订单管理</a></li>
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
							<button type="button" class="btn btn-default">
    						<span class="">你好!,用户：${account.account}</span>	
							</button>
							</a>              
							</form>
			</div>
		</div>  
	</div>
</div>
<!-- ---导航栏结束--- -->
<div>
	<ol class="breadcrumb">
		<li><a href="findOrderPage.action">全部订单</a></li>
		<li><a href="findUnFirmOrder.action">待确认订单</a></li>
    	<li><a href="findPastOrder.action">历史订单</a></li>
    	<li><a href="findPayOrder.action">已付款订单</a></li>
    	<li><a href="findEvalOrder.action">可评价订单</a></li>
	</ol>
</div>
<div class="container">
	<div  class="">
		<table class="table table-striped table-bordered" >
    		<caption>订单列表</caption>
   			 <thead >
				<tr>
      <th>
      <input type="checkbox" id="allCheck" class="ck"/>全选
      </th>   
      	<th class="col-sm-1 text-center">订单号</th>
        <th class=" col-sm-2 text-center">订单商品名称</th>
        <th class=" text-center">图片</th>
        <th class=" text-center">数量</th>
        <th class=" text-center">订单价格</th>
        <th class=" text-center">联系人</th>
        <th class=" text-center">联系方式</th>   
        <th class="text-center">订单状态</th>
        <th class="text-center">买家留言</th>
        <th class=" text-center">操作</th>
        </tr> 
    </thead>
     <tbody  id="tbody" > 
		<c:forEach items="${order.list}" var="sorder" varStatus="num">
		<tr >
			<td><input type="checkbox" class="ck"/></td>
			<td class=" text-center">${sorder.orderId}</td>
			<td class=" text-center">${sorder.request.commodity.name}</td>
			<td class=" text-center"><img src="<%=basePath%>${sorder.request.commodity.picturePath}" height="50" width="50" alt=""/></td>
			<td class=" text-center">${sorder.request.number}</td>
			<td class=" text-center">${sorder.request.price}</td>
			<td class=" text-center">${sorder.contactName}</td>
			<td class=" text-center">${sorder.contactTele}</td>
			<td class=" text-center">${sorder.transactionStaus}</td>
			<td style='display:none;'>${sorder.id}</td>
			<c:if test="${sorder.transactionStaus=='待确认'}">
				<td class=" text-center">
				<input name="request.specification" value="备注"></input>
				</td>
				<td style='display:none;'>${sorder.request.id}</td>
				<td>
				<form action="deleteOrder" id="s_id" class=" text-center">
				<button class="btn btn-danger" type="submit" name="orderForm.id" value="${sorder.id}">删除</button>
				</form>
				</td>
			</c:if>
			<c:if test="${sorder.transactionStaus=='商家已经确认'}">
				<td class=" text-center"><span>${sorder.request.specification}</span></td>
				<td><button class="btn btn-success">评价</button></td>
			</c:if>
			<c:if test="${sorder.transactionStaus=='用户已经付款'}">
			<td class=" text-center"><span>${sorder.request.specification}</span></td>
			<td>
			<form action="returnOrder.action">
				<input type="hidden" name="id" value="${sorder.request.id }">
				<input type="hidden" name="orderFormId" value="${sorder.id }">
				<input type="hidden" name="commodity.id" value="${sorder.request.commodity.id }">
				<button  type="submit" class="btn btn-success">退货</button>
			</form>
			</td>
			</c:if>
		</tr>
		</c:forEach>
	</tbody>
</table>
<div class="container">
	<div class=" pull-right">
		<label class="btn btn-success">总价格：￥<span id="totalPrice">0</span></label>
		<button class=" btn btn-danger" id="firm">确认订单信息</button>
	</div>
</div>
<table>
<tr>
    <td style="width:100px">
    <c:choose>
                <c:when test="${order.firstPage==true}">
                    <c:url var="getUsers_first" value="findOrderPage.action">
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
                <c:when test='${order.hasPreviousPage==true}'>
                    <c:url var="getUsers_previous" value="findOrderPage.action">
                        <c:param name="currentPage"  value='${order.currentPage-1}'></c:param>
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
                <c:when test="${order.hasNextPage==true}">
                    <c:url var="getUsers_next" value="findOrderPage.action">
                        <c:param name="currentPage" value="${order.currentPage+1}"></c:param>
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
                <c:when test="${order.lastPage==true}">
                    <c:url var="getUsers_last" value="findOrderPage.action">
                        <c:param name="currentPage" value="${order.totalPage}"></c:param>
                    </c:url>
                    <a href="${getUsers_last}">末页</a>
                </c:when>
                <c:otherwise>
                    末页
                </c:otherwise>
                </c:choose>
            </td>
            <td style="width:100px">当前第<span>${order.currentPage}</span>页</td>
            <td style="width:100px">共<span>${order.totalPage}</span>页</td>
        </tr>
        </table>

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
         var temp = tr.children[4].innerHTML;
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
/*确认订单按钮*/
 
firm.onclick = function(){
	if(confirm("确认订单？")){
	 for(var i = 0, len = cks.length; i < len; i++) {
     if(cks[i].checked) { //如果当前被选中
    	 var tr = cks[i].parentNode.parentNode;
         var temp = tr.children[9].innerHTML;
         var tmp = tr.children[10].children[0].value;
         var tp = tr.children[11].innerHTML;
         tmp= tmp.toString();
         console.log(tmp);
         console.log(tp);
         $.ajax({url:'confirmOrder.action?orderForm.id',
        		 data: {"orderFormId":temp,"temp":tmp,"id":tp},
        		 async:false});
         }
	 }
	 location.reload();
	}
}

/*全选实现*/
allCheck.onchange = function() {
	//alert("已经添加进购物车");
 if(this.checked) {
     for(var i = 0, len = cks.length; i < len; i++) {
         cks[i].checked = true;
     }
 }
     else {
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