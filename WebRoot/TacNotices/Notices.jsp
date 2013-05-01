<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	 <style type="text/css">
	 	 <%@include file="/TacNotices/NoticesItem.css" %>  
	</style>
	
	<script src="//ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	
    <base href="<%=basePath%>">
    
    <title>Tac新鲜事</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function showTime()
   	 	{ 
     		var now=new Date; 
     		var day=null;
     		if (now.getDay()==1) day="一";
     		else if (now.getDay()==2) day="二";
     		else if (now.getDay()==3) day="三";
     		else if (now.getDay()==4) day="四";
     		else if (now.getDay()==5) day="五";
     		else if (now.getDay==6) day="六";
     		else if (now.getDay==7) day="日";
     		
     	  	document.getElementById("time").innerHTML=now.getFullYear() 
      		  +"年"+(now.getMonth()+1) 
     		  +"月"+now.getDate() 
       		  +"日"
       		  +"  "+"星期"+day
       		  +"  "+now.getHours()
       		  +":"+now.getMinutes()+":"+now.getSeconds(); 
   	 		setTimeout("showTime()","1000"); 
   		} 
   		
   		function focusSearch(element)
   		{
   			element.style.opacity=1;
   		}
   		
   		function blurSearch(element)
   		{
   			element.style.opacity=0.2;
   			if (element.value=="") element.value="搜索信息";
   		}
   		var today=null;
   		var week=null;
   		var month=null;
   		var all=null;
   		var isAnimate=false;
   	
   	   	function enterItem(ele)
   	   	{
   	   		ele.style.backgroundColor='blue';
   	   	
   	   	}
   	   	function outItem(ele)
   	   	{
   	   	   	ele.style.backgroundColor='white';  	
   	   	   	if (isNeedClear()) clearItem();
   	   	}
   	   	
   	   	function isNeedClear()
   	   	{
   	   		var obj=document.getElementById("noticesTime");
   	   		oRect=obj.getBoundingClientRect(); 
   	   		
   	   		if (window.event.clientX<=oRect.left || window.event.clientX>=oRect.right || window.event.clientY<=oRect.top || window.event.clientY>=oRect.top+30*5) return true;
   	   		return false;
   	   	}

   	   	
   	   	function clearItem()
   	   	{
   	     	document.getElementById("todayTime").style.display="none";
   			document.getElementById("weekTime").style.display="none";
   			document.getElementById("monthTime").style.display="none";
   			document.getElementById("all").style.display="none";
   			isAnimate=false;
   			
   	  	}
   	   	
   		function showItem(obj)
   		{
   			if (isAnimate) return ;
   			isAnimate=true;
   			var oRect=obj.getBoundingClientRect(); 

   			today=document.getElementById("todayTime");
   			week=document.getElementById("weekTime");
   			month=document.getElementById("monthTime");
   			all=document.getElementById("all");
   			
   			today.style.position=week.style.position=month.style.position=all.style.position="absolute";
   			today.style.left=week.style.left=month.style.left=all.style.left=oRect.left;
   			today.style.top=week.style.top=month.style.top=all.style.top=oRect.top;
   			today.style.display=week.style.display=month.style.display=all.style.display="inline";
   			todayTop=oRect.top+30;
   			$("#todayTime").animate({top:todayTop});
   			$("#weekTime").animate({top:todayTop+30});
   			$("#monthTime").animate({top:todayTop+60});
   			$("#all").animate({top:todayTop+90});
   			
   		}
	</script>
  </head>
  
   <jsp:useBean id="allNotices" class="DataSource.Notices.AllNotices" scope="request">
  </jsp:useBean>
  <body>
     <div  style="top:0; width:1200;  margin-right: auto; margin-left: auto;"  >
	 	<%@include file="/Navigation/Navigation.jsp" %>
	 	<div>
	 		<br>
	 		
	 		<form action="" method="post">
	 			
	 			<table style="position:float; float:right">
	 				<tr>
	 					<td><input type="text" value="搜索信息" onfocus="focusSearch(this)" onblur="blurSearch(this)" style="width:400; height:30; font-size:20; text-align:center; opacity:0.2; position:float; float:right"></td>
	 					<td><input type="button" value="今天" id="todayTime"  onmouseover="enterItem(this)" onmouseout="outItem(this)" style="width:100; height:30; background-color:white; font-size:15; color:black; display:none"></td>   
	 					<td><input type="button" value="本周" id="weekTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" style="width:100; height:30; background-color:white; font-size:15; color:black; display:none"></td>
	 					<td><input type="button" value="本月" id="monthTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" style="width:100; height:30; background-color:white; font-size:15; color:black; display:none"></td>
	 					<td><input type="button" value="全部" id="all"  onmouseover="enterItem(this)" onmouseout="outItem(this)" style="width:100; height:30; background-color:white; font-size:15; color:black; display:none"></td>
	 					<td><input type="button" value="时间段" id="noticesTime" onmouseout="outItem(this)" onmouseover="enterItem(this); showItem(this);"  style="width:100; height:30; background-color:white; font-size:15; color:black;"></td>
	 					<td><button style="background-color:blue; height:30; width:100; font-size:15; color:white">搜索</button></td>
	 				</tr>		
	 			</table>
	 			
	 		</form>
	 		
	 		<br>
	 		<div style="top:30; width:1150; background-color:red; margin-left:auto; margin-right:auto">
	 			<div>
	 				<img src="TacNotices/Image/NoticesHeader.png" onload="showTime()">
	 				<span id="time"></span>
	 			</div>
	 		 	<br>
	 			<%if  (!allNotices.getAllNotices().isEmpty())
	 			{%>
	 			 	<table >
	 				 	<%for (int i=0; i<allNotices.getAllNotices().size(); i++)
	 					{%>
 	 					 <tr style="height:30">
	 						<td style="text-align:left"> 
	 							<a href="http://localhost:8080/Tac/Notices/NoticesPage?indexNotices=<%=i%>" class="NoticesItem" ><%=allNotices.getAllNotices().get(i).getTitle() %>"</a>
	 							<span  style="color:red;"><%=allNotices.getAllNotices().get(i).getData()%></span>
	 						</td>
	 					</tr> 
 	 				   <%}%> 
	 		 		</table>
	 			<%}%>	
	 		</div>
	 	</div>
	  	<%@include file="/Navigation/Footer.jsp" %>
	 </div>	  
  </body>
</html>
	 			