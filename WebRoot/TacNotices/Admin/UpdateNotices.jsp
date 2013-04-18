<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddNotices.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<script type="text/javascript">
		function checkForm(form)
		{
	
			if (form.title.value=="")
			{	
				alert("标题不能为空");
				return false;
			}
			if (form.content.value=="")
			{
				alert("内容不能为空");
				return false;
			}
			return true;
		}
	</script>
  
  </head>
  
  <jsp:useBean id="notices" class="DataSource.Notices.Notices" scope="request">
  </jsp:useBean>
  
  <body>
    <div  style="top:0; width:1200;  margin-right: auto; margin-left: auto;"  >
	 	<%@include file="/Navigation/Navigation.jsp" %>
	 	
	 	<div style="width:700; margin-right:auto; margin-left:auto">
	 		<br>
	 		<br>
	 		<form name="notices" onsubmit="return checkForm(this);" action="/Tac/UpdateNotices" method="POST" style="text-align:center">
	 			<input type="text" value="<%=notices.getTitle() %>" name="title" style="width:300; height:50; text-align:center"> 
	 			<br>
	 			<br>
	 			<br>
	 			
	 			<textarea name="content" style="width:700; height:800;"></textarea>
	 			<input type="submit" style="width:100; height:100; font-size:20">
	 		</form>
	 	</div>
	 	
	  	<%@include file="/Navigation/Footer.jsp" %>
	 </div>	  
  </body>
</html>
