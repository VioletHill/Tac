<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
 <jsp:useBean class="DataSource.Honor.Honor" id="project" scope="request">
 	</jsp:useBean>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title><%=project.getTitle()%></title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="TacHonor/HonorPage.css">
	
	<script type="text/javascript" src="TacHonor/HonorPage.js"></script>
	<script type="text/javascript" src="jquery-1.9.1.js"></script>
	
	<style>
  
  	  body
  	  {
  		padding: 0px;
  		margin: 0px;
  		background-image:url("image/mainBG.png");
  	  }
 	</style> 
  </head>
  
  <body>
   	<%@include file="/Navigation/Navigation.jsp" %>
   	
   	<div class="MainDiv">
   		<div style="background-color:white">
   			<p>
   			<%-- 	<img src="<%=project.getAppString()%>"> --%>
   				<img  src=<%=project.getCover_add()%> align="left">
				<p style="position:relative; left:100;"><%=project.getTitle()%></p>
   				<br>
   				<p>上架时间：<%= project.getDate() %></p>
   				<p>开发团队：<%= project.getDeveloper() %></p>
			</p>		
   		</div>
   		
   		<div class="ImageScroll" >
   			<div class="ImageViewContainer">
   				<%for (int i=0; i<project.getPicture().length; i++)
   				{%>
   					<img class="ImageView" src="<%=project.getPicture()[i]%>">
   			  <%}%>
   			</div>
   		</div>
   		<img class="LastView" onclick="preView(<%=project.getPicture().length %>);" onmousedown="this.style.opacity=0.2;" onmouseup="this.style.opacity=1;" src="TacHonor/Image/LastView.png">
   		<img class="NextView" onclick="nextView(<%=project.getPicture().length %>)" onmousedown="this.style.opacity=0.2;" onmouseup="this.style.opacity=1;" src="TacHonor/Image/NextView.png">
   		
   		<div style="background-color:white">
   			<p style="position:relative; left:100">简介</p>	
   			<p style="position:relative; left:100"><%=project.getContent() %></p>
   		</div>
   	</div>
   	
   	<%@include file="/Navigation/Footer.jsp" %>
  </body>
</html>
