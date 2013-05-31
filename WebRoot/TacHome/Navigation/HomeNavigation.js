/////////////////////////////////////

////////////µÇÂ½
	var isLoginAnimate=false;
	
	function showLoginForm()
	{
		if (isLoginAnimate) return ;
		isLoginAnimate=true;
		document.getElementById("loginBufferBoxLogin").style.display="none";
		$(".loginForm").fadeIn();		
		$("#loginBufferBoxCancel").fadeIn(function (){isLoginAnimate=false;});
	}
	
	function hiddenLoginForm()
	{
		if (isLoginAnimate) return ;
		isLoginAnimate=true;
		document.getElementById("loginBufferBoxCancel").style.display="none";
		$(".loginForm").fadeOut();		
		$("#loginBufferBoxLogin").fadeIn(function (){isLoginAnimate=false;});
	}
	
	var isLog=false;
	function login()
	{
		if (isLog) return ;
		isLog=true;
		
		document.getElementById("loginImg").style.display="inline";
		
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
		  xmlhttp=new XMLHttpRequest();
		}
		else
		{
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}

		xmlhttp.open("POST", "Login?account="+document.getElementById("loginAccount").value+ "&password="+document.getElementById("loginPassword").value, false);
		xmlhttp.send();
		if (xmlhttp.responseText=="true")
		{
			loginSuccess();
		}
		else
		{
			loginFail();
		}	
		isLog=false;
	}
	
	var isShake=false;
	function shake(time)
	{
		if (time==0)
		{
			$("#loginButton").animate({left:0},10,function (){isShake=false;});
			return ;
		}
		$("#loginButton").animate({left:10},10,
			function ()
			{
				$(this).animate({left:-10},10,function (){shake(time-1);});
			});
	}
	
	function loginFail()
	{
		document.getElementById("loginImg").style.display="none";
		
		if (isShake) return ;
		isShake=true;
		document.getElementById("loginButton").style.position="relative";
		shake(15);

	}
	
	function loginSuccess()
	{
		document.getElementById("loginImg").style.display="none";
		window.top.location.reload();
	}
	
	
	function linkToRegister()
	{
		window.open("TacRegister/Register.jsp");
	}
	
	
/////////////µ¼º½À¸
	var indexImg=0;
    var totImg=4;
    var imageWidth=614;
    var isMove=false;
    function setIndexImg(index)
    {
    	if (isMove==true) return ;
    	isMove=true;
    	indexImg=index;
    	var wheelPosition=imageWidth*indexImg;
    	$(".ImageWheel").animate({left:-wheelPosition},function(){moveDone();});
    	document.getElementById("page0").src="TacHome/Image/ImagePage.png";
    	document.getElementById("page1").src="TacHome/Image/ImagePage.png";
    	document.getElementById("page2").src="TacHome/Image/ImagePage.png";
    	document.getElementById("page3").src="TacHome/Image/ImagePage.png";
    	document.getElementById("page"+indexImg).src="TacHome/Image/ImagePageSelect.png";
    }
    
    function nextImg()
    {
 		if (isMove==true) return ;
    	indexImg=(indexImg+1)%totImg;
    	setIndexImg(indexImg); 	
    }
    
    function lastImg()
    {
 		if (isMove==true) return ;
    	indexImg=(indexImg+totImg-1)%totImg;
    	setIndexImg(indexImg);
    }
    
    var timer;
    function moveDone()
    {
    	clearTimeout(timer);
    	timer=setTimeout(function(){nextImg();},2500);
   	  	isMove=false;
    }
    function init() 
    {
    	setIndexImg(0);
	}
	
	$(document).ready(function(){
		var div = document.getElementsByClassName('imageWheel')[0];		
		for (var i = 0; i != div.childNodes.length; i++)
			if (div.childNodes[i].nodeType == 3){
				div.removeChild(div.childNodes[i]);
				i--;
			}
	
	});
	
	


	