
<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

    <script type="text/javascript" src="MD5.js"></script>
    <script type="text/javascript" src="TacHome/Navigation/HomeNavigation.js"></script>
    
    <link type="text/css" rel="stylesheet"
	href="common/common.css" charset="utf-8"/>
	
    <link rel="stylesheet" type="text/css" href="TacHome/Navigation/HomeNavigation.css">

<!--  navigation -->
  	<div style="top:0;width:1200; height:607; vertical-align:bottom; background-image:url(TacHome/Image/NavigationBg.png); margin-right: auto; margin-left: auto;"  >
  		 <div id="tacnav">
          <table> 
            <tr>
              <%
              if (session.getAttribute("isLog")==null || session.getAttribute("isLog").equals(false))
            	{%>
            	
               <%}
               else
               {%>
               		<td style="position:relative; left:-100;"><div class="headDiv"><img class="headImg" src="<%=session.getAttribute("headAdd")%>"></div></td>
               <%}%>
              <td><a class="tacnav" href="Home"><div><p>首页</p></div></a></td>
              <td><a class="tacnav" href="Document"><div><p>资料室</p></div></a></td>
              <td><a class="tacnav" href="MessageBoard"><div><p>留言墙</p></div></a></td>
              <td><a class="tacnav" href="Team"><div><p>求包养</p></div></a></td>

            </tr>
        </table>
        </div>

    	<div class="container">
    		<div class="imageWheel">
    		   <img src="TacHome/Image/Image0.png" > 
    		   <img src="TacHome/Image/Image1.png" >
    		   <img src="TacHome/Image/Image2.png" >
    		   <img src="TacHome/Image/Image3.png">
    		                     
    		</div>
    		 
    		<div class="pageing">
    			<img id="page0" src="TacHome/Image/ImagePage.png" onClick="setIndexImg(0)">
    			<img id="page1" src="TacHome/Image/ImagePage.png" onClick="setIndexImg(1)">
    			<img id="page2" src="TacHome/Image/ImagePage.png" onClick="setIndexImg(2)">
    			<img id="page3" src="TacHome/Image/ImagePage.png" onClick="setIndexImg(3)">
    	    </div>
    	    
    	    <div>
    	    	<img src="TacHome/Image/LastPage.png" onclick="lastImg()" style="position:relative;   left:5; top:-200px; opacity:0.8">
    	  	  	<img src="TacHome/Image/NextPage.png" onclick="nextImg()" style="position:relative;   left:540; top:-200px; opacity:0.8">
   			</div>
    	</div>
 		<div class="loginFormDiv">
    		<form class="loginForm" action="" method="post">
				<input type="text" id="loginAccount" class="loginAccount"  name="account" placeholder="用户名"> <br>   	
				<input type="password" id="loginPassword" class="loginPassword" name="password" placeholder="密码"><br>
				<input type="button" class="loginButton" id="loginButton" onclick="login()"><br>
				<img class="loginImg" id="loginImg" src="TacHome/Image/imgbox-spinner.gif"><br>
    		</form>
    	</div>   	
    	<%if (session.getAttribute("isLog")==null || session.getAttribute("isLog").equals(false))
    	{%>
    	
    	<div class="loginBufferBoxLogin" id="loginBufferBoxLogin">
   			<button class="loginBufferLogin" onClick="showLoginForm()"></button> 
   			<button class="loginBufferRegister" onclick="linkToRegister()"></button> 
   		</div>
   		
   		<div class="loginBufferBoxCancel" id="loginBufferBoxCancel">
   			<button class="loginBufferCancel" onClick="hiddenLoginForm()"></button> 
   			<button class="loginBufferRegister" onclick="linkToRegister()"></button> 
   		</div>
   		<%}
   		else
   		{%>
   		<div class="logoutBufferBoxLogout" id="logoutBufferBoxLogout">
   			<button class="logoutBufferLogout" onClick="logout();"></button> 
   			<button class="loginBufferRegister" onclick="linkToRegister()"></button> 
   		</div>
   	  <%}%>
   	</div> 
   	<div style="clear:both"> </div>

