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
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		// String age = request.getParameter("age");
		// String type으로 받아오는 것은 가능하다 --> 애초에 Request Param이 문자열 형태로 넘어오기 때문 
		// 그래서 정수의 모양을 하고 있는 문자열 형태로 저장은 가능한 것이다. 다만 숫자의 사칙연산(+,-,*,%,/)는 불가능하다 왜냐하면 정수가 아니라 문자열이기 때문에
		String bday = request.getParameter("bday");
	%>
	<h1>이름 : <%=name%></h1>
	<h1>나이 : <%=age%></h1>
	<h1>생일 : <%=bday%></h1>
	
	<%--
		String bday와 
		<h1>생일 부분은 내가 추가한 부분이다.
	 --%>

</body>
</html>