<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<jsp:useBean id="allNotices" class="DataSource.Notices.AllNotices" scope="request"></jsp:useBean>

<head>
	<base href="<%=basePath%>">

	<title>Tac新鲜事</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style>
		
		body {
		background-image: url("image/mainBG.png");
		padding: 0px;
		margin: 0px;
		}
	</style>

	<link rel="stylesheet" type="text/css" href="TacNotices/Notices.css">
	<link rel="stylesheet" type="text/css" href="TacNotices/NoticesItem.css">
	<script src="jquery-1.9.1.js"></script>
	<script type="text/javascript" src="TacNotices/Notices.js"></script>
</head>



<body onload="init()">

 	<%@include file="/Navigation/Navigation.jsp"%>
 	
	<div style="top:0; width:1163;  margin-right: auto; margin-left: auto;"> 	 
		<!-- 搜索栏 -->
		<div style="width:1163">
			<div>
				<form action="Notices" method="post" id="form">
					<input type="hidden" id="searchTime" name="searchTime" value="<%=allNotices.getNoticeTime()%>">
					<input type="hidden" id="pageIndex" name="pageIndex" value=<%=allNotices.getPageIndex()%>> 
					<input type="hidden" id="isSearch" name="isSearch" value="no">
					<table class="helpTable">
						<tr>
							<td><input type="text" name="search" id="search" value="<%=allNotices.getSearch()%>" onfocus="focusSearch(this)" onblur="blurSearch(this)"></td>
						
							<td>
								<div id="cataDiv">
									<input type="button"  value="<%=allNotices.getNoticeTime()%>" id="noticeTime"  onclick="changeItemState()" onmouseover="showItem();">
									<div id="catalog">
									 	<table cellspacing="0" cellpadding="0">	
									  		<tr><td id="todayTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" onclick="clickItem(this)">今天</td></tr>			
											<tr><td id="weekTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" onclick="clickItem(this)">本周</td></tr>
											<tr><td id="monthTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" onclick="clickItem(this)">本月</td></tr>
											<tr><td id="allTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" onclick="clickItem(this)">全部</td></tr>
										</table>
									</div>
								</div>	
							</td>
						
							<td><button type="submit" class="searchTime" onclick="setIsSearch()"></button></td>
						</tr>
					</table>
				</form>
			</div>
			
 			<div style="clear:both"> </div>
 			<br>
 			
 			<!-- 通知内容 -->
			<div class="content">
				 <div>
				 	<br>
					<img src="TacNotices/Image/Title.png" class="noticeLogo" onload="showTime()">
					<span id="time"></span>
				</div>

				<table style="position:relative; top:80;">
					<%
					for (int i = 0; i < allNotices.getAllNotices().size(); i++) 
					{%>
						<tr style="height:50; width:1100; height:72">
							<td class="noticesTitle">
								<a href="Notices/NoticesPage?indexNotices=<%=allNotices.getAllNotices().get(i).getNotice_id()%>" class="NoticesItem" title="<%=allNotices.getAllNotices().get(i).getNotice_title()%>" style="font-size:14"><%=allNotices.getAllNotices().get(i).getNotice_title()%></a>	
								<span style="color:red; font-size:14"><%=allNotices.getAllNotices().get(i).getData()%></span>	
							</td>
						</tr>
				  <%}%>
				</table>
			</div> 
			<!-- 通知内容 -->
			
			<!--页号-->
			<div class="pageNum">
				<input type="hidden" id="pageIndexText" value="<%=allNotices.getPageIndex()%>"> 
				<a href="javascript:choosePage(1);" class="NoticesItem">首页</a> 
				<a href="javascript:lastPage();" class="NoticesItem">上一页</a>
				<%
					for (int i = 1; i <= allNotices.getAllPage(); i++) 
					{
						if (i == allNotices.getPageIndex()) 
						{%>
							<a style="color:red"><%=i%></a>
					  <%} 
						else 
						{%>
							<a href="javascript:choosePage(<%=i%>);" class="NoticesItem"><%=i%></a>
					  <%}%>
				 <%}%>
				 
				<a href="javascript:nextPage(<%=allNotices.getAllPage()%>);" class="NoticesItem">下一页</a> 
				<a href="javascript:choosePage(<%=allNotices.getAllPage()%>);" class="NoticesItem">尾页</a>
			</div>
			<!-- 页号 -->
		</div>
		
		<%@include file="/Navigation/Footer.jsp"%>
	</div>
</body>
</html>
