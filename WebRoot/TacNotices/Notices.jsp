<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	 <style type="text/css">
	 	 <%@include file="/TacNotices/NoticesItem.css" %> 
		 
	</style>
	
    <base href="<%=basePath%>">
    
    <title>Tac新鲜事</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
  </head>
  
   <jsp:useBean id="allNotices" class="DataSource.Notices.AllNotices" scope="request">
  </jsp:useBean>
  <body>
     <div  style="top:0; width:1200;  margin-right: auto; margin-left: auto;"  >
	 	<%@include file="/Navigation/Navigation.jsp" %>
	 	<div>
	 		<form action="" method="post">
	 			<input type="text" value="搜索信息" style="width:100">
	 		
	 		</form>
	 		
	 		<br>
			<a style="clear:both"></a>
	 		<div style="top:30; width:1000; margin-left:auto; margin-right:auto">
	 		<%if  (!allNotices.getAllNotices().isEmpty())
	 		{%>
	 		 	<table >
	 			 	<%for (int i=0; i<allNotices.getAllNotices().size(); i++)
	 				{%>
 	 				 <tr style="height:30">
	 					<td style="text-align:left"> 
	 						<a href="http://localhost:8080/Tac/Notices/NoticesPage?indexNotices=<%=i%>" class="NoticesItem" ><%=allNotices.getAllNotices().get(i).getTitle() %>"</a>
	 						<span  style="color:red;"><%=allNotices.getAllNotices().get(i).getData()%></span>
	 					</td>
	 				</tr> 
 	 			   <%}%> 
	 		 	</table>
	 		<%}%>	
	 		</div>
	 	</div>
	  	<%@include file="/Navigation/Footer.jsp" %>
	 </div>	  
  </body>
</html>
