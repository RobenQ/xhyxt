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
		<link rel="stylesheet" href="../css/admin/adminHeader.css" />
		<script src="../js/adminIndex.js"></script>
		<meta charset="UTF-8">
		<title></title>
	</head>
	<body>
		<iframe src="/xhyxt/admin/to7_1_1a" width="80%" height="600px" style="border: none; border-radius: 10px;">
			
		</iframe>
		<div style="width: 20%; height: 580px; border: none; border-radius: 10px; float: right;">
			<!-- <select style="margin-top: 200px; margin-left: 70px; width: 150px; height: 30px;">
				<option value="第一章">第一章</option>
				<option value="第二章">第二章</option>
				<option value="第三章">第三章</option>
				<option value="第四章">第四章</option>
				<option value="第五章">第五章</option>
				<option value="第六章">第六章</option>
			</select> -->
			<form action="${pageContext.request.contextPath }/admin/uploade7_1"  enctype="multipart/form-data" method="post">
				<select name="select" id="select" style="margin-top: 200px; margin-left: 70px; width: 150px; height: 30px;">
					<option value="图1">图1</option>
					<option value="图2">图2</option>
					<option value="图3">图3</option>
					<option value="图4">图4</option>
					<option value="图5">图5</option>
				</select>
				<input type="file"  name="file" style="margin-top: 30px; margin-left: 70px; width: 150px; height: 30px;" />
				<input type="button" style="margin-top: 30px; margin-left: 70px; width: 150px; height: 30px;
					border: none; border-radius: 10px;background: #FF6201; color: wheat;font-size: 18px;" value="保存修改"/>
			</form>
		</div>
	</body>
</html>