<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <style type="text/css">
	
	<%@include file="Navigation/HomeNavigation.css" %>
  	body{
  		padding: 0px;
  		margin: 0px;
  	}
  
 	 .container
  	{
  		position:relative;
  		top:164px;
  		left:0px;
  		width:614;
  		height:384px;
  		white-space:nowrap;
		overflow:hidden;
  	}
  
 	.imageWheel
 	{
  		position:relative;
  		left:0;
  		top:0;
  	}
 	.pageing
 	{
		position:relative;
		left:540px;
		top:-30;
		z-index:100;
 	}
  </style>
  
  <script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
 
    <base href="<%=basePath%>">
      
    
    <title>��ӭ����Tac</title>
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
	
   	<!-- ��Ϣ��Ŀ -->

    <%@include file="Notices/HomeNotices.jsp"%>
    <!-- ������ -->
	<%@include file="Honor/HomeHonor.jsp" %>
    
    <%@include file="/Navigation/Footer.jsp" %>
	</body>
</html>