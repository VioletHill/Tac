<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">

<title>Home Page</title>
<meta charset=utf-8 />
<link type="text/css" rel="stylesheet"
	href="TacMessageBoard/MessageBoard.css" />

</head>

<body>
<%@include file="/Navigation/Navigation.jsp"%>
	<div id="allcontent">
		

		<div id="right">
			<div class="block">
				<div class="notetitle">
					<img src="image/tx1.png" alt="Shawn" class="headphoto" />
					<p class="ownername">Shawn</p>
				</div>
				<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
				<p class="publishtime">2013.5.18</p>
			</div>
			<div class="block">
				<div class="notetitle">
					<img src="image/tx2.png" alt="路捷" class="headphoto" />
					<p class="ownername">Shawn</p>
				</div>
				<p class="notecontent">我要吃好吃的</p>
				<p class="publishtime">2013.5.18</p>
			</div>
		</div>
		<div id="left">
			<div id="addNoteBlock">
				<img alt="我要留言" src="image/commentPage_addNote.png" id="addNote" />
			</div>
			<div class="block">
				<div class="notetitle">
					<img src="image/tx3.png" alt="Shawn" class="headphoto" />
					<p class="ownername">Shawn</p>
				</div>
				<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
				<p class="publishtime">2013.5.18</p>
			</div>
			<div class="block">
				<div class="notetitle">
					<img src="image/tx2.png" alt="Shawn" class="headphoto" />
					<p class="ownername">Shawn</p>
				</div>
				<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
				<p class="publishtime">2013.5.18</p>
			</div>
		</div>

		<%@include file="/Navigation/Footer.jsp" %> 
	</div>
</body>
</html>
