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
    
    <title>TacĞÂÏÊÊÂ</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="TacNotices/NoticesPage.css">
	<style>
		body 
		{
			background-image: url("image/mainBG.png");
			padding: 0px;
			margin: 0px;
		}
	</style>
  </head>

  <jsp:useBean id="notice" class="DataSource.Notices.Notice" scope="request">
  </jsp:useBean>
  
  <body>
  
    <%@include file="/Navigation/Navigation.jsp" %>
    <div style="top:0; width:1200;  margin-right: auto; margin-left: auto; background-color:white">	
	 	<br>
	 	<br>
	 	<div>
	 		<div id="title" class="ContentTitle">
	 			<%=notice.getNotice_title()%>
			</div>
			
			<div id="data" class="ContentData">
				<%=notice.getData()%>
			</div>
			
			<br>
			<br>
		
			<div id="content" style="word-break:break-all;">
				<div style="margin-left:100; margin-right:100">
					<%=notice.getNotice_html()%>
				</div>
			</div>
	 	</div>
	 	
	 	<br>
    </div>
    <%@include file="/Navigation/Footer.jsp" %>
  </body>
</html>
