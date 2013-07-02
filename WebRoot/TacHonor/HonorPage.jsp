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
  
  <link type="text/css" rel="stylesheet"
	href="common/common.css" charset="utf-8"/>
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
   		<div class="HonorPageTitle">
   			<div style="margin-top:21">
				<img src="TacHonor/Image/HonorHeader.png" style="margin-left:23; margin-top:26;">
			</div>
			
			<div style="margin-left:95; margin-top:56;">
   				<p>
   					<img  src=<%=project.getCover_add()%> align="left">
   					<div style="height:19"></div>
					<p style="margin-left:252; font-size:27"><%=project.getTitle()%></p>
   					
   					<p style="margin-left:252; font-size:16.7">上架时间：<%= project.getDate() %></p>
   					<span style="margin-left:80; font-size:16.7">团队：</span>
   					<span style="font-size:16.7; color:#0e518a"><%= project.getDeveloper() %></span>
				</p>
			</div>		
   		</div>
   		
   		<div class="ImageScrollDiv">
   			<div class="ImageScroll" >
   				<div style="margin-left:94; margin-top:49; font-size:22; color:#6e6e6e">精选</div>
   				<div class="ImageViewContainer">
   					<%for (int i=0; i<project.getPicture().length; i++)
   					{%>
   						<img class="ImageView" src="<%=project.getPicture()[i]%>">
   			 	 <%}%>
   				</div>
   				<img class="LastView" onclick="preView(<%=project.getPicture().length %>);" onmousedown="this.style.opacity=0.2;" onmouseup="this.style.opacity=1;" src="TacHonor/Image/LastView.png">
   				<img class="NextView" onclick="nextView(<%=project.getPicture().length %>)" onmousedown="this.style.opacity=0.2;" onmouseup="this.style.opacity=1;" src="TacHonor/Image/NextView.png">
   			</div>
   		</div>
   	
   		<div style="background-color:white">
   			<div style="height:29; background-color:white"></div>
   			<div class="DecTitle">简介</div>
   			<div style="height:40px;"></div>
   			<div class="DecContent"><%=project.getContent() %></div>
   		</div>
   	</div>
   	
   	<%@include file="/Navigation/Footer.jsp" %>
  </body>
</html>
