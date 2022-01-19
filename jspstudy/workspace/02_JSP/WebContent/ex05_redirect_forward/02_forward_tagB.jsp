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

	<%-- forward 태그 --%>
	<%-- 기존 요청(request) + 새로운 파라미터 추가 가능 --%>
		<% request.setCharacterEncoding("UTF-8"); %>
	<jsp:forward page="02_forward_tagC.jsp">
		<jsp:param value="44" name="age" />
		<jsp:param value="4월25일" name="bday"/>
	</jsp:forward>
	
	<%-- 
		내가 추가한 부분 name="bday" value="4월25일" parameter를 추가해서 보냈다. 
		첫번째 시도에서 ???로 표시되었다 : Encoding이 되지 않아 인식하지 못 함
		그래서 추가로 request.setCharacterEncoding("UTF-8");을 해줌 --> 잘 나옴
		request.는 자바의 영역으로 잡아서 하면 된다.	
	 --%>
	
	
</body>
</html>