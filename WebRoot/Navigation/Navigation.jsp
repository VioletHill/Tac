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
              	<td><a class="tacnav" href="Home"><div><p>��ҳ</p></div></a></td>
              	<td><a class="tacnav" href="Document"><div><p>���Ͽ�</p></div></a></td>
             	<td><a class="tacnav" href="MessageBoard"><div><p>����ǽ</p></div></a></td>
              	<td><a class="tacnav" href="Team"><div><p>�����</p></div></a></td>
            </tr>
        </table>
        </div>
      </div>
 </div>
 <div style="clear:both"></div>
 <!-- end /Navigation/Navigation.jsp -->
