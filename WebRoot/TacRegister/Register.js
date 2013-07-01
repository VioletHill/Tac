
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
			document.getElementById("password").value=MD5(document.getElementById("password").value);
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
		
		$.post("Register",{account:account,isRegister:"false" }, function(msg)
				{
					if (msg=="true")
					{
						isAccountOk=true;
						document.getElementById("accountImg").style.display="inline";
					}
					else
					{
						document.getElementById("accountInfor").innerHTML="该账号已被注册";
					}
					
				});
		
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
		var reg = /^([a-zA-Z0-9_.-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/;
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
		 var objType=new Array("png","jpg","gif");
		 var objFile=obj.value;
		 objFile=objFile.substring(objFile.lastIndexOf(".")+1); 
		 
		 for (var i=0; i<objType.length; i++)
		 {
			if (objType[i]==objFile)
			{
				document.getElementById('headText').value="上传中，请稍后";
				document.getElementById("headForm").submit();
				return ;
			}
		 }
		 document.getElementById("headFile").value="";
		 document.getElementById('headText').value="不支持本文件类型";
	 }
	 
 
	 function callback(a)
	 {
		 document.getElementById('headText').value="拖动头像，直到你满意为止";
		 document.getElementById("headFile").value=a;
		 document.getElementById('ImageDrag').src=a;
	 }
	 
	 function fail()
	 {
		 document.getElementById('headText').value="上传失败！可能原因：文件过大，目前只支持2.5M以下 或 头像长宽不够38px";
		 document.getElementById("headFile").value="";
	 }
	 
	 
	 function startCut() 
	 {
		 var realWidth;
	     var realHeight;
	     var $imagedrag = $("#ImageDrag");
	     realHeight=document.getElementById("ImageDrag").offsetHeight;
	     realWidth=document.getElementById("ImageDrag").offsetWidth;
	     document.getElementById("ImageDrag").style.left=0;
	     document.getElementById("ImageDrag").style.top=0;
	     //获取上传图片的实际高度，宽度
	     $("#txt_left").val(0);
         $("#txt_top").val(0);  
         
//	     //设置图片可拖拽
	     $imagedrag.draggable(
	     {
	         cursor: 'move',
	         drag: function(e, ui) 
	         {
	        	 try
	        	 {
	        		 var self = $(this).data("draggable");
		             var left=0 - parseInt(self.position.left);
		             var top=0 - parseInt(self.position.top);
		             if (left<0)
		             {
		            	 self.position.left=left=0;
		             }
		             if (top<0)
		             {
		            	 self.position.top=top=0;
		             }

		             if (top>realHeight-38)
		             {
		            	 top=realHeight-38;
		            	 top=self.position.top=-top;
		             }
		             
		             if (left>realWidth-38)
		             {
		            	 left=realWidth-38;
		            	 self.position.left=-left;
		             }
		             
		             $("#txt_left").val(left);
		             $("#txt_top").val(top);  
	        	 }
	        	 catch (e)
	        	 {}
	        	 
	            
	         }
	     }
	     );
	 }
	 
