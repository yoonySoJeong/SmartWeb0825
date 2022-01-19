<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>시험화면</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script>
/*******************************************************  페이지 로드 이벤트 *******************************************************/
$(document).ready(function(){
	fnInit();
	fnFindAllList();
	fnFind();
}) // load event

/******************************************************* fnInit() *******************************************************/
function fnInit(){
	$('input[type=text]').val('');
} // End fnInit()
/******************************************************* fnFindAllList() *******************************************************/
// 전체 목록

// let condensedString = content.splice(20) + "..."

function fnFindAllList(){
	$.ajax({
		url: '/integration1/searchboard/findAllList',
		type: 'get',
		dataType: 'json',
		success: function(map){ // status / message / list
			$('#search_board_list').empty(); // list 초기화
			alert(map.message);
			if (map.status == 500) {
				$('<tr>')
				.append( $('<td colspan="3">').text('등록된 글이 없습니다.') )
				.appendTo( '#search_board_list' );
			} else if (map.status == 200) {
				let result = '';
				$.each(map.list, function(i, item){
					let condensedString = item.content.substring(0, 15);
					result += '<tr><td>' + item.title + '</td><td>' + condensedString + '</td><td>' + item.regDate + '</td></tr>';
				}); // End each
				$('#search_board_list').html(result);
			} // End if
		}, // End Success
		error: function(xhr){
			console.log(xhr);
		}
	}); // End ajax
} // End fnFindAllList


/***********************************************************fnFind()*********************************************************/
function fnFind(){
	$('#search_btn').click(function(){
		$.ajax({
			url: '/integration1/searchboard/find',
			type: 'get',
			data: 'column=' + $('#column').val() + '&query=' + $('#query').val(),
			dataType: 'json',
			success: function(map){
				$('#search_board_list').empty(); // list 초기화
				alert(map.message);
				if (map.status == 500) {
					$('<tr>')
					.append( $('<td colspan="3">').text('검색 결과 없음') )
					.appendTo( '#search_board_list' );
				} else if (map.status == 200) {
					let result = '';
					$.each(map.list, function(i, item){
						let condensedString = item.content.substring(0, 15);
						result += '<tr><td>' + item.title + '</td><td>' + condensedString + '</td><td>' + item.regDate + '</td></tr>';
					}); // End each
					$('#search_board_list').html(result);
				}
			},
			error: function(xhr){
				alert('수정');
			}
		});
	}) // click event
} // fnFind

</script>

</head>
<body>
	<div>
		<select name="column" id="column">
			<option value="">:::선택:::</option>
			<option value="TITLE">제목</option>
			<option value="CONTENT">내용</option>
			<option value="REGDATE">작성일</option>
		</select>
		<input type="text" name="query" id="query">
		<input type="button" value="검색" id="search_btn">
		<input type="button" value="초기화" onclick="fnInit()">
	</div>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<td>제목</td>
				<td>내용</td>
				<td>작성일</td>
			</tr>
		</thead>
		<tbody id="search_board_list"></tbody>
	</table>
	
	
</body>
</html>