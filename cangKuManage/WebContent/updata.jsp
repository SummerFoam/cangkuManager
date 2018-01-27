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
		
				var xhr=new XMLHttpRequest();
		xhr.open('post','findRockByGoodsCategory.action',true);
		xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
		xhr.onreadystatechange =function(){
			if(xhr.readyState==4&&xhr.status==200){
				var result=JSON.parse(xhr.responseText);
				document.getElementById("rackid").value=result[0];
				document.getElementById("cangid").value=result[1];
			}
			
		}

		xhr.send('categoryName='+value);
	}
	
</script>

</head>

<body leftmargin="2" topmargin="9" background='<%=path%>/img/allbg.gif'>
	<form name="form1" action="updataSaveProduct.action?goodsId=${goods.goodsId }" method="post">
		<table width="98%" border="0" cellpadding="5" cellspacing="1"
			bgcolor="#D1DDAA" align="center" style="margin-top: 8px">
			<tr bgcolor="#E7E7E7">
				<td height="20" colspan="50" background="<%=path%>/images/tbg.gif">&nbsp;>>添加新商品&nbsp;</td>
			</tr>
			
  <tr>
  <td colspan=2><input type="hidden"  name="goods.goodsId" value="${goods.goodsId}" /></td>
  </tr> 
			
			<tr align='center' bgcolor="#FFFFFF"  
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td width="25%" bgcolor="#FFFFFF" align="right">所属类别：</td>
				<td colspan="2" width="75%" bgcolor="#FFFFFF" align="left"><select
					id="cid" name=goods.ofCategoryName onchange="input(this.value)" 
					onclick="input(this.value)" style="width: 150px">
					 <option value="${goods.ofCategoryName }">${goods.ofCategoryName }</option>
						<s:iterator value="list">
							<option value="${categoryName }"><s:property value="categoryName"/></option>
						</s:iterator>
				</select></td>
			</tr>
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
			   <td width="25%" bgcolor="#FFFFFF" align="right">商品名：</td>
				
				<td width="75%" bgcolor="#FFFFFF" align="left">
			<input type="text"  name="goods.goodsName" value=${goods.goodsName } />
				</td>
			</tr>
			
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
			   <td width="25%" bgcolor="#FFFFFF" align="right">数量：</td>
				
				<td width="75%" bgcolor="#FFFFFF" align="left">
				<input type="text"  name="goods.goodsCount" value="${goods.goodsCount }"/>
				</td>
				
			</tr>
			
				<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">商品单价：</td>
				
				<td width="75%" bgcolor="#FFFFFF" align="left">
				<input type="text"  name="goods.goodsPrice" value="${goods.goodsPrice }"/>
				</td>
				
			</tr>
		
				<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">进货员：</td>
				
				<td width="75%" bgcolor="#FFFFFF" align="left">
			<input type="text"  name="goods.inputManager" value="${goods.inputManager }"/>
				</td>
				
			</tr>
			
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">收货员：</td>
				
				<td width="75%" bgcolor="#FFFFFF" align="left">
				<input type="text"  name="goods.receiveManager" value="${goods.receiveManager }"/>
				</td>
			</tr>
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">进货日期：</td>
				
				<td width="75%" bgcolor="#FFFFFF" align="left">
				<input type="text" id="inputDate" name="goods.inputDate" value="<%out.print(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));%>" onblur="checkDate(this.value)"/>
				</td>
			</tr>
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">所属货架：</td>
				<td  width="75%" bgcolor="#FFFFFF" align="left">
				<input id="rackid" type="text" name="goods.ofRackId" value="${goods.ofRackId }" readonly/>
				</td>
			</tr>
			
			<tr align='center' bgcolor="#FFFFFF"
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				
				<td width="25%" bgcolor="#FFFFFF" align="right">所属仓库：</td>
				
				<td  width="75%" bgcolor="#FFFFFF" align="left">
				<input id="cangid"  type="text" name="goods.ofCangId" value="${goods.ofCangId }" readonly/>
				</td>
								
			</tr>
			
			<tr align='center' bgcolor="#FFFFFF" 
				onMouseMove="javascript:this.bgColor='red';"
				onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
				<td  width="25%" bgcolor="#FFFFFF" align="right">&nbsp;</td>
				<td  width="75%" bgcolor="#FFFFFF" align="left"><input
					type="submit" value="修改"  />&nbsp; <input type="reset"
					value="重置" />&nbsp;</td>
			</tr>
			
		</table>
	</form>
</body>
</html>
