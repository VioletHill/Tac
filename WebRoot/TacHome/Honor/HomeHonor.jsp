<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<script type="text/javascript">
	<%@include file="/TacHonor/ProjectsImage.js" %>
	<%@include file="HomeHonor.js" %>
</script>

<jsp:useBean class="DataSource.Projects.AllProjects" id="allProjects" scope="request">
</jsp:useBean>

<style type="text/css">
	<%@include file="/TacNotices/NoticesItem.css" %>
</style>

<div style="clear:both"> </div>
<br>
<br>
<div style="width:1200; margin-left:auto; margin-right:auto;">	
	<div>
		<img src="TacHome/Image/ShowtimeHeader.png" >
		
		
	</div>

	<div style="width:1200; height:300; background-color:yellow;">
		<a class="NoticesItem" href="http://localhost:8080/Tac/Honor" style="float:right;">查看全部</a>
		<br>
		<div
			style="overflow:hidden; white-space:nowrap; width:1000; background-color:green; left:100; position:relative;">
			<div class="showTimeImage" style="position:relative">


				<%for (int i = 0; i < allProjects.getProject().size(); i++) 
				{%>
					<img id="<%=i%>" name="<%=allProjects.getProject().get(i).getImage().size()%>" src="<%=allProjects.getProject().get(i).getImage().get(0)%>" onclick="linkToImg(this)" onmousemove="changeImg(this)" onmouseout="leaveImg(this)" style="position:relative; margin-left:100;">
			  <%}%>
			</div>
		</div>
	</div>
	<img id=<%=allProjects.getProject().size()%>	src="TacHome/Image/LastPage.png" onclick="lastShowTime(this)"> 
	<img id=<%=allProjects.getProject().size()%>	src="TacHome/Image/LastPage.png" onclick="nextShowTime(this)">
</div>

<div style="clear:both"> </div>

