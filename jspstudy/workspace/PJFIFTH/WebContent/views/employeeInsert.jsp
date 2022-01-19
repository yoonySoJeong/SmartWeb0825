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
<title>Insert Employee Form</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

	<script>
		$(document).ready(function(){
			fnNameCheck();
			
			$('#name').on('keyup blur', fnNameCheck);
			$('#depart').on('keyup blur', fnDepartCheck);
			$('#salary').on('keyup blur', fnSalaryCheck);
			
			$('#fo').on('submit', function(event){
				if(namePass == false) {
					alert('이름은 필수 입력사항입니다.');
					$('#name').focus();
					event.preventDefault();
					return false;
				}else if(departPass == false) {
					alert('부서는 필수 입력사항입니다.');
					$('#depart').focus();
					event.preventDefault();
					return false;
				} else if(salaryPass == false) {
					alert('연봉은 0이상 입력해야합니다.');
					$('#salary').focus();
					event.preventDefault();
					return false;
				}
				return true;
			})
			
		});
		
		let namePass = false;
		let departPass = false;
		let salaryPass = false;
		
		/* name check function */
		function fnNameCheck(){
			if( $('#name').val() == '') {
				namePass = false;
			} else {
				namePass = true;
			}
		};
		/* depart check function */
		function fnDepartCheck(){
			if( $('#depart').val() == '') {
				departPass = false;
			} else {
				departPass = true;
			}
		};
		/* salary check function */
		function fnSalaryCheck(){
			if( isNaN($('#salary').val()) || $('#salary').val() < 0) {
				salaryPass = false;
			} else {
				salaryPass = true;
			}
		};
		
	</script>




</head>
<body>

	<div class="wrap">
		<h1 class="title">사원 등록 화면</h1>
	</div>
	<form id="fo" action="/PJFIFTH/insertEmployee.do" method="post">
		<table>
			<tbody>
				<tr>
					<td>사원이름</td>
					<td><input type="text" name="name" id="name" autofocus></td>
				</tr>
				<tr>
					<td>사원부서</td>
					<td><input type="text" name="depart" id="depart"></td>
				</tr>
				<tr>
					<td>사원급여</td>
					<td><input type="text" name="salary" id="salary" autofocus></td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="3">
					<input type="submit" value="사원등록하기" id="insert_btn">
					<input type="reset" value="입력초기화">
					<input type="button" value="사원목록" onclick="location.href='/PJFIFTH/employeeList.do'">
				</tr>
			</tfoot>
		</table>
	
	</form>
</body>
</html>