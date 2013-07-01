var search;

function showTime() {
	var now = new Date;
	var day = null;

	if (now.getDay() == 1)
		day = "һ";
	else if (now.getDay() == 2)
		day = "��";
	else if (now.getDay() == 3)
		day = "��";
	else if (now.getDay() == 4)
		day = "��";
	else if (now.getDay() == 5)
		day = "��";
	else if (now.getDay() == 6)
		day = "��";
	else if (now.getDay() == 0)
		day = "��";


	document.getElementById("time").innerHTML = now.getFullYear() + "-"
			+ (now.getMonth() + 1) + "-" + now.getDate()  +  '<span style="margin-left:13">'+ "����"
			+ day+"</span>";
	setTimeout("showTime()", "1000");
}

function focusSearch(element) {
	// element.style.opacity=1;
	if (element.value == "������Ϣ")
		element.value = "";
}

function blurSearch(element) {
	// element.style.opacity=0.2;
	if (element.value == "")
		element.value = "������Ϣ";
}

var today = null;
var week = null;
var month = null;
var all = null;
var isAnimate = false;

function clickItem(ele) {
	switch (ele.id) {
	case "weekTime":
		document.getElementById("searchTime").value = "week";
		document.getElementById("noticeTime").value = "����";
		break;
	case "monthTime":
		document.getElementById("searchTime").value = "month";
		document.getElementById("noticeTime").value = "����";
		break;
	case "todayTime":
		document.getElementById("searchTime").value = "today";
		document.getElementById("noticeTime").value = "����";
		break;
	default:
		document.getElementById("searchTime").value = "all";
		document.getElementById("noticeTime").value = "ȫ��";
	}
	setIsSearch();
	document.getElementById("form").submit();
	clearItem();
}

function enterItem(ele) {
	switch (ele.id) {
	case "todayTime":
		ele.style.backgroundImage = 'url(TacNotices/Image/SelectHover_Top.png)';
		break;
	case "allTime":
		ele.style.backgroundImage = 'url(TacNotices/Image/SelectHover_Bottom.png)';
		break;
	default:
		ele.style.backgroundImage = 'url(TacNotices/Image/SelectHover_Mid.png)';
	}

}

function outItem(ele) {
	ele.style.backgroundImage = 'none';
}

function clearItem() {
	$("#catalog").slideUp("slow", function() {
		isAnimate = false;
	});
}

function showItem() {
	if (isAnimate)
		return;
	isAnimate = true;
	$("#catalog").slideDown("medium");
}

function changeItemState() {
	if (isAnimate)
		clearItem();
	else
		showItem();
}

function getAbsoluteX(e) {
	return e.getBoundingClientRect().left + document.body.scrollLeft;

}

function getAbsoluteY(e) {
	return e.getBoundingClientRect().top + document.body.scrollTop;
}

function choosePage(index) {
	// ��������µ����� ��ԭ������������
	document.getElementById("search").value = search;
	checkSearchIsNull();

	document.getElementById("pageIndex").value = index;
	document.getElementById("form").submit();
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

function setIsSearch() {
	checkSearchIsNull();
	document.getElementById("isSearch").value = "yes";
}

function checkSearchIsNull() {
	if (document.getElementById("search").value == "������Ϣ") {
		document.getElementById("search").value = "";
	}
}

function init() {
	search = document.getElementById("search").value;
	$("#cataDiv").mouseleave(function() {
		clearItem();
	});
}
