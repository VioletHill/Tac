<%@ page language="java" import="java.util.*"   pageEncoding="GB18030"%>

<style >
	 <%@include file="/Navigation/Navigation.css" %>
</style>

<div id="top">
      <div id="topBG">
        <div id="tacnav">
          <table style="height:100; width:600; "> 
            <tr>
            	<%if (session.getAttribute("isLog")==null || session.getAttribute("isLog").equals("false"))
            	{
            		System.out.println(session.getAttribute("isLog"));%>
               <%}
               else
               {%>
               		<td><img src="<%=session.getAttribute("headAdd")%>"></td>
               <%}%>
              	<td><a class="tacnav" href="Home"><div><p>首页</p></div></a></td>
              	<td><a class="tacnav" href="Document"><div><p>资料库</p></div></a></td>
             	<td><a class="tacnav" href="www.mark.com/tac/document.html"><div><p>留言墙</p></div></a></td>
              	<td><a class="tacnav" href="Team"><div><p>求包养</p></div></a></td>
            </tr>
        </table>
        </div>
      </div>
 </div>
 <div style="clear:both"></div>