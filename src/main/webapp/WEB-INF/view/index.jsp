<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" >
	<title>网站首页</title>
	<style type="text/css">
		h2 {
			display: inline
		}
		.pull-right {
			float: right
		}
		#logoutForm {
			display: none
		}
		#logoutBtn:hover{
			background-color: yellow;
			cursor: pointer
		}
	</style>
</head>
<body>
	<div>
		<h2>Hello World!</h2>
		<a id="logoutBtn" class="pull-right">logout</a>
	</div>
	<p>正文正文正文。。。。。</p>
	<p>
	<%= application.getRealPath("") %>
	</p>
	
	<form id="logoutForm" action="logout" method="post">
	</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/lib/docCookie.js"></script>
<script>
window.onload = function(){
	var logout = document.getElementById("logoutBtn")
	logout.onclick = function(){
		document.getElementById("logoutForm").submit()
	}

}

function setCookie(name, value){
	var exp = new Date();
	var expireTime = new Date(exp.getTime() + 115*60*1000);
	document.cookie = name + '=' + escape(value) + ";expires=" + expireTime.toUTCString() + ";path=/"; //GMT
}
function getCookie(name){
	var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
	if(arr = document.cookie.match(reg)){
		return unescape(arr[2])
	}else{
		return null
	}
}
function clearCookie(){
	var arr = document.cookie.split("; ");
	for( var i in arr){
		var toks = arr[i].split("=")
		if(toks.length > 0){
			var exp = new Date()
			exp = new Date(exp.getTime() - 1)
			document.cookie = arr[0] + "=" + escape(getCookie(arr[0])) + ";expires=" + exp.toUTCString() + ";path=/";
		}
	}
}

</script>
</html>
