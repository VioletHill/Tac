/**
 * 
 */
var isUp = true;
var isDown = false;
// JavaScript Document
$(document).ready(function() {
	$(".download").hide();
	$(".document").hover(function() {
		$(this.lastElementChild.lastElementChild.lastElementChild.lastElementChild.lastElementChild).show();
	});
	$(".document").mouseleave(function() {
		$(this.lastElementChild.lastElementChild.lastElementChild.lastElementChild.lastElementChild).hide();
	});
	$(".cateBt").hover(function() {
		$(this).css("background-image", "url(TacDocument/images/category_hover.png)");
	});
	$(".cateBt").mouseleave(function() {
		$(this).css("background-image", "none");
	});
	$("#searchTF").focus(function(){
		if (this.value=="搜索资源") this.value = "";
	});
	$("#searchTF").blur(function(){
		if (this.value=="") this.value = "搜索资源";
	});
	$("#searchSlt").click(function(){
		if (isDown) {
			$("#catalogDiv").mouseleave();
			return;
		}
		$("#catalogDiv").slideDown("medium");
		isDown = true;
		isUp = false;
//		isAnimate = false;
	});
	$("#searchSltDiv").mouseleave(function(){
		if (isUp) return;
		//isAnimate = true;
		
		$("#catalogDiv").slideUp("slow");
		isUp = true;
		isDown = false;
	});
	$(".searchSltBt").hover(function() {
		$(this).css("background-image", "url(TacDocument/images/SelectHover.png)");
	});
	$(".searchSltBt").mouseleave(function() {
		$(this).css("background-image", "none");
	});
});