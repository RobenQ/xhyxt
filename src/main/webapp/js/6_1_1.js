var right_iframe = document.getElementById("right_iframe");
var application_book = document.getElementById("application_book");
var outline = document.getElementById("outline");
var teach_plan = document.getElementById("teach_plan");
var teach_text = document.getElementById("teach_text");

function change_src_1() {
		right_iframe.src = "/xhyxt/user/to6_1_1s";
		application_book.style.color = "white";
		application_book.style.background = "lightblue";
		outline.style.color = "white";
		outline.style.background = "#3889D4";
}

function change_src_2() {
	right_iframe.src = "/xhyxt/user/to6_2_1s";
	outline.style.color = "white";
	outline.style.background = "lightblue";
	application_book.style.color = "white";
	application_book.style.background = "#3889D4";
}