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
		<link href="../css/showVideo.css" rel="stylesheet" />
		<script src="../js/jquery.min.js"></script>
	</head>
	<body>
		<div class="list">
			<div class="table">
				<h1>${name }</h1>
				<br><br>
				<hr >
			</div>
			<video class="video" src="${pageContext.request.contextPath }${filePath }/${name }" controls="controls" preload="auto">
				
			</video>
			
		</div>
	</body>
</html>