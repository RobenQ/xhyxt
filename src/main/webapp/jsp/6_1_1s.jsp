<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<link href="../css/6_1_1s.css" rel="stylesheet" />
		<script src="../js/6_1_1s.js"></script>
	</head>
	<body>
		<div class="list">
			<table class="table" id="tab">
				<thead>
					<tr class="tr">
						<td style="width: 20%;" class="source">资源类型</td>
						<td>资源名称</td>
						<!-- <td style="width: 20%;">所属章节（全部）</td> -->
						<td style="width: 20%;">
							<select class="sel" id="select" onchange="select()">
								<option value="0">所属章节（全部）</option>
								<option value="1">第一章</option>
								<option value="2">第二章</option>
								<option value="3">第三章</option>
								<option value="4">第四章</option>
								<option value="5">第五章</option>
								<option value="6">第六章</option>
							</select>
						</td>
						<td style="width: 20%;">操作</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${resource }" var="resoure" varStatus="status">
						<tr class="relative">
							<td class="option">${resoure.type }</td>
							<td class="option">${resoure.name }</td>
							<td class="option">${resoure.section }</td>
							<td>
								<button class="btn" id="btn" value="${resoure.path }" onclick="download2(this)">下载</button>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>
