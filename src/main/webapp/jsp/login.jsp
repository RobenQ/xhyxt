<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>管理员登陆</title>
	<script src="/xhyxt/js/jquery.min.js"></script>
	<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
	<script>
		$(document).ready(function() {
		var entrance = document.getElementById('entrance');
		var entrance_content = document.getElementById('entrance_content');
		entrance.onclick = function() {
		entrance_content.style.display = 'inline';
		entrance.style.display = 'none';
	}
	});
	function CheckPost() {
		if (addForm.employeeNum.value == "") {
			alert("请输入管理员ID！");
			addForm.name.focus();
			return false;
		}
		if (addForm.password.value == "") {
			alert("请填写密码！");
			addForm.password.focus();
			return false;
		}
		return true;
	}
</script>
<script type="text/javascript">
function submitButton(){
	var juge = true;
	/* var ID = $("#employeeNum").val();
	var password = $("#password").val();
			 $.ajax({
				async : false,
				cache : false,
				url : "/xhyxt/admin/ajax",
				data : {
					'ID' : employeeNum,
					'password' : password			
				},
				type : "POST",
				dataType : "text",
				success : function(result) {
					//alert(eval(result));
					if (eval(result) == "ERROR") {
						alert("用户名或密码错误！");
						juge = false;
					} 
				}
			}); */
			if(juge){
				$("#myform").submit();
			}  
}

function keyLogin(){
	  if (event.keyCode==13)   //回车键的键值为13
		  submitButton();  //调用登录按钮的登录事件
	}
</script>
<link rel="stylesheet"
	href="/xhyxt/css/login.css" type="text/css">
<link rel="stylesheet"
	href="/xhyxt/admin/bootstrap.css"
	type="text/css">

</head>
<body id="body" onkeydown="keyLogin();">
	<div class="Card">
		<div class="card_top">
			<div class="icon_banner">
			<p>太原工业学院信号与系统资源共享课</p>
			<p>后台管理系统</p>
		</div>
		</div>
		<div class="card_bottom">
			<div class="login_content">
				<div class="login_form_area">
					<form id="myform"
						action="/xhyxt/admin/login"
						method="post"
						name="addForm" class="login_form" onsubmit="return CheckPost();">
						<div class="login-account">
							<div class="id_select">
								<select id="select" onchange="gradeChange()">
									<option value="student">管理员</option>
								</select> <span class="select_icon"
									style="display: inline-flex; align-items: center;">&#8203;
									<svg class="Zi Zi--Select Select-arrow" fill="currentColor"
										viewBox="0 0 24 24" width="24" height="24">
                                        <path
											d="M12 16.183l2.716-2.966a.757.757 0 0 1 1.064.001.738.738 0 0 1 0 1.052l-3.247 3.512a.758.758 0 0 1-1.064 0L8.22 14.27a.738.738 0 0 1 0-1.052.758.758 0 0 1 1.063 0L12 16.183zm0-9.365L9.284 9.782a.758.758 0 0 1-1.064 0 .738.738 0 0 1 0-1.052l3.248-3.512a.758.758 0 0 1 1.065 0L15.78 8.73a.738.738 0 0 1 0 1.052.757.757 0 0 1-1.063.001L12 6.818z"
											fill-rule="evenodd">
                                        </path>
                                    </svg>
								</span>
							</div>
							<span class="login-accountSeperator"></span>
							<div class="account_input">
								<input name="ID" id="employeeNum"
									placeholder="请使用管理员ID登录" />
							</div>
						</div>
						<div class="password_content">
							<div class="password_input">
								<div class="password_content_input">
									<input name="password" placeholder="输入密码" type="password"
										id="password">
								</div>
							</div>
							<!-- <div class="otherMethorToLogin">
								<a href="">忘记密码</a>
							</div> -->
						</div>
						<button type="button" class="submit" onclick="submitButton()">登录</button>
						<input type="hidden" name="_csrf" value="0.8981100079647797" />
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>