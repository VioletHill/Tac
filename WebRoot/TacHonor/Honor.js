
 	var isFirst=true;
	var x,y;
	var indexImg;
	var imgId;
	var isChange=false;
	var imgName=null;
	
 	function linkToImg(pro)
	{
		window.location.href="Honor/Project?id="+pro.id;
	}

	function changeImg(pro)
	{
		
		if (isFirst)
		{
			if (imgName==null) initChangeImg();
			isFirst=false;
			isChange=false;
			indexImg=0;
			imgId=pro.name;
			x=event.clientX;
			y=event.clientY;
		}
		else
		{
			if (isChange) return ;
			if (x-event.clientX>30 || y-event.clientY>30)
			{
				isChange=true;
				moveLastImg(pro);
				isChange=false;
			}
			else if (event.clientX-x>30 || event.clientY-y>30)
			{
				isChange=true;
				moveNextImg(pro);
				isChange=false;
			}
			
		}
	}
	function setIndexImg(pro)
	{
		x=event.clientX;
		y=event.clientY;
		pro.src=imgName[imgId][indexImg];
	}
	function moveNextImg(pro)
	{
		indexImg=(indexImg+1)%imgName[imgId].length;
		setIndexImg(pro);
	}
	
	function moveLastImg(pro)
	{
		indexImg=(indexImg-1+imgName[imgId].length)%imgName[imgId].length;
		setIndexImg(pro);
	}
	
	function leaveImg(pro)
	{
		indexImg=0;
		setIndexImg(pro);
		isFirst=true;
	}
	
	function initChangeImg()
	{
		imgName=new Array();
		if (!document.getElementsByTagName){ return; }
		var anchors = document.getElementsByTagName('a');
		var lastImg=null;
		// loop through all anchor tags
		for (var i=0; i<anchors.length; i++)
		{
			var anchor = anchors[i];
			
			var relAttribute = String(anchor.getAttribute('rel'));
			
			if (relAttribute.match('changeImg'))
			{
				var imggroudName=relAttribute.substring(relAttribute.indexOf('[', 0)+1,relAttribute.length-1);
				if (lastImg==null || imggroudName!=lastImg)
				{
					imgName[imgName.length]=new Array();
					imgName[imgName.length-1][0]=anchor.getAttribute('href');
					lastImg=imggroudName;
				}
				else
				{
					imgName[imgName.length-1][imgName[imgName.length-1].length]=anchor.getAttribute('href');
				}
				
			}
		}
	}
	