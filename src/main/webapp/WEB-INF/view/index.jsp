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
		<button onclick="fetchSession()">查看session</button>
	</p>
	
	<form id="logoutForm" action="logout" method="post">
	</form>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/lib/docCookie.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/public/lib/jquery-3.3.1.min.js"></script>

<script>
var baseUrl = "${pageContext.request.contextPath}"

window.onload = function(){
	var logout = document.getElementById("logoutBtn")
	logout.onclick = function(){
		document.getElementById("logoutForm").submit()
	}

}

function fetchSession(){
	$.getJSON(baseUrl +"/user.do/fetchSession", function(data){
		console.log("session:", data)
	})
}

</script>
</html>
