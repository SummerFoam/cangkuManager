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
	if(confirm("确定要删除吗？")){
		return true;
		
	}
	
	return false;
	}

   <%--         function catelogDel(id)
           {
               if(confirm('您确定删除吗？'))
               {
                   window.location.href="<%=path%>/?type=can_update.action&cangId="+id;
               }
           }
            --%>
           function catelogAdd()
           {
                 var url="<%=path%>/selectAllProductType.action";
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
				<td height="14" colspan="100" background="">&nbsp;>>商品管理&nbsp;</td>
			</tr>
			<tr align="center" bgcolor="#FAFAF1" height="22">
				<th>ID</th>
				<th>商品类别</th>
				<th>商品名</th>
				<th>数量</th>
				<th>单价</th>
				<th>进货员</th>
				<th>收货员</th>
				<th>进货日期</th>
				<th>所属货架号</th>
				<th>所属仓库</th>
				<th>删除</th>
				<th>修改</th>
				<th>进货</th>
				<th>出货</th>
			</tr>
			
			<s:iterator value="list">
				<tr align='center' bgcolor="#FFFFFF"
					onMouseMove="javascript:this.bgColor='red';"
					onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
					
					
					<td bgcolor="#FFFFFF" align="center">
				 <s:property value="goodsId"/>
					</td>
					
					
					<td bgcolor="#FFFFFF" align="center">
					<s:property value="ofCategoryName"/> 
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="goodsName"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="goodsCount"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					<s:property value="goodsPrice"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					<s:property value="inputManager"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="receiveManager"/>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						<s:property value="inputDate"/> 
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
						 <s:property value="ofRackId"/> 
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					<s:property value="ofCangId"/>
					</td>
						
					<td bgcolor="#FFFFFF" align="center">
					<a href="deleteProduct.action?goodsId=${goodsId }" onclick="return tishi()">删除</a>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					<a href="updataFindProduct.action?goodsId=${goodsId }" target="content">修改</a>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
					<a href="inputLog.action?goodsId=${goodsId}">进货</a>
					</td>
					
					<td bgcolor="#FFFFFF" align="center">
				<a href="outputLog.action?goodsId=${goodsId}">出货</a>	
					</td>	
				</tr>
				
			</s:iterator>
			
		</table>
		
		<br><br>
<center>
<a href="selectAllProduct.action?pageIndex=1" target="content">首页</a>
<a href="selectAllProduct.action?pageIndex=${pageIndex-1 }" target="content">上一页</a>	
<a href="selectAllProduct.action?pageIndex=${pageIndex+1 }" target="content">下一页</a>	
<a href="selectAllProduct.action?pageIndex=${pageCount }" target="content">尾页</a>				          
<p style="color:red">当前第${pageIndex }页  共${pageCount}页</p>
</center>
		<table width='98%' border='0'
			style="margin-top: 8px; margin-left: 5px;">
			<tr>
				<td><input type="button" value="添加新商品" style="width: 80px;"
					onclick="catelogAdd()" /></td>
			</tr>
		</table>

</body>
</html>


