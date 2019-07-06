// function show(next){
// 	var next=document.getElementById(next);
// 	next.style.display="block";
// }
// function disappear(next){
// 	var next=document.getElementById(next);
// 	next.style.display="none";
// }
// 

function select(){//因为是即时查询，需要用setTimeout进行延迟，让值写入到input内，再读取
    var storeId = document.getElementById('tab');//获取table的id标识
	var selectValue = document.getElementById('select')
    var rowsLength = storeId.rows.length;//表格总共有多少行
    var key = selectValue.value;//获取下拉选择框的值
    var searchCol = 2;//要搜索的哪一列，这里是第一列，从0开始数起
    for(var i=1;i<rowsLength;i++){//按表的行数进行循环，本例第一行是标题，所以i=1，从第二行开始筛选（从0数起）
      var searchText = storeId.rows[i].cells[searchCol].innerHTML;//取得table行，列的值
	  if(key==0){
	  		  storeId.rows[i].style.display='';
	  }else if(key==1&&searchText=="第一章"){
				storeId.rows[i].style.display='';
			}else if(key==2&&searchText=="第二章"){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
					storeId.rows[i].style.display='';//显示行操作，
				}else if(key==3&&searchText=="第三章"){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
					storeId.rows[i].style.display='';//显示行操作，
					}else if(key==4&&searchText=="第四章"){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
						storeId.rows[i].style.display='';//显示行操作，
						}else if(key==5&&searchText=="第五章"){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
							storeId.rows[i].style.display='';//显示行操作，
							}else if(key==6&&searchText=="第l六章"){//用match函数进行筛选，如果input的值，即变量 key的值为空，返回的是ture，
								storeId.rows[i].style.display='';//显示行操作，
								}else{
										storeId.rows[i].style.display='none';//隐藏行操作
									}
	  
    }
}

//按钮点击下载
function download(btn){
	window.location.href="/xhyxt/user/downfile";
}

function download2(btn){
	var http;
	var storeId = document.getElementById('tab');//获取table的id标识
	var tr = btn.parentNode.parentNode.rowIndex;
	var path = btn.value;
	var type = storeId.rows[tr].cells[0].innerHTML;
	var name = storeId.rows[tr].cells[1].innerHTML;
	
	if(window.XMLHttpRequest) {
		//  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
		http = new XMLHttpRequest();
	} else {
		// IE6, IE5 浏览器执行代码
		http = new ActiveXObject("Microsoft.XMLHTTP");
	}
	http.open("GET", "/xhyxt/admin/deletefile4_1_1a?path="+path+"&name="+name+"&type="+type, true);
//	http.setRequestHeader("Content-type", "application/x-www-form-urlencoded;");
	http.send();
	http.onreadystatechange = function() {
		if(http.readyState == 4 && http.status == 200) {
			window.location.href="/xhyxt/admin/deletefile4_1_1a?path="+path+"&name="+name+"&type="+type;
		}
	}
}