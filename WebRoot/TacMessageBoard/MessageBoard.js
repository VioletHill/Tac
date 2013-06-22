$(document).ready(function() {
	var container = document.getElementById("collection");
	var leftContainer = document.getElementById("left");
	var rightContainer = document.getElementById("right");
	var containerArray = container.childNodes;
	
	while (containerArray.length != 0) {
		if (leftContainer.offsetHeight < rightContainer.offsetHeight) {
			leftContainer.appendChild(containerArray[0]);
		} else {
			rightContainer.appendChild(containerArray[0]);
		}
	}
	
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