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
		<meta charset="utf-8">
		<link href="../css/7_1_1a.css" rel="stylesheet" />
		<title></title>
	</head>
	<body>
		<div class="div1" id="div1">
			<c:forEach items="${pictures }" var="pictures" varStatus="status">
			<div class="table">
				<h1>${pictures.name }</h1>
				<br>
			</div>
			<img class="img" src="${pageContext.request.contextPath }${pictures.path }/${pictures.name }" />
			<br><br>		
			</c:forEach>
		</div>
	</body>
</html>