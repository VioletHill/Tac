<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Rigister.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="TacRegister/Register.css">
	
	<style>
		body {
			background-image: url("image/mainBG.png");
			padding: 0px;
			margin: 0px;
		}
	</style>
	
	<script type="text/javascript" src="TacRegister/Register.js"></script>
	<script src="jquery-1.9.1.js"></script>
	
  </head>
  
  <body>
 	 <div style="top:0; width:1200;  margin-right: auto; margin-left: auto;">
 	 
   		<%@include file="/Navigation/Navigation.jsp" %>
   		
    	<div class="RegisterDiv">
  			<form id="form" method="post" action="Register"  enctype="multipart/form-data"> 
    			<br>
    			<input class="RegisterItem RegisterAccount" type="text" name="account" placeholder="�������˺�" maxlength="30" onblur="checkAccount(this);">
    			<img id="accountImg" class="RegisterImg" src="TacRegister/Image/check.png">
    			<span id="accountInfor" class="RegisterInfor"></span><br>
    			
    			<input class="RegisterItem RegisterPassword" type="password" id="password" name="password" placeholder="����������" maxlength="30" onblur="checkPassword(); checkPasswordAgain();">
    			<img id="passwordImg" class="RegisterImg" src="TacRegister/Image/check.png">
    			<span id="passwordInfor" class="RegisterInfor"></span><br>
    			
    			<input class="RegisterItem RegisterPassword" type="password" id="passwordAgain" placeholder="���ٴ�ȷ������" maxlength="30" onblur="checkPasswordAgain();">
    			<img id="passwordAgainImg" class="RegisterImg" src="TacRegister/Image/check.png">
    			<span id="passwordAgainInfor" class="RegisterInfor"></span><br>
    			
    			<input class="RegisterItem RegisterMail" type="text" name="email" placeholder="����������" maxlength="30" onblur="checkEmail(this);">
    			<img id="emailImg" class="RegisterImg" src="TacRegister/Image/check.png">
    			<span id="emailInfor" class="RegisterInfor"></span><br>
    			
    			<input class="RegisterItem RegisterPhone" type="text" name="phone" placeholder="�������ֻ�����" maxlength="15"/><br>
    			
    			<input class="RegisterItem RegisterItemHeaderLabel" id="headText" type="text" readonly placeholder="�ϴ�һ��ͷ��"/>
    			<input class="RegisterItem RegisterItemHeaderButton" type="button" onclick="document.getElementById('headFile').click()"/><br>	
   				
   				<input type="file"  id="headFile" name="headerImg" onchange="document.getElementById('headText').value=this.value" style="display:none"/>
   				
   				<div id="RegisterButton">
   				<input class="RegisterItemSubmit"  type="button" onclick="canSubmit();">
   				</div>
   			</form>	
   				
    	</div>
    	
    </div>
  </body>
</html>
