<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>


<script src="TacHome/Honor/HomeHonor.js"></script>

<link rel="stylesheet" type="text/css" href="TacNotices/NoticesItem.css">
<link rel="stylesheet" type="text/css" href="TacHome/Honor/HomeHonor.css">

<jsp:useBean class="DataSource.Honor.AllHonor" id="allHonor" scope="request">
</jsp:useBean>

<div style="clear:both"> </div>
<br>
<br>
<div style="width:1163; margin-left:auto; margin-right:auto; background-color:white">
	
	<div>
		<img src="TacHome/Image/ShowtimeHeader.png" >
	</div>	

	<div style="width:1163; height:300;">
		<br>
		<a class="NoticesItem" href="Honor" style="float:right;">查看全部</a>
		<br>
		<div class="ImageScroll" >
   			<div class="ImageViewContainer">
   				<%for (int i = 0; i < allHonor.getList().size(); i++) 
				{%>
					<img class="ImageView"  name="<%=i%>" src="<%=allHonor.getList().get(i).getPicture()[0] %>" onmousemove="changeImg(this)" onmouseout="leaveImg(this)" onclick="linkToPorject(this)">
					<%
						for (int j=0; j<allHonor.getList().get(i).getPicture().length; j++)
						{%>
							<a href="<%=allHonor.getList().get(i).getPicture()[j]%>" rel="changeImg[<%=i%>]"></a>
					  <%}%>	
			  <%}%>
   			</div>
   		</div>
   		<img class="LastView" src="TacHome/Image/LastPage.png" onclick="preView(<%=allHonor.getList().size()%>)" onmousedown="this.style.opacity=0.2;" onmouseup="this.style.opacity=1;"> 
		<img class="NextView"src="TacHome/Image/NextPage.png" onclick="nextView(<%=allHonor.getList().size()%>)" onmousedown="this.style.opacity=0.2;" onmouseup="this.style.opacity=1;">
	</div>
</div>

<div style="clear:both"> </div>

