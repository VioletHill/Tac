
<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>

<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<jsp:useBean id="DocumentData" class="DataSource.Document.DocumentData"
	scope="request">
</jsp:useBean>
<head>

<base href="<%=basePath%>">

<title>Tac������</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" type="text/css" href="TacDocument/Document.css">
<script src="jquery-1.9.1.js"></script>
<script src="TacDocument/Document.js" type="text/javascript"></script>
</head>

<body>

	<div style="top:0; width:1200;  margin-right: auto; margin-left: auto;">
		<%@include file="/Navigation/Navigation.jsp"%>

		<div id="searchDiv">
			<form action="" method="get">
				<table>
					<tr>
						<td><input id="searchTF" type="text" name="search"
							value="������Դ" /></td>
						<td><div id="searchSltDiv">
								<input id="searchSlt" type="button" value="  ����">
								<div id="catalogDiv">
									<table style="margin-top:8px;" cellpadding="0" cellspacing="0"
										border="0">
										<tr style="padding:0px;margin:0px;">
											<td style="padding:0px;margin:0px;"><input
												class="searchSltBt" value="  ����" style="text-align=left;"
												type="button">
											</td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" value="  �ĵ�"
														style="text-align=left;" type="button">
												</div></td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" value="  ���"
														style="text-align=left;" type="button">
												</div></td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" value="  Դ��"
														style="text-align=left;" type="button">
												</div></td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" value="  ���"
														style="text-align=left;" type="button">
												</div></td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" value="  ���"
														style="text-align=left;" type="button">
												</div></td>
										</tr>

									</table>
								</div>
							</div>
						<td><input id="searchSb" type="submit" value="">
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="cateDiv">
			<div id="cateBtDiv">
				<table style="float:left;" cellpadding="0" cellspacing="0"
					border="0">
					<tr>
						<td><div class="catalogLeft">
								<img src="TacDocument/images/category_all.png" id="catalogo">
								<input class="cateBt" type="button" value="����" />
							</div></td>
					</tr>
					<tr>
						<td><div class="catalogLeft">
								<img src="TacDocument/images/category_document.png" id="catalogo">
								<input class="cateBt" type="button" value="�ĵ�" />
							</div></td>
					</tr>
					<tr>
						<td><div class="catalogLeft">
								<img src="TacDocument/images/category_lib.png" id="catalogo">
								<input class="cateBt" type="button" value="���" />
							</div></td>
					</tr>
					<tr>
						<td><div class="catalogLeft">
								<img src="TacDocument/images/category_sourceCode.png" id="catalogo">
								<input class="cateBt" type="button" value="Դ��" />
							</div></td>
					</tr>
					<tr>
						<td><div class="catalogLeft">
								<img src="TacDocument/images/category_software.png" id="catalogo">
								<input class="cateBt" type="button" value="���" />
							</div></td>
					</tr>
					<tr>
						<td><div class="catalogLeft">
								<img src="TacDocument/images/category_design.png" id="catalogo">
								<input class="cateBt" type="button" value="���" />
							</div></td>
					</tr>
				</table>

			</div>

			<div id="contentDiv" >
				<table cellpadding="0" cellspacing="0"
					border="0">
					<%
						for (int i = 0; i < DocumentData.getDataList().size(); i++) {
					%>
					<tr>
						<td>
							<div class="document">
								<table>
									<tr>
										<td><img id="photo_cate"
											src="TacDocument/images/design.png" alt="design">
										</td>
										<td>
											<div>
												<table width="600px">
													<tr>
														<td><p class="title">
																<%=DocumentData.getTitle(i) + "-"
						+ DocumentData.getDate(i)%>
															</p></td>
													</tr>
													<tr>
														<td><p class="detail">
																<%=DocumentData.getContent(i)%>
															</p></td>
													</tr>
												</table>
											</div></td>
										<td><a class="download" href="w3schools.com"><img
												src="TacDocument/images/active_down.png" width="30px"
												alt="download"> </a></td>
									</tr>
								</table>
							</div>
						</td>
					</tr>
					<%
						}
					%>


				</table>
			</div>
			<%@include file="/Navigation/Footer.jsp"%>
		</div>
	</div>
</body>


</html>
