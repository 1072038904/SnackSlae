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
<li><a href="findAllSnacks.action">添加零食</a></li>
<li><a href="#">删除零食</a></li>
<li><a href="#">修改零食</a></li>
<li><a href="findAllSnacks.action">所有零食</a></li>
</ul>
</div>
<div class="container">
<form class="navbar-form navbar-left"  action="searchSnacksPage" method="post"  role="search">
<s:textfield name="snacks.name" class="form-control" value="请输入查询零食的名字" />
<button type="submit" class="btn btn-default navbar-btn">搜索</button>                  
</form>
<div  style="width:600px;"class="table table-bordered ">
<table class="table" >
    <caption>零食列表</caption>
    <thead>
      <tr>
        <th>零食名称</th>
        <th>一级分类</th>
        <th>二级分类</th>
        <th>包装方式</th>
        <th>价格</th>
        <th>操作</th>
        </tr>
    </thead>
     <tbody>
<s:iterator value="pageBean.list" var="sa">
<tr>
<form action="updateSnacks" method="post">
<input style="width:150px" type="hidden"  name="snacks.id"  value="<s:property value="id"/>"/>
<td><input style="width:150px"  name="snacks.name" type="text" value="<s:property value="name"/>"/></td>
<td><input style="width:100px" name="snacks.priClassification" type="text"  value="<s:property value="priClassification"/>"/></td>
<td><input style="width:100px"  name="snacks.secClassification" type="text" value="<s:property value="secClassification"/>"/></td>
<td><input style="width:80px" name="snacks.packMethod" type="text"  value="<s:property value="packMethod"/>"/></td>
<td><input style="width:60px" name="snacks.price" type="text" value="<s:property value="price"/>"/></td>
<td><input style="width:60px" type="submit"  value="修改"/></td></form>
<td><form action="deleteCommodity" method="post"><input style="width:150px" type="hidden"  name="snacks.id"  value="<s:property value="id"/>"/>
<input style="width:60px" type="submit"  value="删除"/></form></td>

</tr>
</s:iterator>
<tr>
    <td style="width:100px">
                <s:if test="pageBean.firstPage">
                    <s:url var="getUsers_first" value="findAllSnacks.action">
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
                    <s:url var="getUsers_previous" value="findAllSnacks.action">
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
                    <s:url var="getUsers_next" value="findAllSnacks.action">
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
                    <s:url var="getUsers_last" value="findAllSnacks.action">
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