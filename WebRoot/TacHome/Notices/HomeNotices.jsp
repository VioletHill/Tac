 <%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<script type="text/javascript">
	<%@include file="NoticesIndex.js" %>
</script>



  <jsp:useBean class="DataSource.Notices.AllNotices" id="allNotices" scope="request">
 </jsp:useBean>

 <div style="width:1200; height:100; margin-left:auto; margin-right:auto">
 	<div style="width:800; height:50; background-color:green; float:left; overflow:hidden">
 		<div id="notice" style="margin-left:50; margin-right:50;">
 			
 		</div>
 	</div>
 	
 	 <div style="width:400; background-color:red; float:left">
 	 	 <img src="/TacHome/Image/NextPage.png" onclick="showNotice()">
 	 	 <a href=""> <%=allNotices.getAllNotices().get(0).getTitle()%></a>

 	</div>
 </div>