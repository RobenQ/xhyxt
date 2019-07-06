<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>后台管理主页</title>
		<link rel="stylesheet" href="../css/admin/adminFooter.css" />
		<link rel="stylesheet" href="../js/jquery.min.js" />
		<link rel="stylesheet" href="../css/admin/adminHeader.css" />
		<link href='http://cdn.webfont.youziku.com/webfonts/nomal/128313/19650/5c8f4022f629d80d48747c24.css' rel='stylesheet'
		 type='text/css' />
		<script src="../js/adminIndex.js"></script>
	</head>
	<body>
		<header>
			<div class="logo">
				<a href="main.html">
					<img src="../img/header/head-logo.png" alt="太原工业学院" title="太原工业学院" />
				</a>
			</div>
			<div class="title">
				<h2 style="font-family:'jdlibianjian1834bbcf041f539';font-size: 40px;">信号与系统资源共享课后台管理系统</h2>
			</div>
			<div class="user">
				<h5>欢迎管理员【${admin.name}】登录!</h5>
			</div>
		</header>
		<div class="main">
			<div class="mainLeft">
				<div class="main-menu">
				    <ul>
				        <li class="nav-list">
				            <h3 style="background: #FF6201;">课程概况
				                <i></i>
				            </h3>
				            <div class="hide">
				            <h5 onclick="load2_1()">项目申报书</h5>
				            <h5 onclick="load2_2()">教学大纲</h5>
				            <h5 onclick="load2_3()">授课计划</h5>
				            </div>
				        </li>
				        <li class="nav-list" >
				            <h3 style="background: #F54809;">教学队伍
				                <i></i>
				            </h3>
				            <div class="hide">
				            <h5 onclick="load3_1()">项目负责人</h5>
				            <h5 onclick="load3_2()">项目组成员</h5>
				            </div>
				        </li>
						<li class="nav-list">
						    <h3 style="background: #FF6201;">教学资源
						        <i></i>
						    </h3>
						    <div class="hide">
						    <h5 onclick="load4_1()">PPT课件</h5>
						    <h5 onclick="load4_2()">电子教案</h5>
							<h5 onclick="load4_3()">教学视频</h5>
							<h5 onclick="load4_4()">参考教材</h5>
						    </div>
						</li>
						<li class="nav-list">
						    <h3 style="background: #F54809;">教学实践
						        <i></i>
						    </h3>
						    <div class="hide">
						    <h5 onclick="load5_1()">实验指导书</h5>
						    <h5 onclick="load5_2()">虚拟仿真</h5>
							<h5 onclick="load5_3()">Matlab虚拟仿真</h5>
						    </div>
						</li>
						<li class="nav-list">
						    <h3 style="background: #FF6201;">习题与试题
						        <i></i>
						    </h3>
						    <div class="hide">
						    <h5 onclick="load6_1()">习题课件</h5>
						    <h5 onclick="load6_2()">试题汇总</h5>
						    </div>
						</li>
						<li class="nav-list">
						    <h3 style="background: #F54809;">系统设置
						        <i></i>
						    </h3>
						    <div class="hide">
						    <h5 onclick="load7_1()">首页图片</h5>
						    </div>
						</li>
				    </ul>
				</div>
			</div>
			<div class="mainRight" id="main">
			<iframe class="child" id="child" src="/xhyxt/jsp/2_1.jsp">
					
				</iframe>
			</div>
		</div>
		<footer>
			<div class="foot">
				<p>地址：山西省太原市尖草坪区新兰路31号&nbsp;&nbsp;&nbsp;&nbsp;邮编：030008</p>
				<p>版权所有：太原工业学院&nbsp;&nbsp;&nbsp;&nbsp;ICP备案号：晋ICP备14003279号&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;晋公网安备号：140110430070001</p>
			</div>
			<div class="foot-pic">
				<a href="http://bszs.conac.cn/sitename?method=show&id=0A3F84E61C365A2AE053012819ACE636" target="_blank">
					<img src="../img/footer/FC847247D2950B1470DD97923AF_49DF2FD5_903.png" style="width: 50px;height: 50px;margin-right: 20px;" />
				</a>
				<a href="http://202.99.219.148/alarm/" target="_blank">
					<img src="../img/footer/CCBDEA4F5E1A4C78E5662D8E9AE_A4020B6D_1084.png" style="height: 43px;width: 33px;margin-right: 20px;" />
				</a>
				<a href="http://www.beian.gov.cn/portal/index" target="_blank">
					<img src="../img/footer/124C9182848E4BCA0E816C82CCC_B77A7463_1262.png" style="height: 45px;width: 40px;" />
				</a>
			</div>
		</footer>
		<script>
		    var oList=document.querySelectorAll('.nav-list h3'),
		    oHide=document.querySelectorAll('.hide'),
		    oIcon=document.querySelectorAll('.nav-list i');//获取css中的元素
		    lastIdnex=0;//上一次点击下标
		    for(var i=0;i<oList.length;i++)
		    {
		        oList[i].index=i;//自定义属性保存下标
		        oList[i].isClick=false;//没有被点击
		        oList[i].onclick=function() {//点击事件->执行函数
		            //清除上一次下标
					
		            oHide[lastIdnex].style.height='0';//改变hide高度
		            oList[lastIdnex].className= '';//改变颜色
		            oIcon[lastIdnex].className= '';//修改角度
		            if(this.isClick){//被点了
		                this.isClick=false;//开关变化
		            }
		            else
		            {
						if (this.index==0) {
							 oHide[this.index].style.height='116px';//改变hide高度
						} else if(this.index==1){
							oHide[this.index].style.height='77px';//改变hide高度
						} else if(this.index==2){
							oHide[this.index].style.height='152px';//改变hide高度
						} else if(this.index==3){
							oHide[this.index].style.height='116px';//改变hide高度
						} else if(this.index==4){
							oHide[this.index].style.height='77px';//改变hide高度
						} else if(this.index==5){
							oHide[this.index].style.height='38px';//改变hide高度
						}
		                //设置当前下标
		               
		                oList[this.index].className= 'on';//改变颜色
		                oIcon[this.index].className= 'on';//修改角度
		
		                oList[lastIdnex].isClick=false;//清除上一次开关
		                oList[this.index].isClick=true;//开关变化
		                lastIdnex=this.index;//保存当前下标
		                
		            }
		        }
		    }
		</script>
	</body>
</html>