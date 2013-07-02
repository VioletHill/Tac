<%@page import="java.text.SimpleDateFormat"%>
<%@page import="DataSource.Message.Message"%>
<%@page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	response.setCharacterEncoding("utf8");
%>
<%
	int id = 99999999;
	String idstr = request.getParameter("id");
	if (idstr != null) {
		id = Integer.parseInt(idstr);	
	}
	List<Message> list = (List<Message>) request
			.getAttribute("message");
	Iterator<Message> it = list.iterator();
	int i = 0;
	while (it.hasNext() && i < 50) {
		
		Message message = it.next();
		if (message.getId() >= id) {
			continue;
		}
		i++;
		SimpleDateFormat format = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm");
		String dateString = format.format(message.getTime());
%>
<div class="block">
	<div class="content">
		<div class="notetitle">
			<img src="image/tx3.png" alt="Shawn" class="headphoto" />
			<p class="ownername"><%=message.getUser_account()%></p>
		</div>
		<p class="notecontent"><%=message.getContent()%></p>
		<p class="publishtime"><%=dateString%></p>
		<p style="display:none;" class="id"><%=message.getId()%></p>
	</div>
</div>
<%
	}
%>