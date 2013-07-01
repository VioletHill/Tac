 <%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<script src="TacHome/Notices/NoticesIndex.js"></script>
<link rel="stylesheet" type="text/css" href="TacNotices/NoticesItem.css">
<link rel="stylesheet" type="text/css" href="TacHome/Notices/HomeNotices.css">


  <jsp:useBean  id="allNotices" class="DataSource.Notices.AllNotices" scope="request">
 </jsp:useBean>

 
<div style="clear:both"> </div>


<div style="width:1200; margin-left:auto; margin-right:auto; background-color:white" >

	<div>
		<img src="TacHome/Image/NoticesHeader.png" style="margin-left:50; margin-top:20;">
		<br>
	</div>

 	<div style="width:800; height:400;  float:left;  background-color:white;">
 	
 		<br>
 		 <div>
 	 		<a class="HomeNoticesShow" href="javascript:selectNotice();" style="margin-left:50;">查看本通知</a>
 	 	</div>
 	 	
 		<div  id="notice" style="height:305;  margin-right:50; margin-top:30; word-break:break-all; overflow:auto; margin-left:50">
			<!--此处为内容  -->
 		</div>
		
		<br>
 	 
 	</div>
 	
 	 <div  style="width:400; height:400; float:left; background-color:white" >
 	 	<br>
 	 	<div>
 	 		<a class="HomeNoticesAll" href="Notices" style="float:right; position:relative; left:-60">查看全部</a>
 	 	</div>
 	 	
 	 	<%for (int i=0; i<allNotices.getAllNotices().size(); i++)
 	 	 {%>
 	 	 	<br>
 	 	 	<br>
 	 	 	<br>
 	 		<%if (i==0) 
 	 		  {%>
 	 		      	<img id="notices<%=allNotices.getAllNotices().get(i).getNotice_id()%>" name="<%=allNotices.getAllNotices().get(i).getNotice_id()%>" src="TacHome/Image/NoticesTitle.png" onclick="showNotice(this)" onload="showNotice(this)">
 	 		<%}
 	 		  else
 	 		  {%>
 	 	  			<img id="notices<%=allNotices.getAllNotices().get(i).getNotice_id()%>" name="<%=allNotices.getAllNotices().get(i).getNotice_id()%>" src="TacHome/Image/NoticesTitle.png" onclick="showNotice(this)">
 	 	  	<%}%>
 	 	  	<div class="NoticesItemDiv" style="position:relative; left:20; top:-15; width:380">
 	 			<a class="HomeNoticesTitle" href="Notices/NoticesPage?indexNotices=<%=allNotices.getAllNotices().get(i).getNotice_id()%>" title="<%=allNotices.getAllNotices().get(i).getNotice_title()%>"><%=allNotices.getAllNotices().get(i).getNotice_title()%></a>
 	 		</div>
		<%}%>
	</div>
</div>

<div style="clear:both"> </div>

