<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Insert title here</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>

 <%
 		request.setCharacterEncoding("UTF-8");
 		String writer = request.getParameter("writer");
        String celeb = request.getParameter("celeb");
 %>

	<form action="03_quiz3.jsp" method="post">
		<h2>2. 좋아하는 운동선수는 누구인가요?</h2>
		<input name="sportsman">
		<input name="writerValue" value="<%=writer %>" type="hidden">
		<input name="celebValue" value="<%=celeb %>" type="hidden">
		<button>결과보기</button>
	
	</form>


</body>
</html>