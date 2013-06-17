var isPeopleAnimate=false;
var isTypeAnimate=false;

function showPeopleItem()
{
   	if (isPeopleAnimate) return ;
   	isPeopleAnimate=true;
   	$("#cataPeopleLog").slideDown("medium");
}
   	
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

function clearPeopleItem()
{
	$("#cataPeopleLog").slideUp("slow",function (){isPeopleAnimate=false;});
}


function changePeopleState()
{
 	 if (isPeopleAnimate) clearPeopleItem();
 	else showPeopleItem();   		
}

function changeTypeState()
{
	 if (isTypeAnimate) clearTypeItem();
	 else showTypeItem();  
}

function getAbsoluteX(e)
{
   	return e.getBoundingClientRect().left+document.body.scrollLeft;
}
   		
function getAbsoluteY(e)
{
 	return e.getBoundingClientRect().top+document.body.scrollTop;
}


var lastMonth=0;
var lastDay=0;
function addDate()
{
	alert("a");
	if (lastMonth!=month || lastDay!=day)
	{
		lastMonth=month;
		lastDay=day;
		var newDiv=document.createElement("div");
		newDiv.setAttribute("style","background-color:red; width:50; height:40;");
		document.getElementById("contentDiv").appendChild(newDiv);
		
		var x=getAbsoluteX(headImg)-getAbsoluteX(newDiv);
		var y=getAbsoluteY(headImg)-getAbsoluteY(newDiv);
	
		newDiv.setAttribute("style","background-color:red; width:50; height:40; position:relative; left:"+x+"; top:"+y);
	
		var newMonthDiv=document.createElement("div");
		newDiv.appendChild(newMonthDiv);
	
		var newMonth=document.createElement("img");
		newMonth.setAttribute("src","ab");
		newMonthDiv.appendChild(newMonth);
		
		var newDayDiv=document.createElement("div");
		newDiv.appendChild(newDayDiv);
		
		var newDay=document.createElement("img");
		newDay.setAttribute("src","ab");
		newDayDiv.appendChild(newDay);
	}
}

function init()
{
   	$("#cataPeopleDiv").mouseleave(function(){clearPeopleItem();});
   	$("#cataTypeDiv").mouseleave(function(){clearTypeItem();});
}


function changeLike(obj)
{
	if (obj.name=="like")
	{
		obj.name="dislike";
		obj.src="TacTeam/Image/dislike.png";
	}
	else
	{
		obj.name="like";
		obj.src="TacTeam/Image/like.png";
	}
}



   		