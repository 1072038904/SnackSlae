<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="<%=basePath%>files/form/styles.css" type="text/css" rel="stylesheet"/>
<link href="<%=basePath%>css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="<%=basePath%>css/style.css" rel='stylesheet' type='text/css' />
    <link rel="<%=basePath%>stylesheet" type="text/css" href="css/reset.css" media="screen" />
    <link rel="<%=basePath%>stylesheet" type="text/css" href="css/text.css" media="screen" />	
    <link href="css/table/demo_page.css" rel="stylesheet" type="text/css" />
      <script type="text/javascript">
      function ch(name){
    	  if(confirm("确定要删除吗？")){
    	  window.location.href="deleteCommodity.action?keyName="+name;
    	  }
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
<li><a href="addCommodity.action">添加商品</a></li>
<li><a href="findAllSnacks.action">删除商品</a></li>
<li><a href="updateAllCommodity.action">修改商品</a></li>
<li><a href="findAllCommodity.action">所有商品</a></li>
</ul>
</div>
<div class="container">
<form class="navbar-form navbar-left"  action="searchCommodityPage" method="post"  role="search">
<s:textfield name="commodity.name" class="form-control" value="请输入查询商品的名字" />
<button type="submit" class="btn btn-default navbar-btn">搜索</button>
<s:iterator value="pageBean.list" >
<span></span>
<span></span>
</s:iterator>
</form>
<div  style="width:600px;"class="table table-bordered ">
<table class="table" >
    <caption>商品列表</caption>
    <thead>
      <tr>
        <th>商品名称</th>
        <th>价格</th>
        <th>上架时间</th>
        <th>库存</th>
        <th>销量</th>
        <th>零食种类</th>
        <th>操作</th>
        </tr>
    </thead>
     <tbody>
<s:iterator value="pageBean.list" >
<tr>
<form action="updateCommodity" method="post">
<input style="width:150px" type="hidden" id="cname" name="commodity.id"  value="<s:property value="id"/>"/>
<td><input style="width:150px" id="cname" name="commodity.name" type="text" value="<s:property value="name"/>"/></td>
<td><input style="width:50px" id="cprice" name="commodity.price" type="text"  value="<s:property value="price"/>"/></td>
<td><input style="width:90px" id="cshelfTime" name="commodity.shelfTime" type="text" value="<s:property value="shelfTime"/>"/></td>
<td><input style="width:60px" id="cstock" name="commodity.stock" type="text"  value="<s:property value="stock"/>"/></td>
<td><input style="width:60px" id="csalesVolume" name="commodity.salesVolume" type="text" value="<s:property value="salesVolume"/>"/></td>
<td ><p  style="width:120px"><s:property value="snacks.name"/></p></td>
<td><input style="width:60px" type="submit"  value="修改"/></td></form>
<td><form id="del" action="deleteCommodity" method="post"><input style="width:150px" type="hidden" id="cname" name="commodity.id"  value="<s:property value="id"/>"/>
<input style="width:60px" type="submit"  value="删除"/></form></td>

</tr>
</s:iterator>
<tr>
    <td style="width:100px">
                <s:if test="pageBean.firstPage==true">
                    <s:url var="getUsers_first" value="findAllCommodity.action">
                        <s:param name="currentPage" value="1"></s:param>
                    </s:url>
                    <s:a href="%{getUsers_first}">首页</s:a>
                </s:if>
                <s:else>
                    首页
                </s:else>
                </td>
            <td style="width:100px">
                <s:if test="pageBean.hasPreviousPage==true">
                    <s:url var="getUsers_previous" value="findAllCommodity.action">
                        <s:param name="currentPage" value="pageBean.currentPage-1"></s:param>
                    </s:url>
                    <s:a href="%{getUsers_previous}">上页</s:a>
                </s:if>
                <s:else>
                    上页
                </s:else>
            </td>
            <td style="width:150px">
                <s:if test="pageBean.hasNextPage==true">
                    <s:url var="getUsers_next" value="findAllCommodity.action">
                        <s:param name="currentPage" value="pageBean.currentPage+1"></s:param>
                    </s:url>
                    <s:a href="%{getUsers_next}">下页</s:a>
                </s:if>
                <s:else>
                    下页
                </s:else>
            </td>
            <td style="width:50px">
                <s:if test="pageBean.lastPage==true">
                    <s:url var="getUsers_last" value="findAllCommodity.action">
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
</tbody>
</table>
</div>
</div>
</body>
</html>