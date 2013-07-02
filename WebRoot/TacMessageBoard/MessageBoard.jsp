<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DataSource.Message.Message"%>
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
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
<!-- <meta charset=utf-8 /> -->
<link type="text/css" rel="stylesheet"
	href="TacMessageBoard/MessageBoard.css" />
<script type="text/javascript" src="jquery-1.9.1.js"></script>
<script type="text/javascript" src="TacMessageBoard/MessageBoard.js" charset="utf-8"></script>
<script type="text/javascript" src="TacMessageBoard/loadmore.js"></script>

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
		<jsp:include page="/TacMessageBoard/Block.jsp"></jsp:include>
		</div>
		<div id="null"></div>
	</div>
	<button id="loadmore">more</button>
	<%@include file="/Navigation/Footer.jsp"%>
</body>
</html>
