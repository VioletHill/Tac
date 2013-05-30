<%@page import="com.sun.corba.se.spi.activation.Server"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Tac–¬œ  ¬</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <jsp:useBean id="notice" class="DataSource.Notices.Notice" scope="request">
  </jsp:useBean>
  
  <body>
    <div style="top:0; width:1200;  margin-right: auto; margin-left: auto;">
    	<%@include file="/Navigation/Navigation.jsp" %>
	 	
	 	<br>
	 	<br>
	 	<div>
	 		<div id="title" style="text-align:center; word-break:break-all; margin-left:100; margin-right:100">
	 			<%=notice.getNotice_title()%>
			</div>
			<div id="data" style="text-align:right;  margin-left:100; margin-right:100">
				<%=notice.getData()%>
			</div>
			<br>
			<br>
		
			<div id="content" style="word-break:break-all; background-color:red">
				<div style="margin-left:100; margin-right:100">
					<%=notice.getNotice_html()%>
				</div>
			</div>
	 	</div>
	 	
	 	<br>
	  	<%@include file="/Navigation/Footer.jsp" %>
    </div>
  </body>
</html>
