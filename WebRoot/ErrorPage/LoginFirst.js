var isLoging=false;
	function login()
	{
		if (isLoging) return ;
		isLoging=true;
		$.post("Login",{account:document.getElementById("account").value,password:MD5(document.getElementById("password").value) }, function(msg)
				{
					if (msg=="true")
					{
						loginSuccess();
					}
					else
					{
						loginFail();
					}
					isLoging=false;
				});
	
	}
	
	var isShake=false;
	function shake(time)
	{
		if (time==0)
		{
			$("#Login").animate({left:0},10,function (){isShake=false;});
			return ;
		}
		$("#Login").animate({left:10},10,
			function ()
			{
				$(this).animate({left:-10},10,function (){shake(time-1);});
			});
	}
	
	function loginFail()
	{	
		if (isShake) return ;
		isShake=true;
		shake(15);

	}
	
	function loginSuccess()
	{
		window.location.href="Home";
	}
	
	
	function linkToRegister()
	{
		window.location.href="TacRegister/Register.jsp";
	}
