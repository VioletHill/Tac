<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<style>
  		<%@include file="/TacNotices/NoticesItem.css" %>  
  	</style>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Edit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<jsp:useBean class="DataSource.Notices.AllNotices" id="allNotices" scope="request">
   	</jsp:useBean>
   	

	
	<script>
		function choosePage(index)
   		{
   			//��������µ����� ��ԭ������������
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
   				alert("�ף��Ѿ����һҳ��~~");
   				return ;
   			}
   			choosePage(index);
   		}
   		function lastPage()
   		{
   			var index=parseInt(document.getElementById("pageIndexText").value)-1;
   			if (index<=0)
   			{
   				alert("�ף��Ѿ���һҳ��~~");
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
   			if (document.getElementById("search").value=="������Ϣ")
   			{
   				document.getElementById("search").value="";
   			}
   		}
   		
   	
	</script>
  </head>
  
  <body>
  	<%
		if (session.getAttribute("isLog")==null || session.getAttribute("isLog").equals("false") || session.getAttribute("permission").equals("0"))
		{
			response.sendRedirect("/Tac/ErrorPage/ErrorPage.html"); 
			return ;
		} 
	%>
   	 <div  style="top:0; width:1200;  margin-right: auto; margin-left: auto;"  >
	 	<%@include file="/Navigation/Navigation.jsp" %>
	 	
	 	<br>
	 	<table style="width:1200">
		<%
		for (int i = 0; i < allNotices.getAllNotices().size(); i++) 
		{%>
			<tr style="height:50; width:1200">
				<td style="text-align:left;">
					<a href="Notices/NoticesPage?indexNotices=<%=allNotices.getAllNotices().get(i).getNotice_id()%>" class="NoticesItem" title="<%=allNotices.getAllNotices().get(i).getNotice_title()%>">
						<%=allNotices.getAllNotices().get(i).getNotice_title()%>
					</a>	
					
					<span style="color:red;"><%=allNotices.getAllNotices().get(i).getData()%></span>	
					
					<a  class="NoticesItem" href="Admin/DeleteIndexNotices?index=<%=allNotices.getAllNotices().get(i).getNotice_id()%>" class="NoticesItem" style="float:right; width:50">
						ɾ��  
					</a>
					
					<a class="NoticesItem" href="Admin/EditIndexNotices?index=<%=allNotices.getAllNotices().get(i).getNotice_id()%>" style="float:right; width:50">
						�༭  
					</a>
					
				</td>
			</tr>
		<%}%>
		</table>
	 	
	 	<br>
	 	<br>
	 	<a class="NoticesItem" href="Admin/EditIndexNotices" style="float:right">
	 		�����֪ͨ
	 	</a>
	 	
	 	
	 	<!--ҳ��-->
	 	<br>
		<div style="float:right">
			<input type="hidden" id="pageIndexText" value="<%=allNotices.getPageIndex()%>"> 
			<a href="javascript:choosePage(1);" class="NoticesItem">��ҳ</a> 
			<a href="javascript:lastPage();" class="NoticesItem">��һҳ</a>
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
				 
			<a href="javascript:nextPage();" class="NoticesItem">��һҳ</a> 
			<a	href="javascript:choosePage(<%=allNotices.getAllPage()%>);" class="NoticesItem">βҳ</a>
		</div>
	  	<%@include file="/Navigation/Footer.jsp" %>
	 </div>	  
  </body>
</html>
