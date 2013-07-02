var indexWheel=0;
var isMove=false;

function setImage()
{
	var wheelPosition=-indexWheel*(61+document.getElementsByClassName("ImageView")[0].width);
	$(".ImageViewContainer").animate({left:wheelPosition},function (){isMove=false;});
}

function nextView(totImage)
{
	totImage=parseInt(totImage);
	if (indexWheel<=0) return ;
	if (isMove) return ;
	isMove=true;
	indexWheel--;
	setImage();
}

function preView(totImage)
{
	totImage=parseInt(totImage);
	if (indexWheel>=totImage-4) return ;
	if (isMove) return ;
	isMove=true;
	indexWheel++;
	setImage();
}




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
function setIndexChangeImg(pro)
{
	x=event.clientX;
	y=event.clientY;
	pro.src=imgName[imgId][indexImg];
}
function moveNextImg(pro)
{
	indexImg=(indexImg+1)%imgName[imgId].length;
	setIndexChangeImg(pro);
}

function moveLastImg(pro)
{
	indexImg=(indexImg-1+imgName[imgId].length)%imgName[imgId].length;
	setIndexChangeImg(pro);
}

function leaveImg(pro)
{
	indexImg=0;
	setIndexChangeImg(pro);
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
