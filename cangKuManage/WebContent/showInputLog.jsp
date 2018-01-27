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
                 var url="<%=path%>/selectAllProductType";
				 window.location.href=url;
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

		<table width="98%" border="0" cellpadding="2" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="14" colspan="100" background="">&nbsp;>>商品进货记录&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<th>ID</th>
				<th>商品名</th>
				<th>数量</th>
				<th>收货员</th>
				<th>进货员</th>
				<th>日期</th>
				<th>操作</th>
			</tr>
			<s:iterator value="list">
			
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">

					<td bgcolor="#FFFFFF" align="center"><s:property value="id"/> </td>
					
					<td bgcolor="#FFFFFF" align="center"><s:property value="productName"/> </td>
					
					<td bgcolor="#FFFFFF" align="center">
					<s:property value="productCount"/> </td>

					<td bgcolor="#FFFFFF" align="center"><s:property value="shouHuo"/></td>
					<td bgcolor="#FFFFFF" align="center"><s:property value="jinHuo"/> </td>

					<td bgcolor="#FFFFFF" align="center"><s:property value="date1"/> </td>

				   <td bgcolor="#FFFFFF" align="center"><a href="deleteInputLog.action?id=${id}" onclick="return tishi()">删除</a>
					</td>
					
				</tr>

			</s:iterator>

		</table>
		
</body>
</html>


