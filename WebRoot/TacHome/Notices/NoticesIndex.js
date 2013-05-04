
var last;
function showNotice(index)
{
	var xmlhttp;
	var indexNotices=parseInt(index.name);
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
	$(last).rotate({ animateTo:0});
	$(index).rotate({ animateTo:90}); 
	last=index;
}

function test()
{
	alert("a");
}
