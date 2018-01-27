<%@ page language="java" pageEncoding="UTF-8"%>

<%@ page isELIgnored="false" %> 
<%@taglib uri="/struts-tags" prefix="s"%>

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
            
            function validate(frm){
            	if(frm.name.value.length<=0){
            		alert("请输入用户名");
            		return false;
            	}else if(frm.pwd.value.length<=0){
            		alert("请输入密码");
            		return false;
            	}
            }
            var both="${both}";
            	if(both=="已有相同用户名"){
            		alert(both);
            	}
            
            
        </script>
	</head>

	<body leftmargin="2" topmargin="9" background='<%=path %>/img/allbg.gif'>
			<form name="frm" action="UpInManagers.action" method="post" onSubmit="return validate(this);">
				     <table width="98%" border="0" cellpadding="5" cellspacing="1" bgcolor="#D1DDAA" align="center" style="margin-top:8px">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="50" background="<%=path %>/images/tbg.gif">&nbsp;>>修改用户信息&nbsp;</td>
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						      ID：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text"name="m.id" id="id" readonly="readonly" value='<s:property value="#session.mana.id"/>' size="30"/>
						    </td>
						    
						</tr>
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						       用户名：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="m.name" id="name" value='<s:property value="#session.mana.name"/>' size="30"/>
						    </td>
						</tr>
						
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						       密码：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="m.password" id="pwd" value='<s:property value="#session.mana.password"/>' size="30"/>
						    </td>
						</tr>
						
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						      身份：
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						        <input type="text" name="m.position" readonly value='<s:property value="#session.mana.position"/>' size="30"/>
						    </td>
						</tr>
						
						
						<tr align='center' bgcolor="#FFFFFF" onMouseMove="javascript:this.bgColor='red';" onMouseOut="javascript:this.bgColor='#FFFFFF';" height="22">
						    <td width="25%" bgcolor="#FFFFFF" align="right">
						        &nbsp;
						    </td>
						    <td width="75%" bgcolor="#FFFFFF" align="left">
						       <input type="submit" value="修改" onclick="c()"/>&nbsp; 
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>
