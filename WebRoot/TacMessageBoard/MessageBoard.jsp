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
<script type="text/javascript" src="jquery-1.9.1.js"></script>
<script type="text/javascript" src="TacMessageBoard/MessageBoard.js"></script>

</head>

<body>
	<%@include file="/Navigation/Navigation.jsp"%>
	<div id="allcontent">


		<div id="right"></div>
		<div id="left">
			<div class="block">
				<div id="addNoteBlock">
				</div>
			</div>
		</div>

		<div id="collection" hidden="hidden">
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx1.png" alt="Shawn" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx2.png" alt="路捷" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">我要吃好吃的</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx3.png" alt="Shawn" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx1.png" alt="Shawn" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx2.png" alt="路捷" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">我要吃好吃的</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx3.png" alt="Shawn" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx1.png" alt="Shawn" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx2.png" alt="路捷" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">我要吃好吃的</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx3.png" alt="Shawn" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx1.png" alt="Shawn" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx2.png" alt="路捷" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">我要吃好吃的</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
			<div class="block">
				<div class="content">
					<div class="notetitle">
						<img src="image/tx3.png" alt="Shawn" class="headphoto" />
						<p class="ownername">Shawn</p>
					</div>
					<p class="notecontent">今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。今天好像快下雨的样子，真不开心，不开心不开心不开心不开心，找不到对象找不到对象找不到对象找不到对象。</p>
					<p class="publishtime">2013.5.18</p>
				</div>
			</div>
		</div>
	</div>
	<%@include file="/Navigation/Footer.jsp"%>
</body>
</html>
