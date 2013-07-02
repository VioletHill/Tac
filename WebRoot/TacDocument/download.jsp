<%@page language="java" contentType="application/x-msdownload"
	pageEncoding="gb2312"%>
<%@ page language="java" import="java.util.*"%>
<%@ page language="java" import="java.io.*"%>
	
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'download.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		String filename = request.getParameter("filename");
		String filepath = request.getParameter("filepath") + filename;
		int i = 0;
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment;filename = "
				+ filename);
/* 		java.io.FileInputStream fileInputStream = new java.io.FileInputStream(
				"/usr/local/apache-tomcat-7.0.37/webapps" + filepath); */
/* 		while ((i = fileInputStream.read()) != -1) {
			out.write(i);
		} */
		java.io.OutputStream outp = null;
		java.io.FileInputStream in = null;
		try {
			outp = response.getOutputStream();
			in = new FileInputStream("/usr/local/apache-tomcat-7.0.37/webapps" + filepath);

			byte[] b = new byte[1024];
			i = 0;

			while ((i = in.read(b)) > 0) {
				outp.write(b, 0, i);
			}
			//    
			outp.flush();
			//要加以下两句话，否则会报错  
			//java.lang.IllegalStateException: getOutputStream() has already been called for //this response    
			out.clear();
			out = pageContext.pushBody();
		} catch (Exception e) {
			System.out.println("Error!");
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
				in = null;
			}
			//这里不能关闭    
			//if(outp != null)  
			//{  
			//outp.close();  
			//outp = null;  
			//}  
		}
	%>
</body>
</html>
