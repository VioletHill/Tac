<%@ page language="java" import="java.util.*"   pageEncoding="GB18030"%>

<!-- include /Navigation/Navigation.jsp -->
<style >
	 <%@include file="/Navigation/Navigation.css" %>
</style>

<div id="top">
      <div id="topBG">
        <div id="tacnav">
          <table style="height:65; width:600;cellpadding:0 cellspacing:0; border:0"> 
            <tr>
            	<%if (session.getAttribute("isLog")==null || session.getAttribute("isLog").equals("false"))
            	{%>
               <%}
               else
               {%>
               		<td><div class="headDiv"><img src="<%=session.getAttribute("headAdd")%>"></div></td>
               <%}%>
              	<td><a class="tacnav" href="Home"><div><p>首页</p></div></a></td>
              	<td><a class="tacnav" href="Document"><div><p>资料库</p></div></a></td>
             	<td><a class="tacnav" href="MessageBoard"><div><p>留言墙</p></div></a></td>
              	<td><a class="tacnav" href="Team"><div><p>求包养</p></div></a></td>
            </tr>
        </table>
        </div>
      </div>
 </div>
 <div style="clear:both"></div>
 <!-- end /Navigation/Navigation.jsp -->
