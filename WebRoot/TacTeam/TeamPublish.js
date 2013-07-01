
var isTypeAnimate=false;

function showTypeItem()
{
	if (isTypeAnimate) return ;
   	isTypeAnimate=true;
   	$("#cataTypeLog").slideDown("medium");
}

function clearTypeItem()
{
	alert("a");
	$("#cataTypeLog").slideUp("slow",function (){isTypeAnimate=false;});
}

function init()
{
   	$("#cataTypeDiv").mouseleave(function(){clearTypeItem();});
}

function getStrActualLen(sChars)
{
	return sChars.replace(/[^\x00-\xff]/g,"xx").length;
}

var lastContent;
function checkContentNumber()
{
	var content=document.getElementById("content").value;
	var remain=280-getStrActualLen(content);
	if (remain<0) remain=0;
	if (remain==0)
	{
		document.getElementById("content").value=lastContent;
	}
	else 
	{
		lastContent=content;
	}
	document.getElementById("contentNumber").innerHTML=parseInt(remain/2);
}


function checkTeamPublish()
{
	if (document.getElementById("title").value=="")
	{
		alert("标题不得为空");
		return false;
	}
	if (document.getElementById("content")=="")
	{
		alert("内容不得为空");
		return false;
	}
	return true;
}

