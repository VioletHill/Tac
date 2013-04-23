
<%@page import="com.sun.medialib.mlib.Image"%>
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

    <base href="<%=basePath%>">
    
    <title>Tac资料室</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
   	<style>
  
  	  body
  	  {
  		padding: 0px;
  		margin: 0px;
  	  }
 	</style> 
 	
  </head>
  
  <body>

	  <div  style="top:0; width:1200;  margin-right: auto; margin-left: auto;"  >
	 	<%@include file="/Navigation/Navigation.jsp" %>
	  	<%@include file="/Navigation/Footer.jsp" %>
	 </div>	  
	 <div id="searchDiv">		  
	  <form action="" method="get">
			<table>
				<tr>
					<td><input id="searchTF"  type="text" name="search" value="搜索资源"/></td>
					<td><input id="searchSlt" type="button" value="分类">
					<td><input id="searchSb" type="button"></td>
				</tr>
			</table>
		</form>
	</div>
	<div id="cateDiv">
		
	</div>
  </body>
  
  
</html>
