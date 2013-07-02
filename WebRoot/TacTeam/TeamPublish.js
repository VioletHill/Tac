
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

function changeType(val)
{

	if (val=="0")
	{
		document.getElementById("teamType").value="  创意";
	}
	else
	{
		document.getElementById("teamType").value="  招募";
	}
	document.getElementById("publishType").value=val;
	clearTypeItem();
}

function enterTypeItem(ele) {
	switch (ele.id) {
	case "create":
		ele.style.backgroundImage = 'url(TacTeam/Image/publish/new_top_hover.png)';
		break;
	case "enlist":
		ele.style.backgroundImage = 'url(TacTeam/Image/publish/new_bottom_hover.png)';
		break;
	}

}

function outTypeItem(ele) {
	ele.style.backgroundImage = 'none';
}


