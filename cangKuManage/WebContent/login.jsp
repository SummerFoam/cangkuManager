<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	 <%@ taglib uri="/struts-tags" prefix="s" %>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Document</title>
<link href="css/c1.css" rel="stylesheet" type="text/css">

<script type="text/javascript">
	
	function validate(frm){
		if(frm.name.value.length<=0){
			alert("请输入用户名");
			return false;
		}else if(frm.pwd.value.length<=0){
			alert("请输入密码");
			return false;
		}else if(frm.yan.value.length<=0){
			alert("请输入验证码");
			return false;
		}
	}
	
	function refresh(){
		document.getElementById("image").src="createImageAction.action?+ Math.random()"+new Date();
	}
	
	var error="${error}";
	if(error=="输入有误，请重新登录！"){
		alert(error);
	}
	
	var yanzheng="${yanzheng}";
	if(yanzheng=="验证码不正确"){
		alert(yanzheng);
	}
</script>
</head>

<body>
<%-- <s:debug></s:debug> --%>
<div id="div1"><img src="images/1.jpg"/></div>
	<br/>
	<div>
	<div class="welcome" >
		<h2>
			<font color="#fff0f5" class="font1" style="font-family: 楷体;"><b>仓库管理系统</b></font>
		</h2>
	</div><br>
	<form onSubmit="return validate(this);" action="login.action"  method="post" name="frm">
	<div class="main" ><br>
		<div align="center" style="font-size: 40px;font-family: 楷体;color: #000;" >管理员登录</div><br>
		<div align="center" style="background-color:; font-family: 楷体;" class="main_1">
			<div >
				<span class="label">用户名：</span>
				<span class="text"><input class="textinput" type="text" name="managers.name" id="name" ></span>
			</div>		
			<div >
				<span class="label">密码：</span>
				<span class="text"><input class="textinput" type="password" name="managers.password"  id="pwd"></span>
			</div>
			<div>
				<span class="label">验证码：</span>
				<span class="text">
					<input class="textinput1" type="text" name="checkCode" id="yan">
					<img id="image" border="0"  onclick="refresh()"  src="createImageAction.action" title="看不清，换一张">
				</span>
			</div>
			<div>
				<span class="label"></span>
				<span class="text">
				<input type="submit" value="登录" class="buttonStyle">
				<input type="reset" value="重置" class="buttonStyle">
				</span>
			</div>
		</div>
	</div>
	</form>
</body>
</html>