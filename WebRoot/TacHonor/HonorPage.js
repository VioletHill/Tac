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