
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
    
    <title>Tac»Ÿ”˛ “</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="TacHonor/Honor.css">
   	<style>
  
  	  body
  	  {
  		padding: 0px;
  		margin: 0px;
  		background-image:url("image/mainBG.png");
  	  }
 	</style> 
 	
 	<script type="text/javascript" src="TacHonor/Honor.js"></script>
  </head>
  
    <jsp:useBean class="DataSource.Projects.AllProjects" id="allProjects" scope="request">
 	</jsp:useBean>
  
  <body>
	
	  
	 	<%@include file="/Navigation/Navigation.jsp" %>
	 	
	 	<div class="MainDiv">
	 		<%for (int i=0; i<allProjects.getProject().size(); i++)
	  	 	{%>
				<div class="ImageDiv">
					<img id="<%=i%>" name="<%=allProjects.getProject().get(i).getImage().size() %>"src="<%=allProjects.getProject().get(i).getImage().get(0) %>"onclick="linkToImg(this)" onmousemove="changeImg(this)" onmouseout="leaveImg(this)" style="margin-top:50">
					<div>
						<%=allProjects.getProject().get(i).getTitle() %>
					</div>
					<div>
						<%=allProjects.getProject().get(i).getDescription() %>
					</div>	
				</div>
			<%}%> 
		</div>
		
	  	<%@include file="/Navigation/Footer.jsp" %>
  </body>
  
  
</html>
