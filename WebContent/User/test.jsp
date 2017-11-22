<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<!-- 新 Bootstrap 核心 CSS 文件 --><link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<!-- 可选的Bootstrap主题文件（一般不使用） --><script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap-theme.min.css"></script>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 --><script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 --><script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<style type="text/css">
		#dd div{
			padding: 5px;
		}
	</style>
<body>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span4">
		</div>
		<div class="span4">
			<form class="form-horizontal">
				<fieldset>
					<legend>我的信息</legend>
					<p>
						姓名：<input type="text" />
					</p>
					<p>
						电话：<input type="text" />
					</p>
					<div>
						地址：<input type="text" />
						
					</div>
					<p>
						<span class="help-block"><label class="checkbox"></label> <button class="btn" type="submit">保存信息</button></span>
					</p>
				</fieldset>
			</form>
		</div>
		<div class="span4">
		</div>
	</div>
</div>
</body>
</html>