<%@page import="java.net.URLDecoder"%>
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
		// 1. 사용자의 모든 쿠키 읽기
		Cookie[] cookies = request.getCookies();
	
		// 2. 쿠키 순회(for문)
		for (int i = 0; i < cookies.length; i++) {
			out.println("<h1>쿠키 이름 : " + cookies[i].getName() + "</h1>");
			out.println("<h1>유효 기간 : " + cookies[i].getMaxAge() + "</h1>");
			out.println("<h1>쿠키 값 : " + URLDecoder.decode(cookies[i].getValue(), "UTF-8") + "</h1>");
		}
		
		// 3. agree 쿠키만 읽기
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("agree")){	// cookie에 getname을 한 뒤 equals로 agree name을 가진 cookie의 정보를 불러온다. (배열의 idx값을 몰라도 찾을 수 있다.)
			out.println("<h1>쿠키 이름 : " + cookie.getName() + "</h1>");
			out.println("<h1>유효 기간 : " + cookie.getMaxAge() + "</h1>");
			out.println("<h1>쿠키 값 : " + URLDecoder.decode(cookie.getValue(), "UTF-8") + "</h1>");
			}
		}

	%>
	<%-- 내가 해 본 거 agree 쿠키만 읽기
	<hr>	<!--  구분을 위해 hr 수평선 넣음 -->
	<%
		// agree 쿠키만 읽기
			out.println("<h1>" + cookies[0].getName() + "</h1>");
			out.println("<h1>" + cookies[0].getMaxAge() + "</h1>");
			out.println("<h1>" + URLDecoder.decode(cookies[0].getValue(), "UTF-8") + "</h1>");
	
	%>
	<hr>
	<%
		// address 쿠키만 읽기
			out.println("<h1>" + cookies[1].getName() + "</h1>");
			out.println("<h1>" + cookies[1].getMaxAge() + "</h1>");
			out.println("<h1>" + URLDecoder.decode(cookies[1].getValue(), "UTF-8") + "</h1>");
	
	%>
	--%>



</body>
</html>