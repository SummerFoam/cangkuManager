<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="css/left.css">
<head>
<style>
body{
background:url("images/left.jpg");
}
.menu a{
text-decoration:none;
	color:#e5e1e1;}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script Language="JavaScript">
function sure() {
	var sure=confirm("亲，确定退出此账号吗？");
	//document.write(sure);
	if(sure){
	window.open("login.jsp");
	}
}
</script>
</head>
<body>
	<div class="menu" id="menu">
	
			<span>WIDGET MENU</span>
			<img alt="" src="images/sz.png" style="width:12px;margin-right: 18px;">
		
	
		<div>
			<p>仓库管理<img alt="" src="images/jt.png"></p>
			
			<ul class="item">
				<li><a href="findAll.action" target="content">仓库信息管理</a></li>
				<li><a href="insertCang.jsp" target="content">添加仓库</a></li>
			</ul>
		</div>
		<div>
			<p>货架管理<img alt="" src="images/jt.png"></p>
			
			<ul class="item">
				<li><a href="SelAllrack.action" target="content">货架信息管理</a></li>
				<li><a href="SelAllcang.action" target="content">添加货架</a></li>
			</ul>
		</div>
		<div>
			<p>商品类别管理<img alt="" src="images/jt.png"></p>
			
			<ul class="item">
				<li><a href="SelAllType.action" target="content">商品类别信息管理</a></li>
				<li><a href="addSelAllType.action" target="content">添加商品类别</a></li>
			</ul>
		</div>
		<div>
			<p>商品管理<img alt="" src="images/jt.png"></p>
			
			<ul class="item">
				<li><a href="selectAllProduct.action" target="content">商品信息管理</a></li>
				<li><a href="selectAllProductType.action" target="content">添加新商品</a></li>
			</ul>
			
		</div>
<!-- 		<a href="selectAllProduct" target="right">商品信息管理</a><br>
&nbsp;&nbsp;<a href="selectAllProductType" target="right">商品增加</a><br>
&nbsp;&nbsp;<a href="selectAllInputLog" target="right">进货记录</a><br>
&nbsp;&nbsp;<a href="selectAllOutputLog" target="right">出货记录</a><br> -->
		
		<div>
			<p>出进货记录<img alt="" src="images/jt.png"></p>
		<ul>
				<li><a href="selectAllOutputLog.action" target="content">出货记录</a></li>
				<li><a href="selectAllInputLog.action" target="content">进货记录</a></li>
			</ul>
		</div>
		
	</div>
	<script src="js/scripts.min.js"></script>
</body>
</html>
