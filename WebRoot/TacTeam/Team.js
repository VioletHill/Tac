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

var isInterestedSend=false;
function changeInterested(obj,id)
{
	if (isInterestedSend) return ;
	isInterestedSend=true;
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
	  xmlhttp=new XMLHttpRequest();
	}
	else
	{
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("POST", "Team/Interested?isInterested="+obj.name+"&id="+id, false);
	xmlhttp.send();
	if (obj.name=="interested")
	{
		
		if (xmlhttp.responseText)
		{
			document.getElementById('interestedCount'+id).innerHTML=xmlhttp.responseText;
			obj.src="TacTeam/Image/uninterested.png";
			obj.name="uninterested";
		}
	}
	else
	{
		if (xmlhttp.responseText)
		{
			document.getElementById('interestedCount'+id).innerHTML=xmlhttp.responseText;
			obj.src="TacTeam/Image/interested.png";
			obj.name="interested";
		}
	}
	isInterestedSend=false;
}


var isJoin=false;
function changeWanntIn(obj,id,divId,headAdd)
{
	if (isJoin) return ;
	isJoin=true;
	var xmlhttp;
	if (window.XMLHttpRequest)
	{
	  xmlhttp=new XMLHttpRequest();
	}
	else
	{
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("POST", "Team/WantIn?isWant="+obj.name+"&id="+id, false);
	xmlhttp.send();
	
	if (obj.name=="in")
	{
		if (xmlhttp.responseText=="success")
		{
			obj.src="TacTeam/Image/iwantin.png";
			var child=document.getElementById(divId);
			document.getElementById("waitUserDiv"+id).removeChild(child);
			obj.name="not";
		}
	}
	else
	{
		if (xmlhttp.responseText=="success")
		{
			obj.src="TacTeam/Image/iamin.png";
			obj.name="in";
			
//			<div class="waitDiv" id="<%=waitId%>">
//				<div class="headDiv">
//					<img src=<%=allTeam.getAllTeams().get(i).getWaitUsers().get(j).getHeader_add()%>>
//				</div>
//			</div>
			
			var waitDiv=document.createElement("div");
			waitDiv.setAttribute("class","waitDiv");
			waitDiv.setAttribute("id",divId);
			var headDiv=document.createElement("div");
			headDiv.setAttribute("class","headDiv");
			waitDiv.appendChild(headDiv);
			var headImg=document.createElement("img");
			headImg.setAttribute("src", headAdd);
			headDiv.appendChild(headImg);
			document.getElementById("waitUserDiv"+id).appendChild(waitDiv);
		}
	}
	isJoin=false;
}


function showInfor(joinUserId)
{
	if (document.getElementById(joinUserId).style.display=="none")
	{
		$('#'+joinUserId).fadeIn();
	}
	else
	{
		$('#'+joinUserId).fadeOut();
		document.getElementById(joinUserId).style.display="none";
	}
}



   		