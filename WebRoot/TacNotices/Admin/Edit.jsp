<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<style>
  		<%@include file="/TacNotices/NoticesItem.css" %>  
  	</style>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
     <jsp:useBean class="DataSource.Notices.AllNotices" id="allNotices" scope="request">
   	</jsp:useBean>
  
  <body>
   	 <div  style="top:0; width:1200;  margin-right: auto; margin-left: auto;"  >
	 	<%@include file="/Navigation/Navigation.jsp" %>
	 	
	 	<br>
	 	<% for (int i=0; i<allNotices.getAllNotices().size(); i++)
	 	{%>
	 		<div style="overflow:hidden;">
	 			<a class="NoticesItem" href="http://localhost:8080/Tac/Admin/EditIndexNotices?index=<%=allNotices.getAllNotices().get(i).getNotice_id()%>"> <%=allNotices.getAllNotices().get(i).getNotice_title() %> </a>
	 			<div style="float:right"> <%=allNotices.getAllNotices().get(i).getData() %> </div>
	 		</div>
	  <%}%>
	 	
	 	<br>
	 	<br>
	 	<a class="NoticesItem" href="http://localhost:8080/Tac/Admin/EditIndexNotices" style="float:right">添加新通知</a>
	  	<%@include file="/Navigation/Footer.jsp" %>
	 </div>	  
  </body>
</html>
