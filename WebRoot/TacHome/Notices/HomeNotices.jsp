 <%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<script type="text/javascript">
	<%@include file="NoticesIndex.js" %>
</script>

<style type="text/css">
	<%@include file="/TacNotices/NoticesItem.css" %>
</style>


  <jsp:useBean  id="allNotices" class="DataSource.Notices.AllNotices" scope="request">
 </jsp:useBean>

 
<div style="clear:both"> </div>


<div style="width:1200; margin-left:auto; margin-right:auto">

	<div>
		<img src="TacHome/Image/NoticesHeader.png">
		<br>
	</div>

 	<div style="width:800; height:200;  float:left; ">
 		<div id="notice" style="height:120;  margin-left:50; margin-right:50; margin-top:30; overflow:auto; word-break:break-all;">
			<!--此处为内容  -->
 		</div>
 	</div>
 	
 	 <div style="width:400; height:200; float:left; overflow:hidden; text-overflow:ellipsis; -o-text-overflow:ellipsis;white-space:nowrap" >
 	 	<div>
 	 		<a class="NoticesItem" href="Notices" style="float:right;">查看全部</a>
 	 	</div>
 	 	
 	 	<%for (int i=0; i<allNotices.getAllNotices().size(); i++)
 	 	 {%>
 	 	 	<br>
 	 		<br>
 	 		<%if (i==0) 
 	 		  {%>
 	 		      	<img id="notices<%=allNotices.getAllNotices().get(i).getNotice_id()%>"name="<%=allNotices.getAllNotices().get(i).getNotice_id()%>" src="TacHome/Image/NextPage.png" onclick="showNotice(this)" onload="showNotice(this)">
 	 		<%}
 	 		  else
 	 		  {%>
 	 	  			<img id="notices<%=allNotices.getAllNotices().get(i).getNotice_id()%>"name="<%=allNotices.getAllNotices().get(i).getNotice_id()%>" src="TacHome/Image/NextPage.png" onclick="showNotice(this)">
 	 	  	<%}%>
 	 		<a class="NoticesItem" href="Notices/NoticesPage?indexNotices=<%=allNotices.getAllNotices().get(i).getNotice_id()%>"><%=allNotices.getAllNotices().get(i).getNotice_title()%></a>  
		<%}%>
 	</div>
</div>

<div style="clear:both"> </div>

