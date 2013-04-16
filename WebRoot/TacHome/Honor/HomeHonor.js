var position=0;
var isMoveDone=true;
function lastShowTime(pro)
{
	if (!isMoveDone) return ;
	if (position==-(pro.id-1)*300) return ;
	isMoveDone=false;
	position=position-300;
	$(".showTimeImage").animate({left:position},function(){isMoveDone=true;});
}

function nextShowTime(pro)
{
	if (!isMoveDone) return ;
	if (position==600) return ;
	isMoveDone=false;
	position=position+300;
	$(".showTimeImage").animate({left:position},function(){isMoveDone=true;});
}