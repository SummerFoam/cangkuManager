<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page isELIgnored="false"%>
<%
	String path = request.getContextPath();
	//out.print(path);
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
	body {
       		background-color:#374f7f;
			margin-left: 0px;
			margin-top: 0px;
			margin-right: 0px;
			margin-bottom: 0px;
			background:url("images/head.jpg");
		}
		.block{
		
			float: right;
		    border-radius: 20px;
		    background: rgba(78, 77, 96, 0.6);
		    color: #fff;
		    margin-top: 62px;
    		margin-right: 10px;
		}
		.head{
			float: left;
		    font-size: 35px;
		    padding: 28px;
		    color: #fff;
		}
		.STYLE1 {font-size: 12px}
		.STYLE2 {
			color: #03515d;
			font-size: 12px;
		}
		.search{
			margin-right: 75px;
    		float: right;
    		margin-top:65px;
		}
		.search .txt{
	
		
			width: 200px;
    		height: 35px;
			border: none;
    		border-radius: 5px;
    		color: #4341b5;
    		font-size: 15px;
		}
		
		.search .inp{
			font-size: 16px;
    		width: 60px;
    		height: 35px;
    		border: none;
    		background: rgba(78, 77, 96, 0.6);
    		color: #fff;
		}
	.welcome{
		    padding: 20px;
    		padding-left: 45px;
	}
	.welcome span{
			font-size: 20px;
	}
a:link {
	font-size: 12px;
	text-decoration: none;
	color: #000000;
}

a:visited {
	font-size: 12px;
	text-decoration: none;
	color: #000000;
}

a:hover {
	font-size: 12px;
	text-decoration: none;
	color: #FF0000;
}

a.v1:link {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}

a.v1:visited {
	font-size: 12px;
	text-decoration: none;
	color: #03515d;
}
</style>
<script type="text/javascript">
	
	    function logout()
		{
		   if(confirm("确定要退出本系统吗??"))
		   {
			   window.parent.location="<%=path%>/login.jsp";

		}
	}
</script>
</head>

<body>
	<div class="ma">
		<div class="head">
			<span>仓库管理系统</span>
			<div class="welcome">
			<span>欢迎您：</span>
			<span style="color:red;"> ${user}</span>
		</div>
		</div>

		

		<div class="block">
			<SCRIPT>
				setInterval(
						"clock.innerHTML=new Date().toLocaleString()+'&nbsp;&nbsp;'+''.charAt(new Date().getDay());",
						1000)
			</SCRIPT>
			<SPAN id=clock style="float: left;margin-top: 9px;    padding: 3px;
    padding-left: 10px;"></SPAN>&nbsp; <a href="#"
				style="font-size: 15px; color: #fff;display: inline-block;margin-top: 13px;" onclick="logout()">安全退出</a>&nbsp;&nbsp;
		</div>

	
	<form action="fuzzyProductName.action" method="post" target="content">
		<div class="search">
			<input class="txt" type="text" name="fuzzyName"
				placeholder="请输入要搜索的商品" /> <input class="inp" type="submit"
				value="搜索" />
		</div>

	</form>

</body>
</html>
