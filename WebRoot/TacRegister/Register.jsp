<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>欢迎加入Tac</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<link rel="stylesheet" type="text/css" href="TacRegister/Register.css">
	
	<style>
		body 
		{
			background-image: url("image/mainBG.png");
			padding: 0px;
			margin: 0px;
		}
	</style>
	
	<script src="jquery-1.9.1.js"></script>
	<script type="text/javascript" src="TacRegister/jquery1.2.6.pack.js"></script>
	<script  type="text/javascript" src="TacRegister/ui.core.packed.js" ></script>
	<script type="text/javascript" src="TacRegister/ui.draggable.packed.js"></script>
	<script type="text/javascript" src="TacRegister/Register.js"></script>	
	<script type="text/javascript" src="TacRegister/CutHeader.js"></script>
	
  </head>
  
  <body onload="initRegister()">
 	 <div style="top:0; width:1200;  margin-right: auto; margin-left: auto;">
 	 
   		<%@include file="/Navigation/Navigation.jsp" %>
   		
    	<div class="RegisterDiv">
  			<form id="form" method="post" action="Register"  enctype="multipart/form-data"> 
    			<br>
    			<input class="RegisterItem RegisterAccount" type="text" name="account" placeholder="请输入账号" maxlength="30" onblur="checkAccount(this);">
    			<img id="accountImg" class="RegisterImg" src="TacRegister/Image/check.png">
    			<span id="accountInfor" class="RegisterInfor"></span><br>
    			
    			<input class="RegisterItem RegisterPassword" type="password" id="password" name="password" placeholder="请输入密码" maxlength="30" onblur="checkPassword(); checkPasswordAgain();">
    			<img id="passwordImg" class="RegisterImg" src="TacRegister/Image/check.png">
    			<span id="passwordInfor" class="RegisterInfor"></span><br>
    			
    			<input class="RegisterItem RegisterPassword" type="password" id="passwordAgain" placeholder="请再次确认密码" maxlength="30" onblur="checkPasswordAgain();">
    			<img id="passwordAgainImg" class="RegisterImg" src="TacRegister/Image/check.png">
    			<span id="passwordAgainInfor" class="RegisterInfor"></span><br>
    			
    			<input class="RegisterItem RegisterMail" type="text" name="email" placeholder="请输入邮箱" maxlength="30" onblur="checkEmail(this);">
    			<img id="emailImg" class="RegisterImg" src="TacRegister/Image/check.png">
    			<span id="emailInfor" class="RegisterInfor"></span><br>
    			
    			<input class="RegisterItem RegisterPhone" type="text" name="phone" placeholder="请输入手机号码" maxlength="15"/><br>
    			
    			<input name="txt_top" type="hidden" value="0" id="txt_top" />
                <input name="txt_left" type="hidden" value="0" id="txt_left" />
    			
   				<input type="text"  id="headFile" name="headerImg"  value="" style="display:none"/>
   				<input class="RegisterItem RegisterItemHeaderLabel" id="headText" type="text" readonly placeholder="上传一张头像"/>
    			<input class="RegisterItem RegisterItemHeaderButton" type="button" onclick="document.getElementById('tempHeadFile').click()"/><br>
   				<!-- 头像 -->
   				
   				
   				<div id="ImageDragContainer">                               
                    <img id="ImageDrag" class="imagePhoto" src="" style="border-width:0px;" onload="startCut()"/>                                                        
                </div>
 
    
   				<div id="RegisterButton">
   				<input class="RegisterItemSubmit"  type="button" onclick="canSubmit();">
   				</div>
   			
   			</form>	
   		
   			<form id="headForm" method="post" action="TempHeader"  enctype="multipart/form-data" target="abc">
   				<input type="file"  id="tempHeadFile" name="headerImg" onchange="addHeader(this)" style="display:none"/>
   			</form>
   			
   			<iframe name="abc" id="abc" style="display:none"></iframe>
    	</div>
    	
    </div>
  </body>
</html>
