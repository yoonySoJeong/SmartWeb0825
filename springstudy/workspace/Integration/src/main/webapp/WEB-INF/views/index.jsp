<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>IDEX 시작화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
/*******************************************************  페이지 로드 이벤트 *******************************************************/
	$(document).ready(function(){
		fnInsertBook();
		fnInit();
		fnFindAllBook();
		fnFindBook();
	}) // load event
/******************************************************* fnInsertBook() *******************************************************/
	// 삽입 함수
	function fnInsertBook(){
		$('#insert_btn').click(function(){
			$.ajax({
				url: '/integration/book/addBook',
				type: 'post',
				contentType: 'application/json',
				data: JSON.stringify({
					title: $('#title').val(),
					preview: $('#preview').val(),
					author: $('#author').val(),
					price: $('#price').val()
				}),
				dataType:'json',
				success: function(map){
					if (map.result > 0) {
						alert('Book 정보가 등록되었습니다.');
						fnInit();
						fnFindAllBook();
					} else {
						alert('Book 정보가 등록되지 않았습니다.');
					}
				},
				error: function(xhr){
					
				}
			}) // End ajax
		}) // click event
	} // End fnInsertBook
	
/******************************************************* fnInit() *******************************************************/
	function fnInit(){
/* 		$('#title').val();
		$('#preview').val();
		$('#author').val();
		$('#price').val(); */
		$('input[type=text]').val('');
	} // End fnInit()
/******************************************************* fnFindAllBook() *******************************************************/
 // 전체 도서 목록 가져오는 함수
 
	function fnFindAllBook(){
		$.ajax({
			url: '/integration/book/findAllBook',
			type: 'get',
			dataType: 'json',
			success: function(map){ // status / message / list
				$('#book_list').empty(); // list 초기화
				alert(map.message);
				if (map.status == 200) {
					let result = '';
					$.each(map.list, function(i, book){
						result += '<tr><td>' + book.no + '</td><td>' + book.title + '</td><td>' + book.preview + '</td><td>' + book.author + '</td><td>' + book.price + '</td></tr>';
					}); // End each
					$('#book_list').html(result);
				} // End if
			}, // End Success
			error: function(){
				
			}
		}); // End ajax
	} // End fnFindAllBook
 

/***********************************************************fnFindBook()*********************************************************/
	function fnFindBook(){
		$('#search_btn').click(function(){
			$.ajax({
				url: '/integration/book/findBook',
				type: 'get',
				data: 'column=' + $('#column').val() + '&query=' + $('#query').val(),
				dataType: 'json',
				success: function(map){
					$('#book_list').empty(); // list 초기화
					alert(map.message);
					if (map.status == 200) {
						let result = '';
						$.each(map.list, function(i, book){
							result += '<tr><td>' + book.no + '</td><td>' + book.title + '</td><td>' + book.preview + '</td><td>' + book.author + '</td><td>' + book.price + '</td></tr>';
						}); // End each
						$('#book_list').html(result);
					}
				},
				error: function(){
					
				}
			});
		}) // click event
	} // fnFindBook
</script>
	
</head>
<body>
	<h1>시작화면</h1>
	
	<form id="insert_form">
		제목 : <input type="text" name="title" id="title"><br>
		개요 : <input type="text" name="preview" id="preview"><br>
		저자 : <input type="text" name="author" id="author"><br>
		가격 : <input type="text" name="price" id="price"><br>
		<input type="button" value="등록" id="insert_btn">
		<input type="button" value="초기화" onclick="fnInit()">
	</form>
	
	<hr>
	
	<div>
		<select name="column" id="column">
			<option value="">:::선택:::</option>
			<option value="TITLE">제목</option>
			<option value="PREVIEW">미리보기</option>
			<option value="AUTHOR">저자</option>
		</select>
		<input type="text" name="query" id="query">
		<input type="button" value="검색" id="search_btn">
	</div>
	
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>미리보기</td>
				<td>저자</td>
				<td>가격</td>
			</tr>
		</thead>
		<tbody id="book_list">
			
		</tbody>
	</table>
	
</body>
</html>