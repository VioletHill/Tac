<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<title>颜色选择器</title>
</head>
<body>
	
	<p>
		<input type="text" name="color" id="color" onclick="coloropen(event)" />
	</p>
	<p></p>
	<p></p>
	<p>
		<input type="button" value="颜色选择" onclick="coloropen(event)"
			id="inputcolor" />
	</p>
	<p></p>
	<div id="colorpane" style="position:absolute;z-index:999;display:none;"></div>
</body>
</html>
