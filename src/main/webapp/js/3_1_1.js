var right_iframe = document.getElementById("right_iframe");
var application_book = document.getElementById("application_book");
var outline = document.getElementById("outline");
var teach_plan = document.getElementById("teach_plan");

function change_src_1() {
		right_iframe.src = "../js/pdfjs/web/viewer.html?file=../../../files/three/3_1.pdf";
		application_book.style.color = "white";
		application_book.style.background = "lightblue";
		outline.style.color = "white";
		outline.style.background = "#3889D4";
//		teach_plan.style.color = "black";
//		teach_plan.style.background = "lightblue";
}

function change_src_2() {
	right_iframe.src = "../js/pdfjs/web/viewer.html?file=../../../files/three/3_2.pdf";
	outline.style.color = "white";
	outline.style.background = "lightblue";
//	teach_plan.style.color = "black";
//	teach_plan.style.background = "lightblue";
	application_book.style.color = "white";
	application_book.style.background = "#3889D4";
}