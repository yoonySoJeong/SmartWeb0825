<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>board 전체보기</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<style>
	table {
		width: 1200px
	}
</style>
	<script>
		$(document).ready(function(){
			// 한줄 글 등록하기
			$('#short_content_btn').on('click', function(){
				$.ajax({
					url: '/PROJECT1/insert.do',
					type: 'post',
					data: $('#fo').serialize(),
					dataType: 'json',
					success: function(resData){
						if(resData.result > 0) {
							alert('등록 완료');
							$('#writer').val('');
							$('#title').val('');
							$('#content').val('');
						} else {
							alert('등록 실패');
						}
					},
					error: function(){
						alert('이것은 에러임');
					}
				}) // end of ajax
			})// End of click
			
			$('#last_writer_btn').on('click', function(){
				$.ajax({
					url: '/AJAX/prevWriterName.do',
					type: 'post',
					dataType: 'json',
					success: function(resData){
						alert(resData.writer);
					},
					error: function(){
						alert('확인 실패');
					}
				}) // End of ajax
			}) // End of click Event
		}) // End of load event
	
	</script>



</head>
<body>
	<div>
		<h1>게시글 수 : ${totalCount} 개</h1>
	</div>
	<table>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="4">게시물이 없습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach var="board" items="${list}">
					<tr>
						<td>${board.idx}</td>
						<td>${board.writer}</td>
						<td><a href="/PROJECT1/detailBoard.do?idx=${board.idx}">${board.title}</a></td>
						<td>${board.register}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
	</table>
	
	
	
	<form id="fo">
		<table>
			<tbody>
				<tr>
					<td>한줄 글쓰기</td>
				</tr>
				<tr>
					<td>
						<input type="text" name="writer" id="writer" placeholder="작성자">
					</td>
				<tr>
					
					<td>
						<input type="text" name="title" id="title" placeholder="제목">
					</td>
				</tr>
				<tr>	
					<td>
						<input type="text" name="content" id="content" placeholder="내용">
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="한줄글쓰기등록" id="short_content_btn">
					</td>
				</tr>
				<tr>
					<td>
						<input type="button" value="마지막 작성자 확인" id="last_writer_btn">
					</td>
				</tr>
			</tbody>
		</table>
	</form>

</body>
</html>