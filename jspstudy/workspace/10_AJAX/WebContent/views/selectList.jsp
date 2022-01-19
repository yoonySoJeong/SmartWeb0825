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
	<title>제품 확인 page</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	
	<style>
		table {
			width: 800px;
			border-collapse: collapse;
			text-align: center;
		}
		
		label {
			display : block;
		}
	</style>

	<script>
		$(document).ready(function(){
			fnSelectProductList();		// 화면이 열리면 이 함수가 실행된다. 이 함수는 목록을 뿌려주는 함수이다.
			fnInsertProduct();
			fnNameCheck();
			fnPrevInsertName();
			fnDeleteProduct();
		})	// onload event finish point
		
		// 동적요소는 배치해도 읽을 수가 없다 아직 만들어져 있는 형태가 아니므로. 그래서 만들어져 있는 tag를 지정하고 event에 동적요소를 따로 걸어 event를 적용시킨다.		
		function fnDeleteProduct() {
			$('body').on('click', '.delete_btn' ,function(){	// event 대상을 따로 지정해 둘 수 있음
				let delete_pno = $(this).data('pno');		// 삭제할 번호
				if (confirm('제품번호' + delete_pno + '제품을 삭제할까요?')){		// true == 삭제    true != 삭제X   // confirm의 기본 true
					$.ajax({
						url: '/AJAX/delete.do',
						type: 'get',
						data: 'pno=' + delete_pno,				// 서버로 보내는 데이터, 파라미터 pno로 보냄 == parameter name : pno
						success: function(resData){
							if (resData.result > 0) {
								alert('삭제 완료.');
								fnSelectProductList();		// 삭제 후 목록 뿌리는 함수 재호출 // 이 함수는 목록을 뿌려주는 함수이다.
							} else {
								alert('삭제 실패1');			// 삭제할 물건번호가 없어서
							}
						},		// end of success
						error: function(){
							alert('삭제 실패2');				// 코드 수정 필요한 alert
						} // end of error
					}) // end of ajax
				} // end of if
			}); // end of click event
		} // end of fnDeleteProduct
		
		
		function fnSelectProductList(){
			// page 이동 후에 ajax data를 보여줄 수 있다.
			// ajax로 page 변동 없이 list를 가지고 오겠다.
			$.ajax({
				url: '/AJAX/selectList.do',				// contetxtPath + mapping
				type: 'get',
				// data: 없음(서버로 보내는 데이터) :: 보내는 data는 없고 가져오는 data만 있음
				dataType: 'json',		// 받아오는 데이터의 타입
				success: function(resData) {	// resData에 SelectListService의 반환 값 arr 저장 :: resData에 반환값이 온다 == arr	 :: arr은 배열
					// 제품 목록 초기화 :: 하지 않으면 원래 있는 data에 덧붙여 나오므로 초기화가 필요함
					$('#product_list').empty();	// 모든 것을 비워라 empty 함수 ==> 모든 목록을 받아서 새로 만든다.
					// 제품 목록 만들기
					if(resData.length == 0) {	// length == 0 :: 제품이 없다.
						$('<tr>')
						.append( $('<td colspan="5">').text('등록된 제품이 없습니다.') )	// tr에 넣을 td 만듦
						.appendTo('#product_list');	// 제품이 없을 경우 등록된 제품이 없다는 문구를 product_list에 넣는다.
					} else {			// length != 0 == 제품이 있다.
						for (let i = 0; i < resData.length; i++) {	// 길이가 != 0 경우엔 Data가 있으므로 제품이 있다 있을 경우엔 for문을 사용하여 data arr에 있는 data를 하나씩 꺼내와 뿌려준다.
							$('<tr>')
							.append( $('<td>').text(resData[i].pno) )
							.append( $('<td>').text(resData[i].name) )
							.append( $('<td>').text(resData[i].price) )
							.append( $('<td>').text(resData[i].made) )
							.append( $('<td>').html('<input type="button" value="삭제" class="delete_btn" data-pno="' + resData[i].pno + '">') )	// data('pno') data :: 키워드 pno::변수명
							.appendTo('#product_list');
						}
					}
				},
				error: function() {
					alert('제품 목록 가져오기 실패');
				}
			}); // ajax finish point
		};	// fnSelect finish point
			
	
			// 제품 등록 함수
		function fnInsertProduct() {
			$('#insert_btn').on('click', function(){
									
				$.ajax({
					url: '/AJAX/insert.do',
					type: 'post',
					// data: 'name=' + $('#name').val(), '&price=' + $('#price').val(), --- 방법 1. 가능은 하나 쌩 노가다이므로 요소가 여러개 일 경우 form 통째로 보내는 아래 방법을 사용하도록 하자.
					data: $('#f').serialize(),	// 폼의 모든 요소를 파라미터로 넘김 :: form의 정보(parameter)를 하나씩 넘김
					dataType: 'json',
					success: function(resData){	// obj가 여기로 온다
						if(resData.result > 0) {
							alert('제품 등록 성공.');
							$('#name').val('');
							$('#price').val('');
							fnSelectProductList();		// 목록을 뿌려주는 함수를 재 호출 하므로써 등록함과 동시에 ajax로 목록을  update 시켜준다.	:: page이동 없음
						} else {
							alert('제품 등록 실패.');
						}
					},		// ----- page이동 없이 ajax의 특성으로 제품등록만 한 페이지에서 계속 할 수 있음 (DB에 데이터 계속 들어감.)
					error: function(){
						alert('제품 등록 실패.');		// exception과 error를 함께 사용할 수 있다.
					}
				}); // end of ajax
			})// end of insert_btn click event fn
		} // end of fnInsert
			
			
		function fnNameCheck(){
			$('#name').on('blur', function(){
				$.ajax({						   // 요청 & 응답 :: 여기
					/* 보내는 곳 */
					url: '/AJAX/nameCheck.do',	   // action	// 데이터를 들고 서버로 가기 때문에 서버 경로 작성 : ajax url : server :: 서버로이동 == submit
					type: 'get',				   // method // 전달 방식 :: get or post
					data: 'name=' + $(this).val(), //params						// parameter 만듦  // 원래 작성하던 방식에서 ? 뒷 부분이라고 기억 // this :: event 대상
					
					/* 받아 오는 곳 :: json */
					dataType: 'json',				// 정답 == true or false :: 있다 or 없다
					success: function(resData){     // << 서버로 부터 응답 받은 data :: 외우면됨 약속 된 것
					// console.log(resData);		// controller에서 보낸 데이터 여기로 받음. :: resData안에 있음.
						if (resData.result == false) {
							alert('동일한 제품이 있습니다.');
						}
					},
					error: function(){
						alert('제품명 중복 체크 실패');
					}
				});
			})
		}; // end of fnNameCheck
			
		function fnPrevInsertName(){
			$('#name_btn').on('click', function(){
				$.ajax({
					url: '/AJAX/prevInsertName.do',
					type: 'get',
					dataType: 'json',
					success: function(resData){
						alert(resData.name);							
					},
					error: function(){
						alert('확인 실패');
					}
				})
			})
		} // End of fnPrevInsertName
		
		

		
		
			
			
	</script>

</head>
<body>
		<div>
		<h1>제품 등록 화면</h1>
			<form id="f">		<!-- action="/AJAX/insert.do" method="post" :: AJAX 에서 동작하므로form에는 작성하지 않아도 된다. -->
				<label for="name">제품명</label>
				<input type="text" name="name" id="name">
				<input type="button" id="name_btn" value="마지막 등록 제품명 확인">
				<label for="price">제품가격</label>
				<input type="text" name="price" id="price">
				<br>
				<input type="button" id="insert_btn" value="제품등록">
			</form>
		</div>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<td>제품번호</td>
				<td>제품명</td>
				<td>제품가격</td>
				<td>제조일자</td>
				<td>버튼</td>
			</tr>
		</thead>
		<tbody id="product_list">

		</tbody>
		<tfoot>
		</tfoot>
	</table>
</body>
</html>