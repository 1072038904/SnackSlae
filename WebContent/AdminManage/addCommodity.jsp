<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html >
<html>
<head>
<title>商品管理-添加商品</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加商品</title>
<link href="files/adminindex/styles.css" type="text/css" rel="stylesheet"/>
<link href="files/form/styles.css" type="text/css" rel="stylesheet"/>
<link href="files/h/styles.css" type="text/css" rel="stylesheet"/>
</head>

<!-- 导航栏 -->
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
  
<div class="smart-green">
<s:form action="saveCommodity" method="post" enctype="multipart/form-data">
商品名：<input type="text" value="大袋牛肉干" name="commodity.name"/>
上架时间：<input type="text" value="2017-10-24" name="commodity.shelfTime"/>
商品价格：<input type="text" value="50.00" name="commodity.price"/>
库存：<input type="text" value="1000" name= "commodity.stock">
请选择需要上传的商品图片：<input type="file" id="dofile" name="upload"/><br/>
<select name="snacksName">
<s:iterator value="%{snacks2}" id="snacks"> 
        <option value="<s:property value="#snacks.name"/>" ><s:property value="#snacks.name"/></option>
        </s:iterator>
         </select>
<input type="submit" value="提交">
</s:form>
</div>

<a href="findAllSnacks.action">单击</a><br/>
</body>
</html>