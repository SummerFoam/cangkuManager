<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script language="javascript">

function tishi(){
	if(confirm("确定删除吗？")){
		return true;
		
	}
	return false;
	}
	
           function catelogAdd()
           {
                 var url="<%=path%>/insertCang.jsp";
				 window.location.href=url;
           }
           
           var noinput="${jing}";
                           if(noinput=="亲，该仓库有商品 ，不能删除!"){
                           	alert(noinput);
                           }
         
       </script>

<style>

.sub {
	margin-top: 20px;
	margin-left: 570px;
	width: 25%;
	background: #3093c2;
	color: #fff;
}

a.button {
	margin-top: 30px;
	margin-left: 270px;
	width: 25%;
	background: #3093c2;
	color: #fff;
}

</style>
</head>
<body>
	<form action="/cangKuManage/findAll.action" method="post">

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="14" colspan="100" background="">&nbsp;>>仓库管理&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<td>仓库编号</td>
				<td>仓库地址</td>
				<td>编辑</td>
				<td>删除</td>
			</tr>
			<s:iterator value="list">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					<td bgcolor="#FFFFFF" align="center">${cangId}</td>
					<td bgcolor="#FFFFFF" align="center">
						${cangAdress}</td>

					<td bgcolor="#FFFFFF" align="center">
					<a href="can_update.action?cangId=<s:property value="cangId"/>">修改</a>
					</td>
					
				<td bgcolor="#FFFFFF" align="center">
				<a href="can_delete.action?cangId=${cangId}"  onclick="return tishi()">删除</a>
				</td>
			</tr>
		</s:iterator>

		</table>

		<table width='98%' border='0'
			style="margin-top: 8px; margin-left: 5px;">
			<tr>
				<td><input type="button" value="添加" style="width: 80px;"
					onclick="catelogAdd()" /></td>
			</tr>
		</table>

	</form>
</body>
</html>