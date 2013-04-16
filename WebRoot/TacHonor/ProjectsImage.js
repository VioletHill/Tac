 	var imgName=new Array();
 	var isFirst=true;
	var x,y;
	var indexImg;
	var isChange=false;
 	
 	function linkToImg(pro)
	{
		window.location.href="http://localhost:8080/Tac/Honor/Project?id="+pro.id;
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
		indexImg=(indexImg+1)%imgName[pro.id].length;
		pro.src=imgName[pro.id][indexImg];
		x=event.clientX;
		y=event.clientY;
	}
	
	function moveLastImg(pro)
	{
		indexImg=(indexImg-1+imgName[pro.id].length)%imgName[pro.id].length;
		pro.src=imgName[pro.id][indexImg];
		x=event.clientX;
		y=event.clientY;
	}
	
	function leaveImg(pro)
	{
		pro.src=imgName[pro.id][0];
		isFirst=true;
	}
	
	