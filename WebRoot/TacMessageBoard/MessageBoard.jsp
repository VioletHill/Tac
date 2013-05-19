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
	href="/Tac/TacMessageBoard/MessageBoard.css" />

</head>

<body>
	<div id="allcontent">
		<header>
			<img src="/Tac/image/commentPage_header.png" alt="header"
				id="headerimg" />
		</header>

		<div id="right">
			<div class="block">
				<div class="notetitle">
					<img src="/Tac/image/tx1.png" alt="大畅" class="headphoto" />
					<p class="ownername">大畅</p>
				</div>
				<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
				<p class="publishtime">2013.5.18</p>
			</div>
			<div class="block">
				<div class="notetitle">
					<img src="/Tac/image/tx2.png" alt="路捷" class="headphoto" />
					<p class="ownername">大畅</p>
				</div>
				<p class="notecontent">我要吃好吃的</p>
				<p class="publishtime">2013.5.18</p>
			</div>
		</div>
		<div id="left">
			<div class="block">
				<div class="notetitle">
					<img src="/Tac/image/tx3.png" alt="大畅" class="headphoto" />
					<p class="ownername">大畅</p>
				</div>
				<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
				<p class="publishtime">2013.5.18</p>
			</div>
			<div class="block">
				<div class="notetitle">
					<img src="/Tac/image/tx2.png" alt="大畅" class="headphoto" />
					<p class="ownername">大畅</p>
				</div>
				<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
				<p class="publishtime">2013.5.18</p>
			</div>
		</div>

		<footer>
			<p>copyright</p>
			<button>More</button>
		</footer>
	</div>
</body>
</html>
