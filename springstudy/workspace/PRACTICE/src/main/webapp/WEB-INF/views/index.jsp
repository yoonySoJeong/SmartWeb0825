<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index Page</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
</head>
<body>


<input type="text" placeholder="이름입력" id="name" name="name">
<input type="text" placeholder="비번입력" id="pw" name="pw">
<input type="submit" value="제출하기" onclick="fnSendUserInfo()">
<script type="text/javascript">
	function fnSendUserInfo(){
		
		let name = $('#name').val();
		let pw = $('#pw').val();
		
		location.href="/login.do?name=" + name + "&pw=" + pw;
		
	}
</script>


</body>
</html>