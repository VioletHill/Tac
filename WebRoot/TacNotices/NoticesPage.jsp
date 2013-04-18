<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'NoticesPage.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <jsp:useBean id="notices" class="DataSource.Notices.Notices" scope="request">
  </jsp:useBean>
  
  <body>
    <div style="top:0; width:1200;  margin-right: auto; margin-left: auto;">
    	<%@include file="/Navigation/Navigation.jsp" %>
	 	
	 	<br>
	 	<br>
	 	<div>
	 		<div id="title" style="text-align:center">
	 			<%=notices.getTitle()%>
			</div>
			<div id="data" style="text-align:right">
				<%=notices.getData()%>
			</div>
			<br>
			<br>
			<div id="content">
				<%=notices.getContent()%>
			</div>
	 	</div>
	 	
	  	<%@include file="/Navigation/Footer.jsp" %>
    </div>
  </body>
</html>
