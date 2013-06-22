
var last;
var indexNow;
function showNotice(index)
{
	var indexNotices=parseInt(index.name);
	
	$.post("Notices/ShowNotices",{indexNotices:indexNotices }, function(msg)
			{
				document.getElementById("notice").innerHTML=msg;
				$(last).rotate({ animateTo:0});
				$(index).rotate({ animateTo:90}); 
				last=index;
				indexNow=indexNotices;
			});
}

function selectNotice()
{
	window.location.href="Notices/NoticesPage?indexNotices="+indexNow;
}
