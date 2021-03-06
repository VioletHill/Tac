<%@page import="com.sun.xml.internal.bind.v2.schemagen.xmlschema.Import"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

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


<link rel="stylesheet" type="text/css" href="TacDocument/Document.css">
<script src="jquery-1.9.1.js"></script>
<script src="TacDocument/Document.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="common/common.css" />
</head>

<body>

	<div
		style="top:0px; width:1200px;  margin-right: auto; margin-left: auto;">

		<%@include file="/Navigation/Navigation.jsp"%>


		<div id="searchDiv">
			<!-- 搜索栏 -->
			<form action="Document" method="post" id="searchForm">
				<input type="hidden" id="doneSomething" name="doneSomething"
					value="no" /> <input type="hidden" id="catalog" name="catalog"
					value="<%=DocumentData.getCatalog()%>" />
				<table>
					<tr>
						<td><input id="searchTF" type="text" name="search"
							value="<%=DocumentData.getSearch()%>" /></td>
						<td><div id="searchSltDiv">
								<input id="searchSlt"  type="button" 
									value="<%=DocumentData.getSelect()%>" style="text-align:left;"/>
								<div id="catalogDiv">
									<table style="margin-top:8px;" cellpadding="0px"
										cellspacing="0px" border="0">
										<tr style="padding:0px;margin:0px;">
											<td style="padding:0px;margin:0px;"><input
												class="searchSltBt" id="all" value="    所有"
												style="text-align:left;" type="button"
												onclick="clickSelectSearch(this)" />
											</td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" id="document" value="    文档"
														style="text-align:left;" type="button"
														onclick="clickSelectSearch(this)" />
												</div></td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" id="lib" value="    类库"
														style="text-align:left;" type="button"
														onclick="clickSelectSearch(this)" />
												</div></td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" id="sourceCode" value="    源码"
														style="text-align:left;" type="button"
														onclick="clickSelectSearch(this)" />
												</div></td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" id="software" value="    软件"
														style="text-align:left;" type="button"
														onclick="clickSelectSearch(this)" />
												</div></td>
										</tr>
										<tr>
											<td><div>
													<input class="searchSltBt" id="design" value="    设计"
														style="text-align:left;" type="button"
														onclick="clickSelectSearch(this)" />
												</div></td>
										</tr>

									</table>
								</div>
							</div>
						<td><input id="searchSb" type="submit" value=""
							onclick="clickSelectSearch(this)">
						</td>
					</tr>
				</table>
			</form>
			<!-- 搜索栏 -->
		</div>

		<!-- 左侧选择栏 -->
		<div id="cateDiv">
			<div id="cateBtDiv">
				<form action="Document" method="post" id="leftForm">
					<input type="hidden" id="doneSomething" name="doneSomething"
						value="no" /> <input type="hidden" id="catalog" name="catalog"
						value="all" />
					<table style="float:left;" cellpadding="0px" cellspacing="0px"
						border="0px">
						<tr>
							<td><div class="catalogLeft">
									<img src="TacDocument/images/category_all.png" id="catalogo">
									<input class="cateBt" id="all" type="button" value="所有"
										name="all" />
								</div></td>
						</tr>
						<tr>
							<td><div class="catalogLeft">
									<img src="TacDocument/images/category_document.png"
										id="catalogo"> <input class="cateBt" type="button"
										id="document" value="文档" name="document" />
								</div></td>
						</tr>
						<tr>
							<td><div class="catalogLeft">
									<img src="TacDocument/images/category_lib.png" id="catalogo">
									<input class="cateBt" id="lib" type="button" value="类库"
										name="lib" />
								</div></td>
						</tr>
						<tr>
							<td><div class="catalogLeft">
									<img src="TacDocument/images/category_sourceCode.png"
										id="catalogo"> <input class="cateBt" id="sourceCode"
										type="button" value="源码" name="sourceCode" />
								</div></td>
						</tr>
						<tr>
							<td><div class="catalogLeft">
									<img src="TacDocument/images/category_software.png"
										id="catalogo"> <input class="cateBt" id="software"
										type="button" value="软件" name="software" />
								</div></td>
						</tr>
						<tr>
							<td><div class="catalogLeft">
									<img src="TacDocument/images/category_design.png" id="catalogo">
									<input class="cateBt" id="design" type="button" value="设计"
										name="design" />
								</div></td>
						</tr>
					</table>
				</form>
			</div>
			<!-- 左侧选择栏 -->

			<div id="contentDiv">
				<!-- 条目 -->
				<div class="recordDiv">
					<table cellpadding="0px" cellspacing="0px" border="0px">
						<%
							for (int i = 0; i < DocumentData.getDataList().size(); i++) {
						%>
						<tr>
							<td>
								<div class="document">
									<table>
										<tr>
											<td>
												<%
													if (DocumentData.getCatalog(i).equals(
																DocumentData.CATALOG_DESIGN)) {
												%><img class="photo_cate" id="design_img"
												src="TacDocument/images/design.png" alt="design" /> <%
 	} else if (DocumentData.getCatalog(i).equals(
 				DocumentData.CATALOG_DOCUMENT)) {
 %><img class="photo_cate" id="document_img"
												src="TacDocument/images/document.png" alt="document" /> <%
 	} else if (DocumentData.getCatalog(i).equals(
 				DocumentData.CATALOG_LIB)) {
 %><img class="photo_cate" id="library_img"
												src="TacDocument/images/library.png" alt="library" /> <%
 	} else if (DocumentData.getCatalog(i).equals(
 				DocumentData.CATALOG_SOFTWARE)) {
 %><img class="photo_cate" id="software_img"
												src="TacDocument/images/software.png" alt="sorftware" /> <%
 	} else if (DocumentData.getCatalog(i).equals(
 				DocumentData.CATALOG_SOURCECODE)) {
 %><img class="photo_cate" id="soureCode_img"
												src="TacDocument/images/sourceCode.png" alt="sourceCode" />
												<%
													}
												%>
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
											<td><a class="download"
												href="TacDocument/download.jsp?filepath=/Tac/upload/&filename=<%=DocumentData.getFile(i)%>"><img
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
				<!-- 条目 -->

				<!--页号-->
				<div class="pages">
					<form action="Document" method="post" id="pageForm">
						<input type="hidden" id="doneSomething" name="doneSomething"
							value="no" /> <input type="hidden" id="catalog" name="catalog"
							value="all" /> <input type="hidden" id="pageIndex"
							name="pageIndex" value="1" />
						<div class="pageNum">
							<input type="hidden" id="pageIndexText"
								value="<%=DocumentData.getPageIndex()%>"> <a
								href="javascript:choosePage(1);" class="NoticesItem">首页</a> <a
								href="javascript:lastPage();" class="NoticesItem">上一页</a>
							<%
								for (int i = 1; i <= DocumentData.getCountOfPage(); i++) {
									if (i == DocumentData.getPageIndex()) {
							%>
							<a style="color:#adadad"><%=i%></a>
							<%
								} else {
							%>
							<a href="javascript:choosePage(<%=i%>);" class="NoticesItem"><%=i%></a>
							<%
								}
							%>
							<%
								}
							%>

							<a
								href="javascript:nextPage(<%=DocumentData.getCountOfPage()%>);"
								class="NoticesItem">下一页</a> <a
								href="javascript:choosePage(<%=DocumentData.getCountOfPage()%>);"
								class="NoticesItem">尾页</a>
						</div>
						<!-- 页号 -->
					</form>
				</div>
			</div>


		</div>
	</div>
	<%@include file="/Navigation/Footer.jsp"%>
</body>


</html>
