<%@ page language="java" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %> 
 <%@ taglib uri="/struts-tags" prefix="s" %>
     <%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
 
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
        
        <link rel="stylesheet" type="text/css" href="<%=path %>/css/base.css" />
        
        <script language="javascript">
            function c()
		    {
		         if(document.formAdd.name.value=="")
		         {
		             alert("请输入类别名称");
		             return false;
		         }
		         document.formAdd.submit();
		     }
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form name="for" action="inputLogSave.action" method="post">
				     <table width="98%" border="0" cellpadding="5" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="50" background="<%=path %>/images/tbg.gif">&nbsp;>>进货商品&nbsp;</td>
						</tr>
					
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						商品名称：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" id="productName" name="product.productName" value="${goodsName }"  readonly="readonly"  />
						    </td>
						</tr>
						
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						进货数量：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text"  name="product.productCount"/>
						    </td>
						</tr>
						
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						出货商家：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						      <input type="text"  name="product.shouHuo" />
						    </td>
						</tr>
						
							<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						进货员：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="text"  name="product.jinHuo" />
						    </td>
						</tr>
						
							<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						进货时间：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="text"  name="product.date1" value="<%out.print(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date()));%>" onblur="checkDate(this.value)"/>
						    </td>
						</tr>
						
						
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="submit" value="确认进货"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
