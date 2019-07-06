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
		<meta charset="UTF-8">
		<title></title>
		<link rel="stylesheet"href="../css/2_1_1.css" />
		<link rel="stylesheet"href="../css/footer.css" />
		<link rel="stylesheet"href="../css/header.css" />
		<link href='http://cdn.webfont.youziku.com/webfonts/nomal/128313/19650/5c8e0f3ef629d80d48747bad.css' rel='stylesheet' type='text/css' />
		<link rel="stylesheet"href="../css/lunbo.css" />
	</head>
	<body>
		<header>
			<div class="logo">
				<a href="/xhyxt/index.jsp">
					<img src="../img/header/head-logo.png" alt="太原工业学院" title="太原工业学院" />
				</a>
			</div>
			<div class="title">
				<h2 style="font-family:'jdlibianjian183014d2d91f539';font-size: 40px;">信号与系统资源共享课</h2>
			</div>
			<div class="nav">
				<ul class="nav-ul">
					<li class="left navli">
						<h3><a href="/xhyxt/index.jsp" class="nav-a">首页</a></h3>
					</li>
					<li class="left navli" onmouseover="show('ul1')" onmouseout="disappear('ul1')">
						<h3><a href="/xhyxt/user/to2_1_1" class="nav-a">课程概况</a></h3>
						<ul id="ul1" class="no">
							<li>
								<a href="/xhyxt/user/to2_1_1">项目申报书</a>
							</li>
							<li>
								<a href="/xhyxt/user/to2_2_1">教学大纲</a>
							</li>
							<li>
								<a href="/xhyxt/user/to2_3_1">授课计划</a>
							</li>
						</ul>
					</li>
					<li class="left navli" onmouseover="show('ul2')" onmouseout="disappear('ul2')">
						<h3><a href="/xhyxt/user/to3_1_1" class="nav-a">教学队伍</a></h3>
						<ul id="ul2" class="no">
							<li>
								<a href="/xhyxt/user/to3_1_1">项目负责人</a>
							</li>
							<li>
								<a href="/xhyxt/user/to3_2_1">项目组成员</a>
							</li>
						</ul>
					</li>
					<li class="left navli" onmouseover="show('ul3')" onmouseout="disappear('ul3')">
						<h3><a href="/xhyxt/user/to4_1_1" class="nav-a">教学资源</a></h3>
						<ul class="no" id="ul3">
							<li>
								<a href="/xhyxt/user/to4_1_1">课件PPT</a>
							</li>
							<li>
								<a href="/xhyxt/user/to4_2_1">电子教案</a>
							</li>
							<li>
								<a href="/xhyxt/user/to4_3_1">教学视频</a>
							</li>
							<li>
								<a href="/xhyxt/user/to4_4_1">参考教材</a>
							</li>
						</ul>
					</li>
					<li class="left navli" onmouseover="show('ul4')" onmouseout="disappear('ul4')">
						<h3><a href="/xhyxt/user/to5_1_1" class="nav-a">教学实践</a></h3>
						<ul class="no" id="ul4">
							<li>
								<a href="/xhyxt/user/to5_1_1">实验指导书</a>
							</li>
							<li>
								<a href="/xhyxt/user/to5_2_1">虚拟仿真</a>
							</li>
							<li>
								<a href="/xhyxt/user/to5_3_1">matlab仿真</a>
							</li>
						</ul>
					</li>
					<li class="left navli" onmouseover="show('ul5')" onmouseout="disappear('ul5')">
						<h3><a href="/xhyxt/user/to6_1_1" class="nav-a">习题与试题</a></h3>
						<ul class="no" id="ul5">
							<li>
								<a href="/xhyxt/user/to6_1_1">习题详解</a>
							</li>
							<li>
								<a href="/xhyxt/user/to6_1_1">试题汇总</a>
							</li>
						</ul>
					</li>
				</ul>
			</div>
		</header>
		<div class="main">
			<div id="pic-container"style="height: 250px;">
			<ul id="ul">
				<li class="left pic"style="height: 250px;"><img src="../img/lunbo/1.jpg" alt="1" /></li>
				<li class="left pic"style="height: 250px;"><img src="../img/lunbo/2.jpg" alt="2" /></li>
				<li class="left pic"style="height: 250px;"><img src="../img/lunbo/3.jpg" alt="3" /></li>
				<li class="left pic"style="height: 250px;"><img src="../img/lunbo/4.jpg" alt="4" /></li>
				<li class="left pic"style="height: 250px;"><img src="../img/lunbo/5.png" alt="5" /></li>
			</ul>
			<ol id="list">
				<li id="on">1</li>
				<li>2</li>
				<li>3</li>
				<li>4</li>
				<li>5</li>
			</ol>
			<div id="btn">
				<span id="left"><</span>
				<span id="right">></span>
			</div>
		</div>
		</div>
		<div class="body">
			<div class="left_list">
				<ul>
					<span>教学实践</span>
					<li id="application_book" onclick="change_src_1()">实验指导书</li>
					<li id="outline" onclick="change_src_2()">虚拟仿真</li>
					<li id="teach_plan" onclick="change_src_3()"style="color: white;background: lightblue;border-bottom: 0.5px #35383D solid;">Matlab仿真</li>
				</ul>
			</div>
			<div class="right_body" id="right_body">
				<iframe src="/xhyxt/user/to5_3_1s" id="right_iframe">
					
				</iframe>
			</div>
		</div>
		<footer>
			<div class="foot">
				<p>地址：山西省太原市尖草坪区新兰路31号&nbsp;&nbsp;&nbsp;&nbsp;邮编：030008</p>
				<p>版权所有：太原工业学院&nbsp;&nbsp;&nbsp;&nbsp;ICP备案号：晋ICP备14003279号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;晋公网安备号：140110430070001</p>
			</div>
			<div class="foot-pic">
				<a href="http://bszs.conac.cn/sitename?method=show&id=0A3F84E61C365A2AE053012819ACE636"target="_blank">
					<img src="../img/footer/FC847247D2950B1470DD97923AF_49DF2FD5_903.png"style="width: 50px;height: 50px;margin-right: 20px;" />
				</a>
				<a href="http://202.99.219.148/alarm/"target="_blank">
					<img src="../img/footer/CCBDEA4F5E1A4C78E5662D8E9AE_A4020B6D_1084.png"style="height: 43px;width: 33px;margin-right: 20px;"/>
				</a>
				<a href="http://www.beian.gov.cn/portal/index"target="_blank">
					<img src="../img/footer/124C9182848E4BCA0E816C82CCC_B77A7463_1262.png"style="height: 45px;width: 40px;" />
				</a>
			</div>
		</footer>
	</body>
	<script src="../js/main.js"></script>
	<script src="../js/5_1_1.js"></script>
	<script src="../js/lunbo.js"></script>
	<script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>
</html>
