<head>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<meta http-equiv="content-type" content="text/html; charset=GB18030">
</head>


<p>
	<script type="text/javascript">
		var ColorHex = new Array('00', '33', '66', '99', 'CC', 'FF');		// 颜色横向变化幅度
		var SpColorHex = new Array('FF0000', '00FF00', '0000FF', 'FFFF00','00FFFF', 'FF00FF');// 纵向变化幅度
		var defaultColor = "#000000";
		function initcolor(evt) 
		{
			var colorTable = '';
			for ( var i = 0; i < 2; i++) 
			{
				for ( var j = 0; j < 6; j++) 
				{
					colorTable = colorTable + '<tr height=15>'; 
					for ( var k = 0; k < 3; k++) 
					{
						for ( var l = 0; l < 6; l++) 
						{
							colorTable = colorTable
									+ '<td width=15; style="cursor:pointer; background-color:#'
									+ ColorHex[k + i * 3] + ColorHex[l]
									+ ColorHex[j] + '" onclick="doclick(\'#'
									+  ColorHex[k + i * 3] + ColorHex[l]
									+ ColorHex[j]+ '\')">';
						}
					}  
				
				}
			}
			
			colorTable = '<table border="1" cellspacing="0" cellpadding="0" style="text-align:center; border-collapse:collapse; "  bordercolor="000000">'
					+ '<tr><td id="selectColor" colspan=17><span  style="cursor:pointer;" onclick="selectdefaultcolor() ">默认颜色</span></td> <td><span style="cursor:pointer;" onclick="colorclose()">×</span></td><tr>'
					+ colorTable + '</table>';
			document.getElementById("colorpane").innerHTML = colorTable;
		}
		
		function doclick(colorValue) 
		{
			defaultColor=colorValue;
			document.getElementById("selectColor").style.backgroundColor=colorValue;
			chat_content.document.execCommand("ForeColor", false,  colorValue);
			colorclose();
		}
		function selectdefaultcolor() 
		{
			doclick(defaultColor);
			colorclose();
		}
		function colorclose() 
		{
			document.getElementById("colorpane").style.display = "none"; 
		}
		function coloropen() {
			document.getElementById("colorpane").style.display = "";
		}
		window.onload = initcolor;
	</script>
</p>