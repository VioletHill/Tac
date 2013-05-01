 <%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<script type="text/javascript">
	<%@include file="NoticesIndex.js" %>
</script>

<style type="text/css">
	<%@include file="/TacNotices/NoticesItem.css" %>
</style>


  <jsp:useBean  id="allNotices" class="DataSource.Notices.AllNotices" scope="request">
 </jsp:useBean>
 
  <jsp:useBean  id="firstNotice" class="DataSource.Notices.Notice" scope="request">
 </jsp:useBean>
 
<div style="clear:both"> </div>

<div style="width:1200; margin-left:auto; margin-right:auto">
 	<div style="width:800; height:200; background-color:green;  float:left; overflow:hidden">
 		<div id="notice" style="height:120; overflow:hidden; margin-left:50; margin-right:50; margin-top:30">
 			<%if (!allNotices.getAllNotices().isEmpty())
 			{%>
 				<%=firstNotice.getNotice_html() %>
 		  <%}%>
 		</div>
 	</div>
 	
 	 <div style="width:400; height:200; float:left">
 	 	<div>
 	 		<a class="NoticesItem" href="http://localhost:8080/Tac/Notices" style="float:right;">查看全部</a>
 	 	</div>
 	 	
 	 	<%for (int i=0; i<allNotices.getAllNotices().size(); i++)
 	 	 {%>
 	 	  	<img id="<%=allNotices.getAllNotices().get(i).getNotice_id()%>" src="/TacHome/Image/NextPage.png" onclick="showNotice(this)">
 	 		<a class="NoticesItem" href="http://localhost:8080/Tac/Notices/NoticesPage?indexNotices=<%=allNotices.getAllNotices().get(i).getNotice_id()%>"><%=allNotices.getAllNotices().get(i).getNotice_title()%></a>  
 	 		<br>
		<%}%>
 	</div>
</div>

<div style="clear:both"> </div>