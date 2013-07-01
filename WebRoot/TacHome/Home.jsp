<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">	
	body {
		background-image: url("image/mainBG.png");
		padding: 0px;
		margin: 0px;
	}
	
  </style>

  	<script src="jquery-1.9.1.js"></script>
 	<script src="jQueryRotate.2.2.js"></script>
    <base href="<%=basePath%>">
      
    
    <title>欢迎来到Tac</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  
  <body onload="init()">

	<%@include file="Navigation/HomeNavigation.jsp" %>
	<br>
   	<!-- 信息栏目 -->
    <%@include file="Notices/HomeNotices.jsp"%> 
      
    <!-- 荣誉室 -->
	<%@include file="Honor/HomeHonor.jsp" %>
    
    <%@include file="/Navigation/Footer.jsp" %> 
	</body>
</html>