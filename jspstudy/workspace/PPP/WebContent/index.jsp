<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="/PPP/login.do" method="post">
		<input type="text" name="id" id="id">
		<input type="text" name="pw" id="pw">
		<button>로그인</button>
	</form>

</body>
</html>