<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Page</title>
<style>
	input{
		display: block;
		margin: 5px;
	}
</style>
</head>
<body>
	<h1>게시글 작성 화면</h1>
	<form action="/ex06/board/insertBoard.do" method="post">
		<input type="text" name="writer" placeholder="작성자">
		<input type="text" name="title" placeholder="제목">
		<input type="text" name="content" placeholder="내용">
		<button>작성완료</button>
	</form>
</body>
</html>