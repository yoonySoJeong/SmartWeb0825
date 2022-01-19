<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
	
	/* 입력 없으면 빈 문자열("") */
	String userId = request.getParameter("userId");
	String userPw = request.getParameter("userPw");
	
	/* 체크 안하면 널(null) */
	String checkSaveId = request.getParameter("checkSaveId");
	
	// out.println("널 ? " + (checkSaveId == null));
	// out.println("빈 문자열 ? " + checkSaveId.isEmpty());	--> null point exception
	
	/*
		체크 하면   아이디를 쿠키에 저장한다.
		체크 안하면 아이디를 쿠키에서 삭제한다.
	*/
	if(checkSaveId != null){
		Cookie cookie = new Cookie("userId", userId);
		cookie.setMaxAge(15 * 24 * 60 * 60);
		response.addCookie(cookie);
	} else if (checkSaveId == null) {
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("userId")) {
				cookie.setMaxAge(0);
				response.addCookie(cookie);
				break;
			}
		}
	}
	
	// 로그인 화면으로 되돌아가기
	response.sendRedirect("06_saveIdA.jsp");
	
%>
	<%--
		request.setCharacterEncoding("UTF-8");
	
		String userId = request.getParameter("userId");
		if(userId.isEmpty()) {
			userId = "아이디가없다";
		}
		String userPw = request.getParameter("userPw");
		if(userPw.isEmpty()) {
			userPw = "비밀번호가없다";
		}

		// 2. Bean 만들기 (필드를 이용한 생성자)
		Person p2 = new Person(userId, userPw);
		
		// EL : ${} 사용을 위해 pageContext에 속성으로 저장		----- 자동 완성이 안되므로 암기가 필요한 부분 -----
		pageContext.setAttribute("p2", p2);
	--%>
