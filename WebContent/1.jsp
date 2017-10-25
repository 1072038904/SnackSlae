<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
    <%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <meta name="apple-mobile-web-app-capable" content="yes"/>
    <link href="resources/css/jquery-ui-themes.css" type="text/css" rel="stylesheet"/>
    <link href="resources/css/axure_rp_page.css" type="text/css" rel="stylesheet"/>
    <link href="data/styles.css" type="text/css" rel="stylesheet"/>
    <link href="files/registerview/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/registerview/data.js"></script>
    <script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
  </head>
  <body>
    <div id="base" class="">
<s:form action="isregister" method="post">
      <!-- 账号 (文本框) -->
      <div id="u16" class="ax_default text_field">
        <input id="u16_input" type="text" name = "userInfor.account.account"value=""/>
      </div>

      <!-- 密码 (文本框) -->
      <div id="u17" class="ax_default text_field">
        <input id="u17_input" type="password"name = "userInfor.account.password" value=""/>
      </div>

      <!-- 姓名 (文本框) -->
      <div id="u18" class="ax_default text_field">
        <input id="u18_input" type="text"name="userInfor.name" value=""/>
      </div>

      <!-- 电话 (文本框) -->
      <div id="u19" class="ax_default text_field">
        <input id="u19_input" type="text" name = "userInfor.telephone"value=""/>
      </div>
        <!-- 地址 (文本框) -->
      <div id="u29" class="ax_default text_field">
        <input id="u29_input" type="text" name= "userInfor.address"value=""/>
      </div>
      <!-- Unnamed (提交按钮) -->
      <div id="u89" class="ax_default html_button">
        <input id="u89_input" type="submit" value="注册"/>
      </div>
</s:form>
      <!-- Unnamed (矩形) -->
      <div id="u21" class="ax_default label">
        <div id="u21_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u22" class="text">
          <p><span>账号：</span></p>
        </div>
      </div>

      <!-- Unnamed (矩形) -->
      <div id="u23" class="ax_default label">
        <div id="u23_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u24" class="text">
          <p><span>密码：</span></p>
        </div>
      </div>

      <!-- Unnamed (矩形) -->
      <div id="u25" class="ax_default label">
        <div id="u25_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u26" class="text">
          <p><span>姓名:</span></p>
        </div>
      </div>

      <!-- Unnamed (矩形) -->
      <div id="u27" class="ax_default label">
        <div id="u27_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u28" class="text">
          <p><span>电话:</span></p>
        </div>
      </div>
      <!-- Unnamed (矩形) -->
      <div id="u30" class="ax_default label">
        <div id="u30_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u31" class="text">
          <p><span>地址：</span></p>
        </div>
      </div>
    </div>
  </body>
</html>
