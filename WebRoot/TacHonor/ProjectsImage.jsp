
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<script type="text/javascript">
	<%@include file="ProjectsImage.js" %>
</script>

  <jsp:useBean class="DataSource.Projects.AllProjects" id="allProjects" scope="request">
 </jsp:useBean>

<div style="clear: both;"></div>


<div id="ProjectImageId">
	 
	 	 <%for (int i=0; i<allProjects.getProject().size(); i++)
	  	 {%>
			<div style="width:600; height:400; float:left;	text-align:center;">
				<img id="<%=i%>" name="<%=allProjects.getProject().get(i).getImage().size() %>"src="<%=allProjects.getProject().get(i).getImage().get(0) %>"onclick="linkToImg(this)" onmousemove="changeImg(this)" onmouseout="leaveImg(this)" style="margin-top:50">
				<div>
					<%=allProjects.getProject().get(i).getTitle() %>
				</div>
				<div>
					<%=allProjects.getProject().get(i).getDescription() %>
				</div>	
			</div>
		<%}%> 
</div>
<div style="clear: both;"></div>