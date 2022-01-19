<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Employee Detail page</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<script>
		$(document).ready(function(){
			
			$('#fo').on('submit', function(event){
				
				if($('#name').val() == '') {
					alert('이름은 필수 입력사항입니다.');
					$('#name').focus();
					event.preventDefault();
					return false;
				}else if($('#depart').val() == '') {
					alert('부서는 필수 입력사항입니다.');
					$('#depart').focus();
					event.preventDefault();
					return false;
				} else if($('#salary').val() < 0) {
					alert('연봉은 0이상 입력해야합니다.');
					$('#salary').focus();
					event.preventDefault();
					return false;
				}
				return true;
	
			})
			
			
		})// end of onload
		
	</script>

</head>
<body>

	<div class="wrap">
		<h1 class="title">사원 등록 화면</h1>
	</div>
	<form id="fo" action="/PJFIFTH/updateEmployee.do?eno=${employee.eno}" method="post">
		<table>
			<tbody>
				<tr>
					<td>
						<input type="hidden" name="eno" value="${employee.eno}">
						${employee.eno}
					</td>
				</tr>
				<tr>
					<td>사원이름</td>
					<td><input type="text" name="name" id="name" value="${employee.name}"></td>
				</tr>
				<tr>
					<td>사원부서</td>
					<td><input type="text" name="depart" id="depart" value="${employee.depart}"></td>
				</tr>
				<tr>
					<td>사원급여</td>
					<td><input type="text" name="salary" id="salary" value="${employee.salary}"></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
					<input type="submit" value="정보 수정하기" id="update_btn">
					<input type="reset" value="정보 초기화">
					<input type="button" value="사원목록" onclick="location.href='/PJFIFTH/employeeList.do'">
				</tr>
			</tfoot>
		</table>
	
	</form>
</body>
</html>