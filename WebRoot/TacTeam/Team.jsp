
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
  		<!--help navigation -->
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
  		
  		<div style="background-color:white">
  		<br>
  		<div id="contentDiv" style="width:830; position:relative; left:300;">
  			<%
  			for (int i=0; i<allTeam.getAllTeams().size(); i++)
  			{%>
				<div style="background-color:rgb(146,192,60);" >
  				<!-- 日期 -->
  				<%if (i==0 || allTeam.getAllTeams().get(i-1).getMonth()!=allTeam.getAllTeams().get(i).getMonth() || allTeam.getAllTeams().get(i-1).getDay()!=allTeam.getAllTeams().get(i).getDay())
  				{%>
  				<div  style=" background-color:red; width:40; height:40; position:relative; left:-200; top:38;">
  					<div>
  						<img src="ab">
  					</div>
  					<div>
  						<img src="ab">
  					</div>
  				</div>
  				<%}%>
  				
  				<!-- 头像 -->
  				<div class="headDiv" style="float:left; position:relative; left:-50;">
  					<img src=<%=allTeam.getAllTeams().get(i).getPublishUser().getHeader_add() %>>
  				</div>
  	
  				<!-- 内容 -->
  				<div style="position:relative; left:30;">
					<table frame="box" style="background-color:white;">
  						<tr>
  							<td>
  								<!-- 标题 -->
  								<table>
  									<tr>
  										<td><%=allTeam.getAllTeams().get(i).getPublishUser().getUser_id()%></td>
  										<td>发布于 <%=allTeam.getAllTeams().get(i).getType()%></td>
  										<td><%=allTeam.getAllTeams().get(i).getTitle()%></td>
  										<td><div style="width:20; overflow:hidden">asdfdafasdfsdfasdfsadfsadfksdalfjksadf;kadsf</div></td>
  										<td>dd</td>
  									</tr>
  								</table>	
  								<!-- end 标题 -->
  								<%if (allTeam.getAllTeams().get(i).getType()==1) 
  								{%>
  									<td><img src="TacTeam/Image/iamin.png" style="float:right;"></td>
  							  <%}%>
  							</td>
						<tr>
							<td>
								<div style="width:700; position:relative; word-break:break-all">
  									<p style="text-align:left;">ljflasdjflsdkjfljasdsfjalskdjffalksdfjkkafljflasdjflsdkjfljasdsfjalskdjffalksdfjkkafljflasdjflsdkjfljasljflasdjflsdkjfljasdsfjalskdjffalksdfjkkafljflasdjflsdkjfljasdsfjalskdjffalksdfjkkafljflasdjflsdkjfljas</p>
  								</div>
							</td>
  						</tr>
						<tr>
							<td>
								<div style="float:left"><img src="ds"></div><div style="float:left"><img src="ds"></div>
							</td>
							<td style="float:right">
								<img src="TacTeam/Image/like.png">
								<span>
									d
								</span>
							<td>
						</tr>	
  					</table>
  					<div>
  						asjk
  					</div>
  					<br>
  				</div>
  				<!-- end 内容 -->
  				</div>
  		   <%}%> 
  		</div>
  		<br>
  	</div>
  	</div>
  	<%@include file="/Navigation/Footer.jsp" %>
  </body>
</html>
