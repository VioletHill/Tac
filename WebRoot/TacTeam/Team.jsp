
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
    
    <title>Tac求包养</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="TacTeam/Team.css">
	<link rel="stylesheet" type="text/css" href="TacNotices/NoticesItem.css">
	
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
  
  	 <%
		if (session.getAttribute("isLog")==null || session.getAttribute("isLog").equals(false))
		{
			response.sendRedirect("/Tac/ErrorPage/LoginFirst.jsp"); 
			return ;
		} 
	%>
  
  <body onload="init()">
  
    <%@include file="/Navigation/Navigation.jsp" %>
    
    <form id="form" method="post">
    	<input type="hidden" id="peopleTypeText" name="peopleType" value="<%=allTeam.getPeopleType()%>">
    	<input type="hidden" id="typeText" name="type" value="<%=allTeam.getType()%>">
    	<input type="hidden" id="pageText" name="page" value="<%=allTeam.getPageIndex()%>">
    </form>
    
  	<div class="mainDiv">
  		<!--help navigation -->
  		<div>
  			<form action="Team" method="post" id="form">
  				<table class="helpTable">
					<tr>
						<!-- 类别 -->
						<td>
							<div id="cataTypeDiv">
								<%
								String type=null;
									if (allTeam.getType()==0)  type="  创意";
									else if (allTeam.getType()==1) type="  招募";
									else type="  所有";
								%>
								<input type="button" id="teamType" value="<%=type%>" onmouseover="showTypeItem();" onclick="changeTypeState()" style="font-size:23; text-align:left">
								<div id="cataTypeLog">
								 	<table cellspacing="0" cellpadding="0">	
									  	<tr><td id="crate" class="TopHover" onclick="changeType(0)" onmouseover="enterItem(this)" onmouseout="outItem(this)"><span class="TypeFont">创意</span></td></tr>			
										<tr><td id="enlist" class="MidHover" onclick="changeType(1)" onmouseover="enterItem(this)" onmouseout="outItem(this)"><span class="TypeFont">招募</span></td></tr>
										<tr><td id="allType" class="BottomHover" onclick="changeType(2)" onmouseover="enterItem(this)" onmouseout="outItem(this)"><span class="TypeFont">所有</span></td></tr>
									</table>
								</div>
							</div>
						</td>
						<!-- 所有人类别 -->
						<td>
							<div id="cataPeopleDiv">
								<%
								String peopleType=null;
									if (allTeam.getPeopleType()==0)  peopleType="  我发布";
									else if (allTeam.getPeopleType()==1) peopleType="  我喜欢";
									else peopleType="  所有的";
								%>
								<input type="button" id="teamPeople" value="<%=peopleType %>" onmouseover="showPeopleItem();" onclick="changePeopleState()" style="font-size:23; text-align:left">
								<div id="cataPeopleLog">
								 	<table cellspacing="0" cellpadding="0">	
									  	<tr><td id="myPeople" class="TopHover" onclick="changePeopleType(0)" onmouseover="enterItem(this)" onmouseout="outItem(this)"><span class="TypeFont">我发布</span></td></tr>			
										<tr><td id="myTeamPeople" class="MidHover"  onclick="changePeopleType(1)" onmouseover="enterItem(this)" onmouseout="outItem(this)"><span class="TypeFont">我喜欢</span></td></tr>
										<tr><td id="allPeople" class="BottomHover"  onclick="changePeopleType(2)" onmouseover="enterItem(this)" onmouseout="outItem(this)"><span class="TypeFont">所有的</span></td></tr>
									</table>
								</div>
							</div>	
						</td>
						
						<td><button type="button" id="publishButton" onclick="publishTeam()"></button></td>
					</tr>
				</table>	
  			</form>
  		</div>
  		<!-- end help navigation -->
  		
  		<div style="clear:both"> </div>
  		<br>
  		
  		<div style="background-color:white">
  		<br>
  		<div id="contentDiv">
  			<%
  			for (int i=0; i<allTeam.getAllTeams().size(); i++)
  			{%>
				<div>
  				<!-- 日期 -->
  				<%if (i==0 || allTeam.getAllTeams().get(i-1).getMonth()!=allTeam.getAllTeams().get(i).getMonth() || allTeam.getAllTeams().get(i-1).getDay()!=allTeam.getAllTeams().get(i).getDay())
  				{%>
  				<div  class="DataDiv">
  					<div class="DataDay">
  						<%=allTeam.getAllTeams().get(i).getDay()%>
  					</div>
  					<div class="DataMonth">
  						<%=allTeam.getAllTeams().get(i).getMonth()+"月"%>
  					</div>
  				</div>
  				<%}%>
  				
  				<!-- 头像 -->
  				<div style="clear:both"> </div>
  				<div class="headDiv" style="float:left; position:relative; left:-50; margin:-30; top:30;">
  					<img src=<%=allTeam.getAllTeams().get(i).getPublishUser().getHeader_add() %>>
  				</div>
  	
  				<!-- 内容 -->
  				<div>
					<table class="TeamContent" >
  						<tr>
  							<td><div class="ContentPublishUser"><%=allTeam.getAllTeams().get(i).getPublishUser().getAccount()%></div></td>
  							<td style="width:587;">
  								<!-- 标题 -->
  								<table>
  									<tr>
  										<%
  										if (allTeam.getAllTeams().get(i).getType()==0)
  										{%>
  											<td style="width:140; text-align:left"><span class="publishFont">发布于</span><span class="createType">创意</span></td>
  										<%}
  										else
  										{%>
  											<td style="width:140; text-align:left"><span class="publishFont">发布于</span><span class="enlistType">招募</span></td>
  										<%}%>
  										
  										<td><div class="TeamContentTitle"><%=allTeam.getAllTeams().get(i).getTitle()%></div></td>
  									</tr>
  								</table>	
  							</td>
  							<!-- end 标题 -->
  							<%if (allTeam.getAllTeams().get(i).getType()==1) 
  							{
  								String waitDiv="wait"+allTeam.getAllTeams().get(i).getId()+session.getAttribute("account");
  								if (allTeam.getAllTeams().get(i).getPublisher_account().equals(session.getAttribute("account")))
  								{%>
  									<td><img src="TacTeam/Image/iamin.png" name="no" style="float:right;"></td>
  							  <%}
  								else if (allTeam.getAllTeams().get(i).getIsJoin())
  								{			
  								%>
  									<td><img src="TacTeam/Image/iamin.png" name="yes" style="float:right;" onclick="changeWanntIn(this,<%=allTeam.getAllTeams().get(i).getId()%>)"></td>
  								<%}
  								else
  								{%>
  									<td><img src="TacTeam/Image/iwantin.png" name="no" style="float:right;" onclick="changeWanntIn(this,<%=allTeam.getAllTeams().get(i).getId()%>)"></td>
  							  <%}%>
  						  <%}
  							else
  							{%>
  							  	<td  style="width:63"></td>
  						  <%}%>
						<tr>
							<td></td>
							<td>
								<div class="TeamContentContent">
  									<%=allTeam.getAllTeams().get(i).getContent()%>
  								</div>
							</td>
  						</tr>
						<tr>
							<td></td>
							<td>
								<%for (int j=0; j<allTeam.getAllTeams().get(i).getJoinUsers().size(); j++)
								{
									String joinUserId="join"+allTeam.getAllTeams().get(i).getId()+allTeam.getAllTeams().get(i).getJoinUsers().get(j).getAccount();
									if (j>10) break;
								%>
									<div style="width:45; float:left">
										<div class="headDiv">
											<img src=<%=allTeam.getAllTeams().get(i).getJoinUsers().get(j).getHeader_add()%> name=<%=allTeam.getAllTeams().get(i).getJoinUsers().get(j).getAccount()%> onclick="showInfor('<%=joinUserId%>')">
										</div>
										
										<!-- 组员用户信息 -->
										<%
										if (allTeam.getAllTeams().get(i).getIsJoin() || allTeam.getAllTeams().get(i).getPublisher_account().equals(session.getAttribute("account")))
										{
										%>
										<div id="<%=joinUserId%>" class="JoinUserInfo">
											<table style="position:relative; marin-top:20">
												<tr>
													<td style="width:80">
														<%=allTeam.getAllTeams().get(i).getJoinUsers().get(j).getAccount()%>
													</td>
													<td></td>
													<td style="width:60">
														<div class="headDiv" style="float:left">
															<img src=<%=allTeam.getAllTeams().get(i).getJoinUsers().get(j).getHeader_add()%>>
														</div> 
													</td>
												</tr>
												<tr>
													<td>Tel:</td>
													<td><%=allTeam.getAllTeams().get(i).getJoinUsers().get(j).getPhone()%></td>
												</tr>
												<tr>
													<td>@:</td>
													<td><%=allTeam.getAllTeams().get(i).getJoinUsers().get(j).getEmail()%></td>
												</tr>
											</table>
										</div>
										<%}%>
										<!--end 组员用户信息 -->
									</div>
								<%}%>
							</td>
							<td style="float:right; width:100;">
								<%if (allTeam.getAllTeams().get(i).getIsInterested())
								{%>
									<img src="TacTeam/Image/interested.png"  style="margin-top:12px;"name="yes" onclick="changeInterested(this,<%=allTeam.getAllTeams().get(i).getId()%>)">
								<%}
								 else
								 {%>
								 	<img src="TacTeam/Image/uninterested.png" name="no" onclick="changeInterested(this,<%=allTeam.getAllTeams().get(i).getId()%>)">
								<%}%>
								<span id="interestedCount<%=allTeam.getAllTeams().get(i).getId()%>" class="InterestedCount">
									<%=allTeam.getAllTeams().get(i).getInterestedCount()%>
								</span>
							<td>
						</tr>	
  					</table>
  					
  					<!-- 加入信息 -->
  					<%if (allTeam.getAllTeams().get(i).getType()==1)
  					{%>
  					<div style="margin-left:172px">
  						<table>
  							<tr>
  								<td>
  									<div class="headDiv">
  										<img src=<%=allTeam.getAllTeams().get(i).getJoin_head()%> >
  									</div>
  								</td>
  								<td>
  									<span class="joinUser"><%=allTeam.getAllTeams().get(i).getJoin_user()%></span>
  									<span class="joinPro"><%=allTeam.getAllTeams().get(i).getTitle()%></span>
  								</td>
  							</tr>
  						</table>
  					</div>
  					<%}
  					else
  					{%>
  						<br>
  					<%}%>
  				</div>
  				<!-- end 内容 -->  			
  				</div>
  		   <%}%> 
  		</div>
  		<br>
  		<!--页号-->
		<div class="pageNum">
			<a href="javascript:choosePage(1);" class="NoticesItem">首页</a> 
			<a href="javascript:lastPage();" class="NoticesItem">上一页</a>
			<%
				for (int i = 1; i <= allTeam.getAllPage(); i++) 
				{
					if (i == allTeam.getPageIndex()) 
					{%>
						<a style="color:red"><%=i%></a>
				  <%} 
					else 
					{%>
						<a href="javascript:choosePage(<%=i%>);" class="NoticesItem"><%=i%></a>
				  <%}%>
				<%}%>
				 
			<a href="javascript:nextPage(<%=allTeam.getAllPage()%>);" class="NoticesItem">下一页</a> 
			<a href="javascript:choosePage(<%=allTeam.getAllPage()%>);" class="NoticesItem">尾页</a>
		</div>
		<!-- 页号 -->
		<br>
  	</div>
  	</div>
  	<%@include file="/Navigation/Footer.jsp" %>
  </body>
</html>
  					