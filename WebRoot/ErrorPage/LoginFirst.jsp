<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>LoginFirst</title>
    
    <link type="text/css" rel="stylesheet"
	href="common/common.css" charset="utf-8"/>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="ErrorPage/LoginFirst.css">
	
	<style>
  	  body
  	  {
  		padding: 0px;
  		margin: 0px;
  		background-image:url("image/mainBG.png");
  	  }
 	</style> 
		
 	<script type="text/javascript" src="jquery-1.9.1.js"></script>
 	<script type="text/javascript" src="ErrorPage/LoginFirst.js"></script>
 	<script type="text/javascript" src="MD5.js"></script>
  </head>
  
  <body>
  	<%@include file="/Navigation/Navigation.jsp" %>
  	
  	<div class="MainDiv">
  	
  		<img src="ErrorPage/Image/LoginFirst/loginFirst.png" class="loginFirst">
  		<form action="" method="post">
  			<div style="height:57px"></div>
  			<input type="text" id="account" class="account"  name="account" placeholder="ÓÃ»§Ãû"> <br>   	
			<input type="password" id="password" class="password" name="password" placeholder="ÃÜÂë"><br>
			<input class="Submit"  type="button" onclick="linkToRegister()">
   			<input class="Login" id="Login"  type="button" onclick="login()">
  		</form>
   		
   	</div>
   	
   	<%@include file="/Navigation/Footer.jsp" %>
  </body>
</html>
