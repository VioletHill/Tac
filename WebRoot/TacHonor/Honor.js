
 	var isFirst=true;
	var x,y;
	var indexImg;
	var isChange=false;
	
	
 	function linkToImg(pro)
	{
		window.location.href="Honor/Project?id="+pro.id;
	}

	function changeImg(pro)
	{
		
		if (isFirst)
		{
			isFirst=false;
			indexImg=1;
			x=event.clientX;
			y=event.clientY;
		}
		else
		{
			if (isChange) return ;
			if (x-event.clientX>30 || y-event.clientY>30)
			{
				isChnage=true;
				moveLastImg(pro);
				isChnage=false;
			}
			else if (event.clientX-x>30 || event.clientY-y>30)
			{
				isChange=true;
				moveNextImg(pro);
				isChange=false;
			}
			
		}
	}
	
	function moveNextImg(pro)
	{
		var tot=parseInt(pro.name);
		indexImg=(indexImg+1)%tot;
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
		  xmlhttp=new XMLHttpRequest();
		}
		else
		{
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("POST", "Honor/GetProjectImage?indexProject="+pro.id+ "&indexImage="+indexImg, false);
		xmlhttp.send();
		pro.src=xmlhttp.responseText;
		x=event.clientX;
		y=event.clientY;
	}
	
	function moveLastImg(pro)
	{
		var tot=parseInt(pro.name);
		indexImg=(indexImg-1+tot)%tot;
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
		  xmlhttp=new XMLHttpRequest();
		}
		else
		{
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("POST", "Honor/GetProjectImage?indexProject="+pro.id+ "&indexImage="+indexImg, false);
		xmlhttp.send();
		pro.src=xmlhttp.responseText;
		x=event.clientX;
		y=event.clientY;
	}
	
	function leaveImg(pro)
	{
		var xmlhttp;
		if (window.XMLHttpRequest)
		{
		  xmlhttp=new XMLHttpRequest();
		}
		else
		{
		  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
		}
		xmlhttp.open("POST", "Honor/GetProjectImage?indexProject="+pro.id+ "&indexImage=0", false);
		xmlhttp.send();
		pro.src=xmlhttp.responseText;
		x=event.clientX;
		y=event.clientY;
		isFirst=true;
	}
	
	