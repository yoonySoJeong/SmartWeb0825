<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	setTimeout(function(){
		location.href='boardList.do';
	}, 5000);
</script>
</head>
<body>

	<h1>5초 후에 게시판으로 이동합니다.</h1>
	<a href='boardList.do'>지금 바로 이동하기</a>
</body>
</html>