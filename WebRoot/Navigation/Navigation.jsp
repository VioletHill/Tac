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
              	<td><a class="tacnav" href="Home"><div><p>��ҳ</p></div></a></td>
              	<td><a class="tacnav" href="Document"><div><p>���Ͽ�</p></div></a></td>
             	<td><a class="tacnav" href="www.mark.com/tac/document.html"><div><p>����ǽ</p></div></a></td>
              	<td><a class="tacnav" href="Team"><div><p>�����</p></div></a></td>
            </tr>
        </table>
        </div>
      </div>
 </div>
 <div style="clear:both"></div>