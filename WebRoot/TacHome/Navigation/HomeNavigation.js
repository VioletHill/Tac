/////////////////////////////////////
/////////////µ¼º½À¸
	var indexImg=0;
    var totImg=4;
    var imageWidth=614;
    var isMove=false;
    function setIndexImg(index)
    {
    	if (isMove==true) return ;
    	isMove=true;
    	indexImg=index;
    	var wheelPosition=imageWidth*indexImg;
    	$(".ImageWheel").animate({left:-wheelPosition},function(){moveDone();});
    	document.getElementById("page0").src="TacHome/Image/ImagePage.png";
    	document.getElementById("page1").src="TacHome/Image/ImagePage.png";
    	document.getElementById("page2").src="TacHome/Image/ImagePage.png";
    	document.getElementById("page3").src="TacHome/Image/ImagePage.png";
    	document.getElementById("page"+indexImg).src="TacHome/Image/ImagePageSelect.png";
    }
    
    function nextImg()
    {
 		if (isMove==true) return ;
    	indexImg=(indexImg+1)%totImg;
    	setIndexImg(indexImg); 	
    }
    
    function lastImg()
    {
  		if (isMove==true) return ;
    	indexImg=(indexImg+totImg-1)%totImg;
    	setIndexImg(indexImg);
    }
    
    var timer;
    function moveDone()
    {
    	clearTimeout(timer);
    	timer=setTimeout(function(){nextImg();},2500);
   	  	isMove=false;
    }
    function init() 
    {
    	setIndexImg(0);
	}
	
	$(document).ready(function(){
		var div = document.getElementsByClassName('imageWheel')[0];		
		for (var i = 0; i != div.childNodes.length; i++)
			if (div.childNodes[i].nodeType == 3){
				div.removeChild(div.childNodes[i]);
				i--;
			}
	
	});
	
	

	