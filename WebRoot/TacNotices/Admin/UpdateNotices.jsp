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
        	b=window.open();   
            b.document.open();   
            b.document.write(document.getElementById("chat_content").outterHTML); 
            b.document.close();   
       }
      
     </script>
	
</head>
  </head>
  
  <jsp:useBean id="notices" class="DataSource.Notices.Notices" scope="request">
  </jsp:useBean>
  
  <body>
    <div  style="top:0; width:1200;  margin-right: auto; margin-left: auto;"  >
	 	<%@include file="/Navigation/Navigation.jsp" %>
	 	<OBJECT id=dlgHelper CLASSID="clsid:3050f819-98b5-11cf-bb82-00aa00bdce0b" width="0px" height="0px" ></OBJECT>
	 	<div style="width:700; margin-right:auto; margin-left:auto">
	 		<br>
	 		<br>
	 		<form name="notices" action="/Tac/UpdateNotices" method="POST" style="text-align:center">
	 			<input type="text" value="<%=notices.getTitle() %>" name="title" style="width:300; height:50; text-align:center"> 
	 			<br>
	 			<br>
	 			<br>
	 			
	 			<span onclick="B_I_U('Bold');">粗体</span>
                <span onclick="B_I_U('Italic');">斜体</span>
                <span onclick="B_I_U('Underline');">下划线</span>
                <span onclick="showFontSize();">字号</span>
                <span onclick="coloropen(event)">字体颜色</span>
                <div id="colorpane" style="position:absolute;z-index:999;display:none;"></div>
                <div class="">
                	<%@include file="ColorPanel.jsp" %>               
                </div>
                
<!-- 	<input type="button" value="颜色选择" onclick="coloropen(event)" id="inputcolor" /> -->
 
                
	 			<iframe id="chat_content"  src="TacNotices/Admin/BlankContent.html" scrolling="auto"></iframe>
	 			
	 			<input type="submit" style="width:100; height:100; font-size:20">
	 		</form>
	 </div>	
	  	<%@include file="/Navigation/Footer.jsp" %>
	 </div>
	 
	   
  </body>
</html>
