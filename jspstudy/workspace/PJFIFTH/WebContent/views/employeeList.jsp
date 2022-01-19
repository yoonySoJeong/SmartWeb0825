<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>EmployeeList</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>

<style>
	.wrap{
		width: 800px;
		margin: 0 auto;
	}
	.title {
		text-align: center;
		color: yellowgreen;
	}

	table {
		width: 100%;
		border-collapse: collapse;
	}
	
	table td {
		border-top: 1px solid gray;
		border-bottom: 1px solid gray;
		text-align: center;
		padding: 3px 5px;
	}

</style>

<script>
	$(document).ready(function(){
		$('.update_btn').on('click', function(){
			let eno = $(this).prev().val();
			location.href='/PJFIFTH/employeeDetail.do?eno=' + eno;
		}) // end of update btn function
		
		$('.delete_btn').on('click', function(){
			if(confirm('삭제할까요?')){
				location.href='/PJFIFTH/deleteEmployee.do?eno=' + $(this).data('eno');
			}
		}) // end of delete btn function
	})

</script>


</head>
<body>

	<div class="wrap">
		<h1 class="title">직원 전체 목록</h1>
		<div class="btn_area">
			<button id="insert_btn" onclick="location.href='/PJFIFTH/insertForm.do'">직원 등록하기</button>
		</div>
		<table border="1">
			<caption>전체 직원 수 : ${totalCount} 명</caption>
			<thead>
				<tr>
					<td>사원번호</td>
					<td>사원이름</td>
					<td>사원부서</td>
					<td>사원급여</td>
					<td>근무시작일</td>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list}">
					<tr>
						<td colspan="5">표시할 사원이 없습니다.</td>
					</tr>
				</c:if>
				<c:if test="${not empty list}">
					<c:forEach items="${list}" var="employee">
						<tr>
							<td>${employee.eno}</td>
							<td>${employee.name}</td>
							<td>${employee.depart}</td>
							<td>${employee.salary}</td>
							<td>${employee.hire}</td>
							<td>
							<input type="hidden" value="${employee.eno}">
							<input class="update_btn" type="button" value="수정">
							<input data-eno="${employee.eno}" class="delete_btn" type="button" value="삭제">
							</td>
						</tr>
					</c:forEach>
				</c:if>
			</tbody>
			<tfoot>
				<c:if test="${totalCount eq 0}">
					<tr>
						<td colspan="5">표시할 급여 없음</td>
					</tr>
				</c:if>
				<c:if test="${totalCount gt 0}">
					<tr>
						<td colspan="2">평균급여</td>
						<td colspan="3"><fmt:formatNumber value="${average}" pattern="0.00"></fmt:formatNumber></td>
					</tr>
				</c:if>
			</tfoot>			
		</table>
		
	
	</div>


</body>
</html>