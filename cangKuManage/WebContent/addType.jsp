<%@ page language="java" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="pragma" content="no-cache" />
<meta http-equiv="cache-control" content="no-cache" />
<meta http-equiv="expires" content="0" />
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
<meta http-equiv="description" content="This is my page" />

<link rel="stylesheet" type="text/css" href="<%=path%>/css/base.css" />

<script language="javascript">
	function c() {
		if (document.formAdd.name.value == "") {
			alert("请输入类别名称");
			return false;
		}
		document.formAdd.submit();
	}

	var noinput="${addcate}";
    if(noinput=="亲，已存在该类别，请重新添加"){
    	alert(noinput);
    }
	
</script>
</head>

<body leftmargin="2" topmargin="9" background='<%=path%>/img/allbg.gif'>
	<form action="addTypeAction.action" method="post" name="formAdd">
		<table width="98%" border="0" cellpadding="5" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="20" colspan="50" background="<%=path%>/images/tbg.gif">&nbsp;>>添加货架&nbsp;</td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">所属货架：</td>
				<td rowpan="2" width="75%" bgcolor="#FFFFFF" align="left"><select
					name="gcd.ofRackid" style="width: 150px">
						<option value="">请选择货架</option>
						<s:iterator value="RBList">
							<option value="${RackId}">${RackId}</option>
						</s:iterator>
				</select></td>
			</tr>

			<%-- <tr>
			<s:select list="RBList" name="gcd.ofRackid" label="所属货架名"
				listKey="RackId" listValue="RackId" headerKey="0"
				headerValue="---请选择货架---" />
		</tr> --%>

			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">类别编号：</td>
				<td width="75%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="gcd.categoryId" id="categoryId" size="30" /></td>
			</tr>

			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">类别名：</td>
				<td width="75%" bgcolor="#FFFFFF" align="left"><input
					type="text" name="gcd.categoryName" id="categoryName" size="30" />
				</td>
			</tr>

			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">&nbsp;</td>

				<td width="75%" bgcolor="#FFFFFF" align="left"><input
					type="submit" value="添加" onclick="c()" />&nbsp; <input type="reset"
					value="重置" />&nbsp;</td>
			</tr>
		</table>
	</form>
</body>
</html>
