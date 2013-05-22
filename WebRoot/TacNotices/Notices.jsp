<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

	<jsp:useBean id="allNotices" class="DataSource.Notices.AllNotices"scope="request"></jsp:useBean>

<head>
	<style type="text/css" >
		<%@include file="NoticesItem.css" %>
	</style>

	<script src="jquery-1.9.1.js"></script>

	<base href="<%=basePath%>">

	<title>Tac新鲜事</title>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<style>
		
		body {
		background-image: url("image/mainBG.png");
		padding: 0px;
		margin: 0px;
		}
	</style>


	<script type="text/javascript">

		var search;
		function showTime()
   	 	{ 
     		var now=new Date; 
     		var day=null;
     	 	if (now.getDay()==1) day="一";
     		else if (now.getDay()==2) day="二";
     		else if (now.getDay()==3) day="三";
     		else if (now.getDay()==4) day="四";
     		else if (now.getDay()==5) day="五";
     		else if (now.getDay()==6) day="六";
     		else if (now.getDay()==0) day="日";
     		
     		var min = now.getMinutes();
     		if (min<10)
     		{
     			min = "0" + min;
     		}
     		
     		var hour = now.getHours();
     		if (hour < 10)
     		{
     			hour = "0" + hour;
     		}
     		
     		var sec = now.getSeconds(); 
     		if (sec < 10)
     		{
     			sec = "0"+sec;
     		}     		

     		
     	  	document.getElementById("time").innerHTML=now.getFullYear() 
      		  +"年"+(now.getMonth()+1) 
     		  +"月"+now.getDate() 
       		  +"日"
       		  +"  "+"星期"+day
       		  +"  "+hour
       		  +":"+min+":"+sec; 
   	 		setTimeout("showTime()","1000"); 
   		} 
   		
   		function focusSearch(element)
   		{
   			element.style.opacity=1;
   			if (element.value=="搜索信息") element.value="";
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

   		function clickItem(ele)
   		{
   			switch(ele.id)
   			{
   				case "weekTime":
   					document.getElementById("searchTime").value="week";
   					document.getElementById("noticeTime").value="本周";
   					break;
   				case "monthTime":
   					document.getElementById("searchTime").value="month";
   					document.getElementById("noticeTime").value="本月";
   					break;
   				case "todayTime":
   					document.getElementById("searchTime").value="today";
   					document.getElementById("noticeTime").value="今天";
   					break;
   				default:
   					document.getElementById("searchTime").value="all";
   					document.getElementById("noticeTime").value="全部";
   			}
   			setIsSearch();
   			document.getElementById("form").submit();
   			clearItem();
   		}
   		
   	   	function enterItem(ele)
   	   	{
   	   		//alert(ele.style.height);
   	   		switch(ele.id)
   	   		{
   	   			case "todayTime":
   	   				ele.style.backgroundImage='url(TacNotices/Image/SelectHover_Top.png)';
   	   				break;
   	   			case "allTime":
   	   				ele.style.backgroundImage='url(TacNotices/Image/SelectHover_Bottom.png)';
   	   				break;
   	   			default:
   	   				ele.style.backgroundImage='url(TacNotices/Image/SelectHover_Mid.png)';	
   	   		}

   	   	}
   	   	
   	   	function outItem(ele)
   	   	{
   	   	   	ele.style.backgroundImage='none';
   	   	}
   	   	
   	   	function clearItem()
   	   	{	
   			$("#catalog").slideUp("slow",function (){isAnimate=false;});
   	  	}
   	   	
   		function showItem(obj)
   		{
   			if (isAnimate) return ;
   			isAnimate=true;
   			$("#catalog").slideDown("medium");
   		}
   		
   		function changeItemState()
   		{
 		 	if (isAnimate) clearItem();
 			else showItem();   		
   		}
   		
   		function getAbsoluteX(e)
   		{
   			return e.getBoundingClientRect().left+document.body.scrollLeft;
   			
   		}
   		
   		function getAbsoluteY(e)
   		{
   			return e.getBoundingClientRect().top+document.body.scrollTop;
   		}
   		
   		function choosePage(index)
   		{
   			//如果不是新的搜索 还原搜索框中数据
   			document.getElementById("search").value=search;
   			checkSearchIsNull();
   			
   			document.getElementById("pageIndex").value=index;		
   			document.getElementById("form").submit();
   		}
   		
   		function nextPage()
   		{
   			var index=parseInt(document.getElementById("pageIndexText").value)+1;
   			var totPage=<%=allNotices.getAllPage()%>;
   			if (index>totPage)
   			{
   				alert("亲！已经最后一页了~~");
   				return ;
   			}
   			choosePage(index);
   		}
   		function lastPage()
   		{
   			var index=parseInt(document.getElementById("pageIndexText").value)-1;
   			if (index<=0)
   			{
   				alert("亲！已经第一页了~~");
   				return ;
   			}
   			choosePage(index);
   		}
   		
   		function setIsSearch()
   		{
   			checkSearchIsNull();
   			document.getElementById("isSearch").value="yes";
   		}
   		
   		function checkSearchIsNull()
   		{
   			if (document.getElementById("search").value=="搜索信息")
   			{
   				document.getElementById("search").value="";
   			}
   		}
   		
   		function init()
   		{
   			search=document.getElementById("search").value;
   			$("#cataDiv").mouseleave(function(){clearItem();});
   		}
   		
   		
	</script>
	
</head>



<body onload="init()">
	<div style="top:0; width:1200;  margin-right: auto; margin-left: auto;">
	 	<%@include file="/Navigation/Navigation.jsp"%> 
	 	
		<div style="width:1163">
			<div style="margin-left:auto; margin-right:auto">
				<form action="Notices" method="post" id="form">
					<input type="hidden" id="searchTime" name="searchTime" value="<%=allNotices.getNoticeTime()%>">
					<input type="hidden" id="pageIndex" name="pageIndex" value=<%=allNotices.getPageIndex()%>> 
					<input type="hidden" id="isSearch" name="isSearch" value="no">
					<table style="position:float; float:right;">
						<tr>
							<td>
								<input type="text" name="search" id="search" value="<%=allNotices.getSearch()%>" onfocus="focusSearch(this)" onblur="blurSearch(this)" style="width:450; height:50; font-size:20; text-align:center; opacity:0.2; position:float; float:right; ">
							</td>
						
							<td>
								<div id="cataDiv">
									<input type="button" value="<%=allNotices.getNoticeTime()%>" id="noticeTime"  onclick="changeItemState()" onmouseover="showItem(this);" style="width:162; height:51; background-image:url(TacNotices/Image/SelectButton.png); font-size:23">
									<div id="catalog"   style="display:none;  position:absolute; background-image:url(TacNotices/Image/SearchSelectPanel.png); z-index:999; width:163; height:205">
									 	<table cellspacing="0" cellpadding="0">	
									  		<tr>
												<td id="todayTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" onclick="clickItem(this)" style="width:165; height:51; font-size:23;">今天</td>
											</tr>
											
											<tr>
												<td id="weekTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" onclick="clickItem(this)" style="width:161; height:51; font-size:23;">本周</td>
											</tr>
											<tr>
												<td id="monthTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" onclick="clickItem(this)" style="width:161; height:52; font-size:23;">本月</td>
											</tr>
											<tr>
												<td id="allTime" onmouseover="enterItem(this)" onmouseout="outItem(this)" onclick="clickItem(this)" style="width:163; height:51; font-size:23;">全部</td>
											</tr>
										</table>
									</div>
								</div>	
							</td>
						
							<td>
								<button type="submit" onclick="setIsSearch()" style="background-image:url(TacNotices/Image/SearchButton.png); width:160; height:50"></button>
							</td>
						</tr>
					</table>
				</form>
			</div>
			
 			<div style="clear:both"> </div>
 			<br>
 			
 			<!-- 通知内容 -->
			<div style="height:1051; margin-left:auto; margin-right:auto; background-image:url(TacNotices/Image/ForeBG.png)">
				 <div>
				 	<br>
					<img src="TacNotices/Image/Title.png" style="position:relative; top:4; width:158; height:29" onload="showTime()">
					<span id="time" style="font-size:24; opacity:0.2"></span>
				</div>

				<table style="position:relative; top:80">
					<%
					for (int i = 0; i < allNotices.getAllNotices().size(); i++) 
					{%>
						<tr style="height:50; width:1100; height:72">
							<td style="position:relative; text-align:left; left:120">
								<a href="Notices/NoticesPage?indexNotices=<%=allNotices.getAllNotices().get(i).getNotice_id()%>" class="NoticesItem" title="<%=allNotices.getAllNotices().get(i).getNotice_title()%>"><%=allNotices.getAllNotices().get(i).getNotice_title()%></a>	
								<span style="color:red;"><%=allNotices.getAllNotices().get(i).getData()%></span>	
							</td>
						</tr>
				  <%}%>
				</table>
			</div> 
			<!-- 通知内容 -->
			
			<!--页号-->
			<div style="float:right; position:relative; top:-70; left:-100">
				<input type="hidden" id="pageIndexText" value="<%=allNotices.getPageIndex()%>"> 
				<a href="javascript:choosePage(1);" class="NoticesItem">首页</a> 
				<a href="javascript:lastPage();" class="NoticesItem">上一页</a>
				<%
					for (int i = 1; i <= allNotices.getAllPage(); i++) 
					{
						if (i == allNotices.getPageIndex()) 
						{%>
							<a style="color:red"><%=i%></a>
					  <%} 
						else 
						{%>
							<a href="javascript:choosePage(<%=i%>);" class="NoticesItem"><%=i%></a>
					  <%}%>
				 <%}%>
				 
				<a href="javascript:nextPage();" class="NoticesItem">下一页</a> 
				<a href="javascript:choosePage(<%=allNotices.getAllPage()%>);" class="NoticesItem">尾页</a>
			</div>
			<!-- 页号 -->
		</div>
		
		<%@include file="/Navigation/Footer.jsp"%>
	</div>
</body>
</html>
