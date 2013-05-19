
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

<title>Tac资料室</title>

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
							value="搜索资源" />
						</td>
						<td><div id="cataDiv">
								<input id="searchSlt" type="button" value="  分类">
								<div id="catalog"
									style="position:absolute;z-index:3;width:163px;height:314px;repeat:no;display:none;background-image:url(TacDocument/images/searchSelectPanel.png);">
									<table>
										<tr>
											<td>Hello</td>
											<td>Hello</td>
											<td>Hello</td>
											<td>Hello</td>
										</tr>
										<tr>
											<td>Hello</td>
											<td>Hello</td>
											<td>Hello</td>
											<td>Hello</td>

										</tr>
										<tr>
											<td>Hello</td>
											<td>Hello</td>
											<td>Hello</td>
											<td>Hello</td>

										</tr>

										<tr>
											<td>Hello</td>
											<td>Hello</td>
											<td>Hello</td>
											<td>Hello</td>

										</tr>
									</table>
								</div>
							</div>
						<td><input id="searchSb" type="submit" value=""></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="cateDiv">
			<div id="cateBtDiv">
				<table style="float:left;">
					<tr>
						<td><input class="cateBt" type="button" value="所有" />
						</td>
					</tr>
					<tr>
						<td><input class="cateBt" type="button" value="所有" />
						</td>
					</tr>
					<tr>
						<td><input class="cateBt" type="button" value="所有" />
						</td>
					</tr>
					<tr>
						<td><input class="cateBt" type="button" value="所有" />
						</td>
					</tr>
					<tr>
						<td><input class="cateBt" type="button" value="所有" />
						</td>
					</tr>
					<tr>
						<td><input class="cateBt" type="button" value="所有" />
						</td>
					</tr>
				</table>

			</div>

			<div id="contentDiv">
				<table>
					<%
						for (int i = 0; i < DocumentData.getDataList().size(); i++) {
					%>
					<tr>
						<td>
							<div class="document">
								<table>
									<tr>
										<td><img id="photo_cate"
											src="TacDocument/images/design.png" alt="design"></td>
										<td>
											<div>
												<table width="600px">
													<tr>
														<td><p class="title">
																<%=DocumentData.getTitle(i)%>
															</p>
														</td>
													</tr>
													<tr>
														<td><p class="detail">
																<%=DocumentData.getContent(i)%>
															</p>
														</td>
													</tr>
												</table>
											</div>
										</td>
										<td><a class="download" href="w3schools.com"><img
												src="TacDocument/images/active_down.png" width="30px"
												alt="download"> </a>
										</td>
									</tr>
								</table>
							</div></td>
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
