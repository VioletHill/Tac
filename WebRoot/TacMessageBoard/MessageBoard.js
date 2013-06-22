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
	
	$('#addNoteBlock').click(function() {
		$('#addNoteBlock').css("background-position", "-800px 0px");
		return;
	});
});