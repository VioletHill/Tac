
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<script type="text/javascript">
	<%@include file="ProjectsImage.js" %>
</script>

  <jsp:useBean class="DataSource.Projects.AllProjects" id="allProjects" scope="request">
 </jsp:useBean>

<div style="clear: both;"></div>


<div id="ProjectImageId">
	<script type="text/javascript">
		//copy name
		<%for (int i=0; i<allProjects.getProject().size(); i++)
	 	 {%>
	  	 	 imgName[<%=i%>]=new Array();
	  	 	<%for (int j=0; j<allProjects.getProject().get(i).getImage().size(); j++)
	  	 	 {%>
	  	 		imgName[<%=i%>][<%=j%>]="<%=allProjects.getProject().get(i).getImage().get(j)%>";
	  	   <%}%>
	   <%}%>
	 </script>
	 
	 
	 	 <%for (int i=0; i<allProjects.getProject().size(); i++)
	  	 {%>
			<div style="width:600; height:400; float:left;	text-align:center;">
				<img id="<%=i%>" src="<%=allProjects.getProject().get(i).getImage().get(0) %>"onclick="linkToImg(this)" onmousemove="changeImg(this)" onmouseout="leaveImg(this)" style="margin-top:50">
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