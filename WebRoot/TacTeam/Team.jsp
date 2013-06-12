
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Tac求包养</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="TacTeam/Team.css">
	
	<script src="jquery-1.9.1.js"></script>
	<script type="text/javascript" src="TacTeam/Team.js"></script>
	
	<style>
		body {
		background-image: url("image/mainBG.png");
		padding: 0px;
		margin: 0px;
		}
	</style>
  </head>
  
  <jsp:useBean id="allTeam" class="DataSource.Team.AllTeam" scope="request"></jsp:useBean>
  
  <body onload="init()">
  
    <%@include file="/Navigation/Navigation.jsp" %>
    
  	<div class="mainDiv">
  		<!-- navigation -->
  		<div>
  			<form action="Team" method="post" id="form">
  				<table class="helpTable">
					<tr>
						<!-- 类别 -->
						<td>
							<div id="cataTypeDiv">
								<input type="button" id="teamType" value="所有" onmouseover="showTypeItem();" onclick="changeTypeState()">
								<div id="cataTypeLog">
								 	<table cellspacing="0" cellpadding="0">	
									  	<tr><td id="enlist">招募</td></tr>			
										<tr><td id="create">创意</td></tr>
										<tr><td id="allType">所有</td></tr>
									</table>
								</div>
							</div>
						</td>
						<!-- 所有人类别 -->
						<td>
							<div id="cataPeopleDiv">
								<input type="button" id="teamPeople" value="所有人" onmouseover="showPeopleItem();" onclick="changePeopleState()">
								<div id="cataPeopleLog">
								 	<table cellspacing="0" cellpadding="0">	
									  	<tr><td id="myPeople">我发布的</td></tr>			
										<tr><td id="myTeamPeople">我加入的</td></tr>
										<tr><td id="allPeople">所有人</td></tr>
									</table>
								</div>
							</div>	
						</td>
						
						<td><button type="button" id="publishButton"></button></td>
					</tr>
				</table>	
  			</form>
  		</div>
  		<!-- end help navigation -->
  		
  		<div style="clear:both"> </div>
  		<br>
  		<div>
  			<%
  			for (int i=0; i<allTeam.getAllTeams().size(); i++)
  			{%>
  				<div>
  					<img src="<%= allTeam.getAllTeams().get(i).getPublishUser().getHeader_add()%>">
  					<div style="widht:50; height:100; background-color:red">
  						<span><%=allTeam.getAllTeams().get(i).getPublishUser().getUser_id()%></span>
  						<span>发布于 <%=allTeam.getAllTeams().get(i).getType()%></span>
  						<span><%=allTeam.getAllTeams().get(i).getTitle()%></span>
  					</div>
  				</div>		
  		   <%}%> 
  		</div>
  	</div>
  	<%@include file="/Navigation/Footer.jsp" %>
  </body>
</html>
