<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TeamPublish.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="TacTeam/TeamPublish.css">
	
	<script src="jquery-1.9.1.js"></script>
	<script type="text/javascript" src="TacTeam/Team.js"></script>
	
	<style>
		body 
		{
			background-image: url("image/mainBG.png");
			padding: 0px;
			margin: 0px;
		}
	</style>
  </head>
  
  <body>
  
     <%@include file="/Navigation/Navigation.jsp" %>
   
     <div class="mainDiv">
     		<table class="helpTable">
				<tr>
					<!-- ��� -->
					<td>
						<div id="cataTypeDiv">
							<input type="button" id="teamType" value="��ļ" onmouseover="showTypeItem();" onclick="changeTypeState()">
							<div id="cataTypeLog">
								 <table cellspacing="0" cellpadding="0">	
								  	<tr><td id="enlist">��ļ</td></tr>			
									<tr><td id="create">����</td></tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
     	<form>
     		<input type="hidden" name="type" value="0">
     		<input type="text" name="title">	<br>
     		<input type="hidden" name="content" value="">
     		<textarea rows="10" cols="4" ></textarea>
     	</form>
     </div>
     
     <%@include file="/Navigation/Footer.jsp" %>
  </body>
</html>
