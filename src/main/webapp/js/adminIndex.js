//function load_2_1(){
//	var http;
//	if(window.XMLHttpRequest) {
//		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
//		http = new XMLHttpRequest();
//	} else {
//		// IE6, IE5 浏览器执行代码
//		http = new ActiveXObject("Microsoft.XMLHTTP");
//	}
//	http.open("GET", "/xhyxt/admin/load?a=2_1", true);
//	http.send();
//	http.onreadystatechange = function() {
//		if(http.readyState == 4 && http.status == 200) {
//			document.getElementById("main").innerHTML=http.responseText;	
//		}
//	}
//	
//}
//
//function load_2_2(){
//	var http;
//	if(window.XMLHttpRequest) {
//		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
//		http = new XMLHttpRequest();
//	} else {
//		// IE6, IE5 浏览器执行代码
//		http = new ActiveXObject("Microsoft.XMLHTTP");
//	}
//	http.open("GET", "/xhyxt/admin/load?a=2_2", true);
//	http.send();
//	http.onreadystatechange = function() {
//		if(http.readyState == 4 && http.status == 200) {
//			document.getElementById("main").innerHTML=http.responseText;	
//		}
//	}
//	
//}
//
//function load_2_3(){
//	var http;
//	if(window.XMLHttpRequest) {
//		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
//		http = new XMLHttpRequest();
//	} else {
//		// IE6, IE5 浏览器执行代码
//		http = new ActiveXObject("Microsoft.XMLHTTP");
//	}
//	http.open("GET", "/xhyxt/admin/load?a=2_3", true);
//	http.send();
//	http.onreadystatechange = function() {
//		if(http.readyState == 4 && http.status == 200) {
//			document.getElementById("main").innerHTML=http.responseText;	
//		}
//	}
//	
//}

function load2_1(){
	document.getElementById("child").setAttribute("src","/xhyxt/jsp/2_1.jsp");
}

function load2_2(){
	document.getElementById("child").setAttribute("src","/xhyxt/jsp/2_2.jsp");
}

function load2_3(){
	document.getElementById("child").setAttribute("src","/xhyxt/jsp/2_3.jsp");
}

function load3_1(){
	document.getElementById("child").setAttribute("src","/xhyxt/jsp/3_1.jsp");
}

function load3_2(){
	document.getElementById("child").setAttribute("src","/xhyxt/jsp/3_2.jsp");
}

function load4_1(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to4_1");
}

function load4_2(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to4_2");
}

function load4_3(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to4_3");
}

function load4_4(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to4_4");
}

function load5_1(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to5_1");
}

function load5_2(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to5_2");
}

function load5_3(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to5_3");
}

function load6_1(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to6_1");
}

function load6_2(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to6_2");
}

function load7_1(){
	document.getElementById("child").setAttribute("src","/xhyxt/admin/to7_1");
}