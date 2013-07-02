
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

    <jsp:useBean class="DataSource.Honor.AllHonor" id="allHonor" scope="request">
 	</jsp:useBean>
 	
  <head>

    <base href="<%=basePath%>">
    
    <title>Tac»Ÿ”˛ “</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	
	<link rel="stylesheet" type="text/css" href="TacNotices/NoticesItem.css">
	<link rel="stylesheet" type="text/css" href="TacHonor/Honor.css">
	<link rel="stylesheet" href="LightBoxCss/lightbox.css" type="text/css" media="screen" />
	<link rel="stylesheet" href="LightBoxCss/screen.css" type="text/css" media="screen" />
	
   	<style>
  
  	  body
  	  {
  		padding: 0px;
  		margin: 0px;
  		background-image:url("image/mainBG.png");
  	  }
 	</style> 
 	
 	<script type="text/javascript" src="jquery-1.9.1.js"></script>
 	<script type="text/javascript" src="TacHonor/Honor.js"></script>
 	<script type="text/javascript" src="LightBoxJs/prototype.js"></script>
	<script type="text/javascript" src="LightBoxJs/scriptaculous.js?load=effects"></script>
	<script type="text/javascript" src="LightBoxJs/lightbox.js"></script>
	<script type="text/javascript" src="LightBoxJs/effects.js"></script>
	
  </head>

  
  <body>
  	<%@include file="/Navigation/Navigation.jsp" %>
	<div class="ImageContain">
		<div style="margin-top:21">
			<img src="TacHonor/Image/HonorHeader.png" style="margin-left:23; margin-top:26;">
		</div>
		<div style="height:40">
		</div>
	 	<%for (int i=0; i<allHonor.getList().size(); i++)
	  	 {%>

			<%if (i%4==0)
			{%>
				<div class="ImageDiv" style="margin-left:108">
			<%}
			else
			{%>
				<div  class="ImageDiv">
			<%}%>
				<a href="<%=allHonor.getList().get(i).getPicture()[0]%>" rel="lightbox[<%=i%>]">
					<img name="<%=i%>" src="<%=allHonor.getList().get(i).getPicture()[0] %>" onmousemove="changeImg(this)" onmouseout="leaveImg(this)">
				</a>
				
				<div class="HonorTitle">
					<a style="color:#666666;" href="Honor/Project?id=<%=allHonor.getList().get(i).getHonor_id()%>"><%=allHonor.getList().get(i).getTitle() %></a>
				</div>
				
				<a href="<%=allHonor.getList().get(i).getPicture()[0]%>" rel="changeImg[<%=i%>]"></a>
				<%for (int j=1; j<allHonor.getList().get(i).getPicture().length; j++) 
	  	 		{%>
	  	 			<a href="<%=allHonor.getList().get(i).getPicture()[j]%>" rel="changeImg[<%=i%>]"></a>
	  	 			<a href="<%=allHonor.getList().get(i).getPicture()[j]%>" rel="lightbox[<%=i%>]"></a>	
			  <%}%>
			</div>
		<%}%> 
	</div>
	
	<%@include file="/Navigation/Footer.jsp" %>
  </body>
  
  
</html>
  