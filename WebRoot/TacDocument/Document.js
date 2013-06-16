/**
 * 
 */

var searchKey;
var catalog;
var isUp = true;
var isDown = false;
// JavaScript Document
$(document)
		.ready(
				function() {
					$(".download").hide();
					$(".document")
							.hover(
									function() {
										// һ��Ҫ�Ľ���δ��룡@Mark
										$(
												this.lastElementChild.lastElementChild.lastElementChild.lastElementChild.lastElementChild)
												.show();
										// alert($(this.firstElementChild.firstElementChild.firstElementChild.firstElementChild.firstElementChild).nodeType);
										var theElem = $(this.firstElementChild.firstElementChild.firstElementChild.firstElementChild.firstElementChild);
										var theId = theElem.attr("id");
										if (theId == "design_img") {
											theElem
													.attr("src",
															"TacDocument/images/design_onSelect.png");
										} else if (theId == "document_img") {
											theElem
													.attr("src",
															"TacDocument/images/document_onSelect.png");
										} else if (theId == "library_img") {
											theElem
													.attr("src",
															"TacDocument/images/library_onSelect.png");
										} else if (theId == "software_img") {
											theElem
													.attr("src",
															"TacDocument/images/software_onSelect.png");
										} else if (theId == "soureCode_img") {
											theElem
													.attr("src",
															"TacDocument/images/sourceCode_onSelect.png");
										}
										// alert($(this).contents().filter(function()
										// {
										// return $(this).attr("class") ==
										// "photo_cate";
										// }).attr("id"));
									});
					$(".document")
							.mouseleave(
									function() {
										$(
												this.lastElementChild.lastElementChild.lastElementChild.lastElementChild.lastElementChild)
												.hide();
										var theElem = $(this.firstElementChild.firstElementChild.firstElementChild.firstElementChild.firstElementChild);
										var theId = theElem.attr("id");
										if (theId == "design_img") {
											theElem
													.attr("src",
															"TacDocument/images/design.png");
										} else if (theId == "document_img") {
											theElem
													.attr("src",
															"TacDocument/images/document.png");
										} else if (theId == "library_img") {
											theElem
													.attr("src",
															"TacDocument/images/library.png");
										} else if (theId == "software_img") {
											theElem
													.attr("src",
															"TacDocument/images/software.png");
										} else if (theId == "soureCode_img") {
											theElem
													.attr("src",
															"TacDocument/images/sourceCode.png");
										}
									});
					$(".cateBt")
							.hover(
									function() {
										$(this)
												.css("background-image",
														"url(TacDocument/images/category_hover.png)");
									});
					$(".cateBt").mouseleave(function() {
						$(this).css("background-image", "none");
					});
					$("#searchTF").focus(function() {
						if (this.value == "������Դ")
							this.value = "";
					});
					$("#searchTF").blur(function() {
						if (this.value == "")
							this.value = "������Դ";
					});
					$("#searchSlt").click(function() {
						if (isDown) {
							$("#catalogDiv").mouseleave();
							return;
						}
						$("#catalogDiv").slideDown("medium");
						isDown = true;
						isUp = false;
						// isAnimate = false;
					});
					$("#searchSltDiv").mouseleave(function() {
						if (isUp)
							return;
						// isAnimate = true;

						$("#catalogDiv").slideUp("slow");
						isUp = true;
						isDown = false;
					});
					$(".searchSltBt")
							.hover(
									function() {
										$(this)
												.css("background-image",
														"url(TacDocument/images/SelectHover.png)");
									});
					$(".searchSltBt").mouseleave(function() {
						$(this).css("background-image", "none");
					});

					// �������ť��Ӧ���
					$(".cateBt").click(function(){
						clickSelectSearch(this);
					});
				});

// �˺���Ϊ������ѡ�������Ӧ����¼� ���������
function clickSelectSearch(ele) {
	keepSearchContent();
//	alert(ele.id);
	switch (ele.id) {
	case "all":
		document.getElementById("catalog").value = "all";
		catalog = "all";
		break;
	case "document":
		document.getElementById("catalog").value = "document";
		catalog = "document";
		break;
	case "sourceCode":
		document.getElementById("catalog").value = "sourceCode";
		catalog = "sourceCode";
		break;
	case "lib":
		document.getElementById("catalog").value = "lib";
		catalog = "lib";
		break;
	case "software":
		document.getElementById("catalog").value = "software";
		catalog = "software";
		break;
	case "design":
		document.getElementById("catalog").value = "design";
		catalog = "design";
		break;
	default:
		document.getElementById("catalog").value = "all";
		catalog = "all";
	}
	makeSomeNoise();
	rewriteSearchContent();
	document.getElementById("searchSlt").value = ele.value;
	document.getElementById("searchForm").submit();
//	alert(searchKey);

	// clearItem();
//	rewriteSearchContent();
}

function makeSomeNoise() {
	document.getElementById("doneSomething").value = "yes";
}

function keepSearchContent() {
	searchKey = document.getElementById("searchTF").value;
}

function rewriteSearchContent() {
//	alert(searchKey);
	document.getElementById("searchTF").value = searchKey;
}

/*
 * ����Ϊҳ�洦����
 */
function choosePage(index) {
	// ��������µ����� ��ԭ������������
	document.getElementById("searchTF").value = searchKey;
	// checkSearchIsNull();
	document.getElementById("pageIndex").value = index;
	document.getElementById("pageForm").submit();
}

function nextPage(totPage) {
	var index = parseInt(document.getElementById("pageIndexText").value) + 1;
	if (index > totPage) {
		alert("�ף��Ѿ����һҳ��~~");
		return;
	}
	choosePage(index);
}
function lastPage() {
	var index = parseInt(document.getElementById("pageIndexText").value) - 1;
	if (index <= 0) {
		alert("�ף��Ѿ���һҳ��~~");
		return;
	}
	choosePage(index);
}


/*
 * ҳ���ʼ��
 */
function init() {
	searchKey = document.getElementById("searchTF").value;
}
