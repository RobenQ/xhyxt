<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="${pageContext.request.contextPath }/user/userIndex" enctype="multipart/form-data" method="post">
	         上传用户：<input type="text" name="username"><br/>
	         上传文件:<input type="file" name="file1"><br/>
	         <input type="submit" value="提交">
	</form>
</body>
</html>