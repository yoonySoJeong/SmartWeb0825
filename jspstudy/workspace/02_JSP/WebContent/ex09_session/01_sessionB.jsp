<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>sessionB</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>

	<%
		String name2 = null;
		if (session.getAttribute("name") != null) {
			name2 = (String)session.getAttribute("name");
		} else {
			name2 = "민혁";		// session이 없을 때 기본 값
		}
		
		/* 초기화를 하고 null값을 잡는 형태 */
		int age2 = 0;		// session이 없을 때 기본 값
		if (session.getAttribute("age") != null ) {
			age2 = (int)session.getAttribute("age");
		}
	%>
	
	<%-- session에 가져온 속성을 변수에 저장하여 변수에 저장된 값을 가져오는 코드 --%>
	<%-- 초기화 후 : 아래 코드는 초기화 기본 값을 불러오게 되고 --%>
	<h1>session 이름 : <%=name2%></h1>
	<h1>session 나이 : <%=age2%></h1>
	
	<%-- 변수에 저장하지않고 session에 저장된 값 바로 가져오는 코드 --%>
	<%-- 초기화 후 : 아래 코드는 아무것도 없다. --%>
	<h1>session 이름 : ${name}</h1>
	<h1>session 나이 : ${age}</h1>

	<input type="button" value="세션초기화" onclick="location.href='01_sessionC.jsp'">
	
</body>
</html>