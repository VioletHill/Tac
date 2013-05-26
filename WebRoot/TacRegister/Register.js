
var isAccountOk=false;
var isPasswordOk=false;
var isEmailOk=false;

	function canSubmit()
	{
		if (canRegister())
		{
			return true;
		}
		else
		{
			alert("��~~ ע����ִ�����~~ �����������Ϣ�Ƿ���д��ȷ��");
			return false;
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
			document.getElementById("accountInfor").innerHTML="�˺�ֻ���ɴ�Сд��ĸ�����֡��»������";
			return ;
		}
		
		if (account=="")
		{
			document.getElementById("accountInfor").innerHTML="�˺Ų���Ϊ��";
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
			document.getElementById("accountInfor").innerHTML="���˺��ѱ�ע��";
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
			document.getElementById("passwordInfor").innerHTML="�˺�ֻ���ɴ�Сд��ĸ�����֡��»������";
			return ;
		}
		if (password=="")
		{
			document.getElementById("passwordInfor").innerHTML="���벻��Ϊ��";
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
			document.getElementById("passwordAgainInfor").innerHTML="�������벻һ��";
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
			document.getElementById("emailInfor").innerHTML="��������ȷ������";
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
	 
	