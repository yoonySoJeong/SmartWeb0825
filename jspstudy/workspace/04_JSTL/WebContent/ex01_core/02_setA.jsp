<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	<%-- 앞에다가 c를 붙여준다는 뜻 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- age는 문자열로 전달된다. --%>

	<c:set var="age" value="5" scope="request" />
	<jsp:forward page="02_setB.jsp"/>
</body>
</html>