<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* redirect : 기존 요청(request)을 전달하지 않는다. */
	/* 강제로 전달하시오. */
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String age = request.getParameter("age");
	
	/* response에 강제 encoding을 해줬다. */
	response.sendRedirect("04_sendRedirectC.jsp?name=" + URLEncoder.encode(name, "UTF-8") + "&age=" + age);
	// response.sendRedirect("04_sendRedirectC.jsp?name=" + name + "&age=" + age);
	// C로 request param을 전달하기 위해서는 B에서 getParam을 통해 변수에 data를 저장해둬야 한다.
	// 왜냐하면 response가 이뤄지므로써, request에 저장된 param은 사라짐.-----> 대충 사라지기전에 저장해두라는 뜻인 듯.
%>