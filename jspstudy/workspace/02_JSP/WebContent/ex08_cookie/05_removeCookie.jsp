<%@page import="java.net.URLEncoder"%>
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
		/*
			쿠키 삭제하기 -- 방법 1
			1. 모든 쿠키를 읽는다.
			2. 삭제할 쿠키의 유효 기간을 0으로 설정한다.
			3. 동일한 이름의 쿠키로 덮어쓰기한다.
			
			
			쿠키 삭제하기 -- 방법 2
			1. 동일한 쿠키를 만든다.
			2. 유효 기간을 0으로 설정한다.
			3. 동일한 이름의 쿠키로 덮어쓰기한다.
		*/
		
		// agree, adress 쿠키를 모두 삭제하기
		
		
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("agree")||cookie.getName().equals("address")){
				Cookie ck = new Cookie(cookie.getName(),"");
				ck.setMaxAge(0);
				response.addCookie(ck);
			}
		}
		
		/*
			방법 2의 방법.
			찾아온 쿠키의 시간을 0으로 다시 초기화 하므로써 삭제 할 수 있는 방법도 있음
		*/
		
		Cookie cookie1 = new Cookie("agree", "");
		cookie1.setMaxAge(0);
		response.addCookie(cookie1);

		Cookie cookie2 = new Cookie("address", "");
		cookie2.setMaxAge(0);
		response.addCookie(cookie2);

		
		/*
			나는 if절의 조건에 ||로 덧붙일 생각을 하지 않고 똑같은걸 하나 더 만들어서....함..
		Cookie[] cookies = request.getCookies();
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("agree")) {
				Cookie ck1 = new Cookie("agree","");
				ck1.setMaxAge(0);
				response.addCookie(ck1);	
				// 응답하면 끝이므로 break는 필요없음
			}
			if (cookie.getName().equals("address")) {
				Cookie ck2 = new Cookie("address", "");
				ck2.setMaxAge(0);
				response.addCookie(ck2);
			}
		}
		*/
	%>
</body>
</html>