<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<script type="text/javascript">
	<%@include file="/TacHonor/Honor.js" %>
	<%@include file="HomeHonor.js" %>
</script>

<jsp:useBean class="DataSource.Honor.AllHonor" id="allHonor" scope="request">
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
		<br>
	</div>

	<div style="width:1200; height:300; background-color:yellow;">
		<a class="NoticesItem" href="Honor" style="float:right;">查看全部</a>
		<br>
		<div style="overflow:hidden; white-space:nowrap; width:1000; background-color:green; left:100; position:relative;">
			<div class="showTimeImage" style="position:relative">
			  <%for (int i = 0; i < allHonor.getList().size(); i++) 
				{%>
					<img id="<%=allHonor.getList().get(i).getHonor_id()%>" name="<%=allHonor.getList().get(i).getPicture().length%>" src="<%=allHonor.getList().get(i).getPicture()[0]%>" onclick="linkToImg(this)" onmousemove="changeImg(this)" onmouseout="leaveImg(this)" style="position:relative; margin-left:100;">
			  <%}%>
			</div>
		</div>
	</div>
	<img id=<%=allHonor.getList().size()%>	src="TacHome/Image/LastPage.png" onclick="lastShowTime(this)"> 
	<img id=<%=allHonor.getList().size()%>	src="TacHome/Image/NextPage.png" onclick="nextShowTime(this)">
</div>

<div style="clear:both"> </div>

