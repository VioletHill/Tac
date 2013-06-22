
var isTypeAnimate=false;

function showTypeItem()
{
	if (isTypeAnimate) return ;
   	isTypeAnimate=true;
   	$("#cataTypeLog").slideDown("medium");
}

function clearTypeItem()
{
	$("#cataTypeLog").slideUp("slow",function (){isTypeAnimate=false;});
}

function init()
{
   	$("#cataTypeDiv").mouseleave(function(){clearTypeItem();});
}