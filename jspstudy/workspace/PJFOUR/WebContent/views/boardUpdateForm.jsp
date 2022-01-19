<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 작성</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
	$(document).ready(function(){
		
		$('#fo').on('submit', function(event){
			
			if ($('#author').val() == '') {
				alert('작성자를 입력하세요');
				$('#author').focus();
				event.preventDefault();
				return false;
			} else if ($('#title').val() == '') {
				alert('제목을 입력하세요');
				$('#title').focus();
				event.preventDefault();
				return false;
			}else if ($('#content').val() == '') {
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

	<div class="wrap">
		<h1 class="title">게시글 등록 화면</h1>
		<form id="fo" action="insertBoard.do" method="post">
		
		<label for="author">작성자</label>
		<input type="text" name="author" id="author" autofocus>
		<label for="title">제목</label>
		<input type="text" name="title" id="title">
		<label for="content">내용</label>
		<textarea name="content" id="content"></textarea>
		
		<input type="submit" value="게시글 등록하기" id="insert_btn">	<!-- input에 submit 적으면 그것도 걍 submit버튼이므로 이런식으로 CSS적용이 쉽도록 tag설정하는 것이 가능 함. -->
		<input type="reset" value="입력 초기화">
		<input type="button" value="게시글 목록" onclick="location.href='boardList.do'">
	
		</form>
	</div>


</body>
</html>