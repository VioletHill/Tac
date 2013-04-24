<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'AddNotices.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript">
       //粗体、斜体、下划线
       function B_I_U(b_i_u)
       {
            chat_content.document.execCommand(b_i_u);                                
       }
       
       function save()
       {
       		var contentHtml;
       		if (document.getElementById("chat_content").contentWindow.document.body.innerHTML)
       		{
       			//alert("chrome / safari /fixfox");
       			document.getElementById("chat_content").contentWindow.document.body.contenteditable="false";
       			contentHtml=document.getElementById("chat_content").contentWindow.document.body.innerHTML;
       		}
      		else if (document.getElementById("chat_content").document.documentElement.innerHTML)
      		{
      			//alert("ie");
      			contentHtml=document.getElementById("chat_content").document.documentElement.innerHTML;
      		}
      		else
      		{
      			alert("你的浏览器不支持");
      			return ;
      		}
      		while (contentHtml.indexOf("#")!=-1)
      		{
      			contentHtml=contentHtml.replace("#","%23");
      		}
			var title=document.getElementById("title").value;
       		window.location.href="http://localhost:8080/Tac/UpdateNotices?title="+title+"&content="+contentHtml; 
       		alert("新通知已经被发布");
       }
      
       function cancel()
       {
       		windows.location.href="http://localhost:8080/Tac/Home";
       		alert("已经取消新通知的发布");
       }
     </script>
  </head>
  
  <jsp:useBean id="notices" class="DataSource.Notices.Notices" scope="request">
  </jsp:useBean>
  
  <body>
    <div  style="top:0; width:1200;  margin-right: auto; margin-left: auto;"  >
	 	<%@include file="/Navigation/Navigation.jsp" %>

	 	<div style="width:700; margin-right:auto; margin-left:auto; text-align:center">
	 		<br>
	 		<br>
	 		<form action="/Tac/UpdateNotices">
	 		<input id="title" type="text" value="<%=notices.getTitle() %>" name="title" style="width:300; height:50; text-align:center; font-size:20"> 
	 		<br>
	 		<br>
	 		<br>
	 			
	 		<span onclick="B_I_U('Bold');">粗体</span>
            <span onclick="B_I_U('Italic');">斜体</span>
            <span onclick="B_I_U('Underline');">下划线</span>
            <span onclick="showFontSize();">字号</span>
            <span onclick="coloropen(event);">字体颜色</span>
            <div id="colorpane" style="position:absolute;z-index:999;display:none;"></div>
            <div class="">
             	<%@include file="ColorPanel.jsp" %>               
            </div>
           <input type="submit" value="ss">
            </form>
            <br>
            <br>
            <iframe style="width:700; height:800"  id="chat_content" src="TacNotices/Admin/BlankContent.html"scrolling="auto"></iframe>
	 		<br>
	 		<div style="text-align:right">
	 			<input type="button" onclick="save();" style="width:100; height:100; font-size:20;" value="提交">
	 			<input type="button" onclick="cancel();" style="width:100; height:100; font-size:20;" value="取消">
	 		</div>
	 
	 </div>	
	  	<%@include file="/Navigation/Footer.jsp" %>
	 </div>
	 
	   
  </body>
</html>
