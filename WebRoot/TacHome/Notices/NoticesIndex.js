
function showNotice(index)
{
	var xmlhttp;
	var indexNotices=parseInt(index.id);
	if (window.XMLHttpRequest)
	{// code for IE7+, Firefox, Chrome, Opera, Safari
	  xmlhttp=new XMLHttpRequest();
	}
	else
	{// code for IE6, IE5
	  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
	}
	xmlhttp.open("POST", "http://localhost:8080/Tac/Notices/ShowNotices?indexNotices="+indexNotices, false);
	xmlhttp.send();
	document.getElementById("notice").innerHTML=xmlhttp.responseText;
}

function showFirstNotices(index)
{
	alert("a");
	//showNotice(document.getElementById(index));
}
