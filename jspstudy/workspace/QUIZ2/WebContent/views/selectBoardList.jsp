<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>목록보기</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>
	<div>
	<div>총 게시글 : ${v.count}</div>
		<c:choose>
			<c:when test="${empty boardList}">0개</c:when>

		</c:choose>
		<table border="1">
			<thead>
				<tr>
					<td>순번</td>
					<td>작성자</td>
					<td>제목</td>
					<td>작성일</td>
				</tr>
			</thead>
			<tbody>
				<c:choose>
					<c:when test="${empty boardList}"><tr><td colspan="4">게시물이 없습니다.</td></tr></c:when>
					<c:otherwise>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.idx}</td>
						<td>${board.writer}</td>
						<td><a href="/QUIZ2/selectDto.board?idx=${board.idx}">${board.title}</a></td>
						<td>${board.register}</td>
					</tr>
				</c:forEach>
					</c:otherwise>
				</c:choose>
			</tbody>
			<tfoot>			
					<tr>
						<td colspan="4"><input type="button" value="새글 작성" onclick="location.href='/QUIZ2/insertForm.board'"></td>
					</tr>
			</tfoot>
		</table>
	
	</div>
</body>
</html>