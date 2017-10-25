<%@ page contentType="text/html; charset=UTF-8" language="java" errorPage="" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="files/snacksmanage/styles.css" type="text/css" rel="stylesheet"/>
</head>
<body>

<s:iterator value="%{snacks2}" id="sa">
<div >
     <table id="table-3">
      <tr>
      <td><s:property value="#sa.name" /></td>
      <td><s:property value="#sa.priClassification"/></td> 
      <td><s:property value="#sa.secClassification"/></td> 
       <td><s:property value="#sa.packMethod"/></td> 
   	 <td><s:property value="#sa.price"/></td>
   	 </tr> 
	</table>
	</div>
</s:iterator>

</body>
</html>