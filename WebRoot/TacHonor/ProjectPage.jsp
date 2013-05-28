<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ProjectPages.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
  <body>
   	<jsp:useBean class="DataSource.Projects.Projects" id="project" scope="request">
   	</jsp:useBean>

   	
    <div id="mainDiv" style="top:0; width:1200; margin-right: auto; margin-left: auto;"  >
	 	<%@include file="/Navigation/Navigation.jsp" %>
	 	
	 	
	 	
	  	<div id="ProjectImageId" style="float:left">
			<script type="text/javascript">
				<%for (int i=0; i<project.getImage().size(); i++)
				{%>
					newDiv=document.createElement("div");
					newDiv.setAttribute("style","float:left; width:600; height:300; background-color:green; text-align:center");
					newImage=document.createElement("img");
					newImage.setAttribute("style","margin-top:50");
					newImage.setAttribute("src","<%=project.getImage().get(i)%>" );
					document.getElementById("ProjectImageId").appendChild(newDiv);
					newDiv.appendChild(newImage);
				<%}%>
			</script>
		</div>
	  	<%@include file="/Navigation/Footer.jsp" %>
	 </div>	  
  </body>
</html>
