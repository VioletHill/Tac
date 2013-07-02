<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML >
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'UploadDocument.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="utf-8" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <form action="Admin/UploadDocument" method="post" enctype="multipart/form-data">
    	<input type="file" name="file"/>
    	标题<input type="text" name="title"/>
    	描述<textarea name="description"></textarea>
    	<select name="catalog">
    		<option value="all">所有</option>
    		<option value="document">文档</option>
    		<option value="lib">类库</option>
    		<option value="sourceCode">源码</option>
    		<option value="software">软件</option>
    		<option value="design">设计</option>
    		
    		
    	</select>
    	<input type="submit" value="上传"/>
    </form>
  </body>
</html>
