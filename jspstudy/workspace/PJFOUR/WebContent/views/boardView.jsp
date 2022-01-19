<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>시작화면</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		
		$('#fo').on('submit', function(event){
			
			if ($('#author').val() == '') {
				alert('작성자를 입력하세요');
				$('#author').focus();
				event.preventDefault();
				return false;
			} else if ($('#content').val() == '') {
				alert('내용을 입력하세요');
				$('#content').focus();
				event.preventDefault();
				return false;
			}
			return true;
		}) // end submit
	}); // end onload
	
</script>

	
</head>
<body>
	<%-- 받아올 dto 2가지 --%>
	<div>
		게시글 번호 : ${boardDTO.no}<br>		<%-- session 저장이든 request 저장이든 똑같이 EL 사용 가능함 --%>
		작성자 : ${boardDTO.author}<br>
		조회수 : ${boardDTO.hit}<br>
		IP : ${boardDTO.ip}<br>
		작성일 : ${boardDTO.postdate}<br>
		제목 : ${boardDTO.title}<br>
		내용 <br>
		<pre>${boardDTO.content}</pre>
		<div>
			<input type="button" value="수정" onclick="location.href='updateForm.do'">	 <%-- session에 올려둔 data를 갖고 수정할 것이기 때문에 아무 것도 전달해 주지 않는다. :: forward 되므로 전달되는 정보는 없다. --%>
			<input type="button" value="삭제" onclick="fnNoticeDelete()">		<%-- inline 이벤트로 fn 호출 --%>
			<input type="button" id="list_btn" value="목록가기" onclick="location.href='boardList.do'">
		</div>
		<script>
		function fnNoticeDelete(){
			if(confirm('게시글을 삭제할까요?')) {
				location.href='delete.notice?no=${boardDTO.no}';
				return true;
			}
		}
	</script>
		<hr>
		<%-- 댓글 작성할 수 있는 form 구역 --%>
		<form action="insertReply.do" method="post" id="fo">	
			<label for="author">작성자</label>
			<input name="author" id="author"><br>
			<textarea rows="5" cols="30" id="content" name="content"></textarea><br>
			<%-- !!DO NOT FORGET!! 꼭 실어서 보내자 hidden으로 --%>
			<input type="hidden" name="board_no" value="${boardDTO.no}">
			<button>댓글달기</button>
		</form>
		<hr>
		<%-- reply list가 보여질 구역 --%>
		<div>
			<c:if test="${empty replyList}">
				첫 댓글의 주인공이 되어 보자
			</c:if>
			<c:if test="${not empty replyList}">
				<c:forEach items="${replyList}" var="reply">
					${reply.author}&nbsp;&nbsp;
					${reply.ip}&nbsp;&nbsp;
					${reply.postdate}<br>
					<pre>${reply.content}</pre>
				</c:forEach>
			</c:if>
		</div>
		
	</div>

</body>
</html>