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
	
	<script type="text/javascript">
	/* 	function init()
		{
			var contentDiv=document.getElementById("content");
			var position=contentDiv.getBoundingClientRect();
			
			var lastImg=document.createElement("img");
			
		 	lastImg.src="TacNotices/Image/LastNotice.png";
			lastImg.style.position="absolute";
			lastImg.id="lastNotice";
		 	lastImg.style.left=position.left;
		 	lastImg.style.top=(position.top+position.bottom)/2;
		 	
			
			contentDiv.appendChild(lastImg);
			
			var nextImg=document.createElement("img");
			nextImg.src="TacNotices/Image/LastNotice.png";
			nextImg.id="nextNotice";
			nextImg.style.position="absolute";
			nextImg.style.left=position.right+document.body.scrollLeft-nextImg.width;
			nextImg.style.top=(position.top+position.bottom)/2;
			contentDiv.appendChild(nextImg);
		}
		
		function resize()
		{
			var contentDiv=document.getElementById("content");
			var lastImg=document.getElementById("lastNotice");
			var position=contentDiv.getBoundingClientRect();
			lastImg.style.left=position.left;
		 	
		 	var nextImg=document.getElementById("nextNotice");
		 	nextImg.style.left=position.right+document.body.scrollLeft-nextImg.width;

		 	
		} */
	</script>
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
