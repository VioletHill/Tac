 <%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<script type="text/javascript">
	<%@include file="NoticesIndex.js" %>
	<%@include file="/TacNotices/NoticesLink.js" %>
</script>

<style type="text/css">
	<%@include file="/TacNotices/NoticesItem.css" %>
</style>


  <jsp:useBean class="DataSource.Notices.AllNotices" id="allNotices" scope="request">
 </jsp:useBean>
<div style="clear:both"> </div>
 <div style="width:1200; margin-left:auto; margin-right:auto">
 	<div style="width:800; height:200; background-color:green;  float:left; overflow:hidden">
 		<div id="notice" style="height:120; overflow:hidden; margin-left:50; margin-right:50; margin-top:30">
 			<%if (!allNotices.getAllNotices().isEmpty())
 			{%>
 			 	<%=allNotices.getAllNotices().get(0).getContent() %>
 		   <%}%>
 		</div>
 	
 	</div>
 	
 	 <div style="width:400; height:200; float:left">
 	 	<div>
 	 		<a href="http://localhost:8080/Tac/Notices" style="float:right; text-decoration: underline; cursor:pointer; color:black">查看全部</a>
 	 	</div>
 	 	<br>
 	 
 	 	<%
 	 	for (int i=0; i<allNotices.getAllNotices().size(); i++)
 	 	{%>
 	 		 <img id="<%=i%>" src="/TacHome/Image/NextPage.png" onclick="showNotice(this)">
 	 		 <a class="NoticesItem" href="http://localhost:8080/Tac/Notices/NoticesPage?indexNotices=<%=i%>"><%=allNotices.getAllNotices().get(i).getTitle()%></a>  
 	 		 <br>
		<%} %>
 	</div>
 </div>
<div style="clear:both"> </div>