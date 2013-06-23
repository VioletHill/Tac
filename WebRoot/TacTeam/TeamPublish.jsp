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
	<script type="text/javascript" src="TacTeam/TeamPublish.js"></script>
	
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
					<td>
						<span>
							发布
						</span>	
					</td>
					<!-- 类别 -->
					<td>
						<div id="cataTypeDiv">
							<input type="button" id="teamType" value="招募" onmouseover="showTypeItem();" onclick="changeTypeState()">
							<div id="cataTypeLog">
								 <table cellspacing="0" cellpadding="0">	
								  	<tr><td id="enlist">招募</td></tr>			
									<tr><td id="create">创意</td></tr>
								</table>
							</div>
						</div>
					</td>
				</tr>
			</table>
		<br>
     	<form method="post">
     		<input type="hidden" name="type" value="0">
     		<span class="titleFont">标题</span><input type="text" class="title" name="title" maxlength="10">	<br>
     		<br>
     		<input type="hidden" name="content" value="">
     		<textarea class="content" id="content" onkeyup="checkContentNumber()"></textarea>
     		<div id="contentNumber">140</div><br>
     		<br>
     		<input type="reset" class="cancelButton" value="">
     		<input type="submit" class="publishButton" value="">
     	</form>
     	<br>
     </div>
     
     <%@include file="/Navigation/Footer.jsp" %>
  </body>
</html>
