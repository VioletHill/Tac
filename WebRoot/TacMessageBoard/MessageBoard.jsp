<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DataSource.Message.Message"%>
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
					<div id="publishBlock">
						<form action="Publish" method="post">
							<textarea id="publishContent" name="content"></textarea>
							<p id="publishCount">0</p>
							<input type="submit" id="submitButton" />
						</form>
					</div>
				</div>
			</div>
		</div>

		<div id="collection" hidden="hidden">
			<%
				List<Message> list = (List<Message>) request.getAttribute("message");
				Iterator<Message> it = list.iterator();
				while (it.hasNext()) {
					Message message = it.next();
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateString = format.format(message.getTime());
					%>
					<div class="block">
						<div class="content">
							<div class="notetitle">
								<img src="image/tx3.png" alt="Shawn" class="headphoto" />
								<p class="ownername"><%=message.getUser_account() %></p>
							</div>
							<p class="notecontent"><%= message.getContent() %></p>
							<p class="publishtime"><%= dateString %></p>
						</div>
					</div>
					<%
				}
				request.removeAttribute("message");
			%>
		</div>
	</div>
	<%@include file="/Navigation/Footer.jsp"%>
</body>
</html>
