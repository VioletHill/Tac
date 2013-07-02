<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  
  <link type="text/css" rel="stylesheet"
	href="common/common.css" charset="utf-8"/>
    <base href="<%=basePath%>">
    
    <title>发布你的求包养吧</title>
    
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
  
  <body onload="init()">
  
     <%@include file="/Navigation/Navigation.jsp" %>
   
     <div class="mainDiv">
     		<div style="height:23px"></div>
     		<table class="helpTable">
				<tr>
					<td><span style="font-size:30px; color:#44a9dd;">发布</span></td>
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
     	<form method="post" action="Team/TeamPublish" onsubmit="return checkTeamPublish()">
     		<input type="hidden" name="type" value="0">
     		<div style="height:102"></div>
     		
     		<span class="titleFont">标题</span><input type="text" class="title" name="title" maxlength="10">	<br>
     		<br>
     		<!-- <input type="hidden" name="content" value=""> -->
     		<span class="titleFont" id="contentFont">正文</span><textarea class="content" id="content" name="content" onkeyup="checkContentNumber()"></textarea>
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
