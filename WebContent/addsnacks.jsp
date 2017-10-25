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
    <link href="files/addsnacks/styles.css" type="text/css" rel="stylesheet"/>
    <script src="resources/scripts/jquery-1.7.1.min.js"></script>
    <script src="resources/scripts/jquery-ui-1.8.10.custom.min.js"></script>
    <script src="resources/scripts/prototypePre.js"></script>
    <script src="data/document.js"></script>
    <script src="resources/scripts/prototypePost.js"></script>
    <script src="files/addsnacks/data.js"></script>
    <script type="text/javascript">
      $axure.utils.getTransparentGifPath = function() { return 'resources/images/transparent.gif'; };
      $axure.utils.getOtherPath = function() { return 'resources/Other.html'; };
      $axure.utils.getReloadPath = function() { return 'resources/reload.html'; };
    </script>
  </head>
  <body>
    <div id="base" class="">

      <!-- Unnamed (矩形) -->
      <div id="u26" class="ax_default box_1">
        <div id="u26_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u27" class="text" style="display:none; visibility: hidden">
          <p><span></span></p>
        </div>
      </div>
      <s:form action="saveSnacks" method="post">
      <!-- Unnamed (提交按钮) -->
      <div id="u28" class="ax_default html_button">
        <input id="u28_input" type="submit" value="提交"/>
      </div>
      <!-- price (文本框) -->
      <div id="u29" class="ax_default text_field" data-label="price">
        <input id="u29_input" type="number" name="snacks.price" value=""/>
      </div>
      <!-- 散称单选框 -->
      <div id="u30" class="ax_default radio_button" data-label="in bulk">
      <input type="radio" checked="checked" name="snacks.packMethod" value="散称" /> 散称
      </div>
      <!-- 袋装单选框 -->
   <div id="u32" class="ax_default radio_button" data-label="in bulk">
	<input type="radio"  name="snacks.packMethod" value="袋装"/>  袋装
      </div>
<br />

      <!-- secClassification (文本框) -->
      <div id="u34" class="ax_default text_field" data-label="secClassification">
        <input id="u34_input" type="text" name="snacks.secClassification"value=""/>
      </div>

      <!-- priClassification (下拉列表框) -->
      <div id="u35" class="ax_default droplist" data-label="priClassification">
        <select id="u35_input" name="snacks.priClassification">
          <option value="肉类即食">肉类即食</option>
          <option value="梅/果干">梅/果干</option>
          <option value="进口食品">进口食品</option>
          <option value="核桃">核桃</option>
          <option value="坚果炒货">坚果炒货</option>
        </select>
      </div>

      <!-- name (文本框) -->
      <div id="u36" class="ax_default text_field" data-label="SnackName">
        <input id="u36_input" type="text" value=""name="snacks.name" maxlength="20"/>
      </div>
      </s:form>
      <!-- Unnamed (矩形) -->
      <div id="u37" class="ax_default label">
        <div id="u37_div" class=""></div>
        <!-- Unnamed () -->
        <div id="u38" class="text">
          <p><span>添加零食信息</span></p>
        </div>
      </div>
    </div>
  </body>
</html>
