
	var isAccountOk=false;
	var isPasswordOk=false;
	var isEmailOk=false;

	var isShake=false;
	function shake(time)
	{
		if (time==0)
		{
			$("#RegisterButton").animate({left:0},10,function (){isShake=false;});
			return ;
		}
		$("#RegisterButton").animate({left:10},10,
			function ()
			{
				$(this).animate({left:-10},10,function (){shake(time-1);});
			});
		
	}
	function canSubmit()
	{
		if (canRegister())
		{
			document.getElementById("form").submit();
		}
		else
		{
			if (isShake) return ;
			isShake=true;
			document.getElementById("RegisterButton").style.position="relative";
			shake(15);
		}
	}

	function checkAccount(element)
	{
		isAccountOk=false;
		document.getElementById("accountImg").style.display="none";
		document.getElementById("accountInfor").innerHTML="";
		var account=element.value;
		
		if (!checkStr(account))
		{
			document.getElementById("accountInfor").innerHTML="账号只能由大小写字母、数字、下划线组成";
			return ;
		}
		
		if (account=="")
		{
			document.getElementById("accountInfor").innerHTML="账号不能为空";
			return ;
		}
		
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
		  xmlhttp=new XMLHttpRequest();
		}
		else
		{
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("POST", "Register?account="+account+ "&isRegister="+"false", false);
		xmlhttp.send();
		
		if (xmlhttp.responseText=="true")
		{
			isAccountOk=true;
			document.getElementById("accountImg").style.display="inline";
		}
		else
		{
			document.getElementById("accountInfor").innerHTML="该账号已被注册";
		}
		
	}
	
	function checkPassword()
	{
		document.getElementById("passwordImg").style.display="none";
		document.getElementById("passwordInfor").innerHTML="";
		isPasswordOk=false;
		var password=document.getElementById("password").value;
		
		if (!checkStr(password))
		{
			document.getElementById("passwordInfor").innerHTML="账号只能由大小写字母、数字、下划线组成";
			return ;
		}
		if (password=="")
		{
			document.getElementById("passwordInfor").innerHTML="密码不能为空";
			return ;
		}
		
		document.getElementById("passwordImg").style.display="inline";
		checkPasswordAgain();
	}
	
	function checkPasswordAgain()
	{
		document.getElementById("passwordAgainImg").style.display="none";
		document.getElementById("passwordAgainInfor").innerHTML="";
		
		var password=document.getElementById("password").value;
		var passwordAgain=document.getElementById("passwordAgain").value;
		
		if (passwordAgain=="") return ;
		
		if (password==passwordAgain)
		{
			isPasswordOk=true;
			document.getElementById("passwordAgainImg").style.display="inline";
		}
		else
		{
			isPasswordOk=false;
			document.getElementById("passwordAgainInfor").innerHTML="两次密码不一致";
			return ;
		}
		
	}
	
	function checkEmail(element)
	{
		document.getElementById("emailImg").style.display="none";
		document.getElementById("emailInfor").innerHTML="";
		
		isEmailOk=false;
		var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
		if (element.value=="") return ;
		
		if (reg.test(element.value))
		{
			document.getElementById("emailImg").style.display="inline";
			isEmailOk=true;
		}
		else
		{
			document.getElementById("emailInfor").innerHTML="请输入正确的邮箱";
			return ; 
		}
		
		
	}
	
	
	function canRegister()
	{
		return isPasswordOk & isAccountOk & isEmailOk;
	}
	
	 function checkStr(str)
	 {
		 var reg=/[^A-Za-z0-9_]/;
		 if (reg.test(str)) return false ;
		 else	return true ;
	 }
	 
	 function initRegister()
	 {
			isAccountOk=false;
			isPasswordOk=false;
			isEmailOk=false;
	 }
	 
	 function addHeader(obj)
	 {
		document.getElementById('headText').value=obj.value;
		document.getElementById("headForm").submit();
	 }
	 
	 function callback(a)
	 {
		 document.getElementById("headFile").value=a;
		 document.getElementById('imgphoto').src=a;
	 }
	 
	 
