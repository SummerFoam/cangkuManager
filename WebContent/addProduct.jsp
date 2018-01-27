<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
	function input(value) {

		var xhr = new XMLHttpRequest();
		xhr.open('post', 'findRockByGoodsCategory.action', true);
		xhr.setRequestHeader("Content-type",
				"application/x-www-form-urlencoded");
		xhr.onreadystatechange = function() {
			if (xhr.readyState == 4 && xhr.status == 200) {
				var result = JSON.parse(xhr.responseText);
				document.getElementById("rackid").value = result[0];
				document.getElementById("cangid").value = result[1];
			}

		}

		xhr.send('categoryName=' + value);
	}
	function checkName(value) {
		if (value.length == 0) {
			document.getElementById("info").innerHTML = "请输入商品名";
		} else {
			var xhr = new XMLHttpRequest();
			xhr.open('post', 'checkProductName.action', true);
			xhr.setRequestHeader("Content-type",
					"application/x-www-form-urlencoded");
			xhr.onreadystatechange = function() {
				if (xhr.readyState == 4 && xhr.status == 200) {
					var object = JSON.parse(xhr.responseText);
					document.getElementById("info").innerHTML = object;
				}

			}
			xhr.send('goodsName=' + value);
		}
	}
	function checkCount(value) {
		if (value.length == 0) {
			document.getElementById("count").innerHTML = "请输入数量";
		}
	}
	function checkPrice(value) {
		if (value.length == 0) {
			document.getElementById("price").innerHTML = "请输入单价";
		}
	}
	function checkInput(value) {
		if (value.length == 0) {
			document.getElementById("input").innerHTML = "请输入进货员";
		}
	}
	function checkReceive(value) {
		if (value.length == 0) {
			document.getElementById("receive").innerHTML = "请输入收货员";
		}
	}
	function checkDate(value) {
		if (value.length == 0) {
			document.getElementById("date").innerHTML = "请输入进货日期";
		}
	}
	function secondCheck() {
		if (document.getElementById("goodsName").value <= 0
				|| document.getElementById("goodsCount").value <= 0
				|| document.getElementById("goodsPrice").value <= 0
				|| document.getElementById("inputManager").value <= 0
				|| document.getElementById("receiveManager").value <= 0
				|| document.getElementById("inputDate").value <= 0
				|| document.getElementById("rackid").value <= 0
				|| document.getElementById("cangid").value <= 0) {
			alert("信息不完整");
			return false;
		} else {
			return true;
		}
	}
</script>

</head>

<body leftmargin="2" topmargin="9" background='<%=path%>/img/allbg.gif'>
	<form name="form1" action="addProduct.action" method="post" onSubmit="return secondCheck()">
		<table width="98%" border="0" cellpadding="5" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="20" colspan="50" background="<%=path%>/images/tbg.gif">&nbsp;>>添加新商品&nbsp;</td>
			</tr>
			<tr align='center' bgcolor="#FFFFFF"  
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">所属类别：</td>
				<td colspan="2" width="30%" bgcolor="#FFFFFF" align="left"><select
					id="cid" name=goods.ofCategoryName onchange="input(this.value)"
					onclick="input(this.value)" style="width: 150px">
						<option value="">请选择类别</option>
						<s:iterator value="list">
							<option value="${categoryName }"><s:property value="categoryName"/></option>
						</s:iterator>
				</select></td>
			</tr>
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
			   <td width="25%" bgcolor="#FFFFFF" align="right">商品名：</td>
				
				<td width="30%" bgcolor="#FFFFFF" align="left">
				<input type="text" id="goodsName" name="goods.goodsName" onblur="checkName(this.value)"/>
				</td>
				
				<td align="left">
				<font color="red" size="2"><label id="info"></label></font>
				</td>
			</tr>
			
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
			   <td width="25%" bgcolor="#FFFFFF" align="right">数量：</td>
				
				<td width="30%" bgcolor="#FFFFFF" align="left">
				<input type="text" id="goodsCount" name="goods.goodsCount" onblur="checkCount(this.value)"/>
				</td>
				
				<td align="left">
				<font color="red" size="2"><label id="count"></label></font>
				</td>
			</tr>
			
				<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">商品单价：</td>
				
				<td width="30%" bgcolor="#FFFFFF" align="left">
				<input type="text" id="goodsPrice" name="goods.goodsPrice" onblur="checkPrice(this.value)"/>
				</td>
				
				<td align="left"><font color="red" size="2"><label id="price"></label></font></td>
			</tr>
			
			
				<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">进货员：</td>
				
				<td width="30%" bgcolor="#FFFFFF" align="left">
				<input type="text" id="inputManager" name="goods.inputManager" onblur="checkInput(this.value)"/>
				</td>
				
				<td align="left"><font color="red" size="2"><label id="input"></label></font></td>
			</tr>
			
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">收货员：</td>
				
				<td width="30%" bgcolor="#FFFFFF" align="left">
				<input type="text" id="receiveManager" name="goods.receiveManager" onblur="checkReceive(this.value)"/>
				</td>
				
				<td align="left"><font color="red" size="2"><label id="receive"></label></font></td>
			</tr>
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">进货日期：</td>
				
				<td width="30%" bgcolor="#FFFFFF" align="left">
				<input type="text" id="inputDate" name="goods.inputDate" value="<%out.print(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));%>" onblur="checkDate(this.value)"/>
				</td>
				
				<td><font color="red" size="2"><label id="date"></label></font></td>
			</tr>
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">所属货架：</td>
				<td colspan=2 width="30%" bgcolor="#FFFFFF" align="left">
				<input id="rackid"  type="text" name="goods.ofRackId" readonly/>
				</td>
			</tr>
			

			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">所属仓库：</td>
				
				<td colspan=2 width="30%" bgcolor="#FFFFFF" align="left">
				<input id="cangid"  type="text" name="goods.ofCangId" readonly/>
				</td>
					
					
			</tr>
			
	
			<tr align='center' bgcolor="#FFFFFF" 
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td  width="25%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
				<td colspan=2 width="30%" bgcolor="#FFFFFF" align="left"><input
					type="submit" value="添加"  />&nbsp; <input type="reset"
					value="重置" />&nbsp;</td>
			</tr>
			
		</table>
	</form>
</body>
</html>
