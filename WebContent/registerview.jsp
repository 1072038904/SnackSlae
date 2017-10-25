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

      <!-- Unnamed (矩形) -->
      <div id="u16" class="ax_default box_1">
        <div id="u16_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u17" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>

      <!-- Unnamed (矩形) -->
      <div id="u18" class="ax_default _三级标题">
        <div id="u18_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u19" class="text">
          <p><span>注册</span></p>
        </div>
      </div>
<s:form action="isregister" method="post">
      <!-- Unnamed (提交按钮) -->
      <div id="u20" class="ax_default html_button">
        <input id="u20_input" type="submit" value="注册"/>
      </div>

      <!-- address (文本框) -->
      <div id="u21" class="ax_default text_field" data-label="address">
        <input id="u21_input" type="text" value=""name = "userInfor.address" maxlength="30"/>
      </div>

      <!-- telephone (文本框) -->
      <div id="u22" class="ax_default text_field" data-label="telephone">
        <input id="u22_input" type="tel" value=""  name = "userInfor.telephone"maxlength="11"/>
      </div>

      <!-- name (文本框) -->
      <div id="u23" class="ax_default text_field" data-label="name">
        <input id="u23_input" type="text" value=""name = "userInfor.name" maxlength="6"/>
      </div>

      <!-- password (文本框) -->
      <div id="u24" class="ax_default text_field" data-label="password">
        <input id="u24_input" type="password" value="" name="userInfor.account.password"maxlength="16"/>
      </div>

      <!-- account (文本框) -->
      <div id="u25" class="ax_default text_field" data-label="account">
        <input id="u25_input" type="text" name ="userInfor.account.account"value=""/>
      </div>
      </s:form>
    </div>
  </body>
</html>
