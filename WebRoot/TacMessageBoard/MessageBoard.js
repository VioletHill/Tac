$(document).ready(function() {
	
	
	var id = 9999999;
	
	function subfield() {
		var container = document.getElementById("collection");
		var leftContainer = document.getElementById("left");
		var rightContainer = document.getElementById("right");
		var containerArray = container.childNodes;
		while (containerArray.length != 0) {
			var blockid = $("#collection .block:first .id").text();
			blockid = Number(blockid);
			if ((blockid < id) && (blockid)) {
				id = blockid;
			}
			if (leftContainer.offsetHeight < rightContainer.offsetHeight) {
				leftContainer.appendChild(containerArray[0]);
			} else {
				rightContainer.appendChild(containerArray[0]);
			}
		}
	}
	
	subfield();
	
	
	function loadmore() {

		var xmlhttp;

		if (window.XMLHttpRequest) {
			xmlhttp = new XMLHttpRequest();
		} else {
			xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		}

		if (xmlhttp != null) {
			xmlhttp.open("POST", "servlet/LoadMore", true);
			xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded; charset=utf-8");
			xmlhttp.send("id=" + id);
			
			xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState==4 && xmlhttp.status==200) {
					document.getElementById("collection").innerHTML=xmlhttp.responseText;
					subfield();
			    }
			};
		} else {
			alert("Your browser does not support XMLHTTP.");
		}

	}
	
	$('#loadmore').click(loadmore);
	
	$(window).scroll(function() {
		   if($(window).scrollTop() + $(window).height() == $(document).height()) {
			   loadmore();
		   }
	});
	
	$('#publishCount').text($('#publishContent').val().length);
	
	$('#publishBlock').hide();
	
	var clickflag = false;
	$('#addNoteBlock').click(function() {
		if (clickflag) 
			return;
		$('#addNoteBlock').css("background-position", "-800px 0px");
		$('#publishBlock').show();
		$('#publishBlock #publishContent').focus();
		clickflag = true;
		return;
	});
	
	$('#publishContent').keypress(function() {
		$('#publishCount').text($('#publishContent').val().length);
	});
	
	$('#publishContent').keydown(function() {
		$('#publishCount').text($('#publishContent').val().length);
	});
	
	$('#publishContent').keyup(function() {
		$('#publishCount').text($('#publishContent').val().length);
	});
	
	$('#submitButton').click(function() {
		if (!$('#publishContent').val()) {
			$('#publishContent').focus();
			return false;
		} else {
			return true;
		}
	});
});