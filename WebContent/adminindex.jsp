<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网上零食销售首页</title>
<link href="files/adminindex/styles.css" type="text/css" rel="stylesheet"/>
<link href="files/h/styles.css" type="text/css" rel="stylesheet"/>
</head>
<body>
<div class="nav">
    <ul >
        <li><a href="#" >商品管理</a></li>
        <li><a href="#" >零食管理</a></li>
        <li><a href="#" >订单管理</a></li>
        <li><a href="#" >公告管理</a></li>
        <li><a href="#" >售后服务管理</a></li> 
</ul>
</div>

<div class="normal">
<a href="findAllSnacks.action">添加商品</a>
<a href="findAllSnacks.action">删除商品</a>
<a href="findAllSnacks.action">查询商品</a>
<a href="findAllSnacks.action">修改商品</a>
</div>

</body>
</html>