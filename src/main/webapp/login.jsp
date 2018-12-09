<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
	<title>登录页面</title>
	<meta content="UTF-8">
	<link rel="shortcut icon" href="${pageContext.request.contextPath}/inspur.ico" type="image/x-icon" />
	
	<style>
	</style>
</head>
<body>
	<h2>welcome to login page.</h2>
	<form action="${pageContext.request.contextPath}/login.jsp" method="post">
		<input name="username"><br>
		<input name="password"><br>
		<button type="submit">登录</button><br>
	</form>
<script>
</script>
</body>
</html>