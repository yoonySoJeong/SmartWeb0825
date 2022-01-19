<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<style>
	.wrap {
		display: flex;
		justify-content: center;
	}
	.left, .right {
		padding: 10px;
	}
</style>

<script type="text/javascript">
	$(document).ready(function(){
		fn_papago();
		fn_choice();
	})// onload function
	
	function fn_papago(){
		$('#btn').on('click', function(){
			$.ajax({
				url : 'translate.do',
				type: 'post',
				data: JSON.stringify({
						"source" : $('#source').val(),  // "source": "from"
						"target" : $('#target').val(),  // "target": "to"
						"text"   : $('#text').val()     // "text"  : "inputText"
				}),
				contentType: 'application/json',
				dataType: 'json',
				success: function(result) {
					$('#translated').val(result.message.result.translatedText); // show only the translated Text
				},
				error: function(xhr) {
					alert('실패');
					console.log(xhr.responseText);
				}
			}) // ajax
		})// click event
	}// papago function
	
	function fn_choice(){
		$('#source').on('change', function(){
			if($(this).val() == '') {
				$('#target').val('');
			} else if ($(this).val() == 'ko') {
				$('#target').val('en');
			} else if ($(this).val() == 'en')
				$('#target').val('ko');
		}) // change function	
	}
	
	
	
	/*
		result -- json이 받아온 객체
	   { 
		   "message":{
			   "@type":"response",
		   	   "@service":"naverservice.nmt.proxy",
		       "@version":"1.0.0",
		       "result":{
		    	   "srcLangType":"ko",								   -- from
		    	   "tarLangType":"en",								   -- to
		    	   "translatedText":"Hello, how are you doing today?", -- translatedText
		    	   "engineType":"N2MT","pivot":null}
			}
		}

	
	
	
	
	
	*/
	

</script>

</head>
<body>
	<!-- { "SOURCE" : "KO", "TARGET" : "EN", "TEXT":"번역할 텍스트" } -->
	<h1 style="text-align: center;">파파고 번역하기</h1>
	
	<div class="wrap">
	
		<div class="left">
			<form>
				<select id="source"> <!-- CHANGE EVENT  -->
					<option value="">언어선택</option>
					<option value="ko">한국어</option>
					<option value="en">영어</option>				
				</select><br>
				<textarea rows="20" cols="60" id="text" placeholder="번역할 내용 입력"></textarea><br>
				<input type="button" value="번역하기" id="btn">
			</form>
		</div>
		
		<div class="right">
			<form>
				<select id="target">
					<option value=""></option>
					<option value="ko">한국어</option>
					<option value="en">영어</option>
				</select><br>
				<textarea rows="20" cols="60" id="translated"></textarea><br>
			</form>
		</div>
		
	</div>

</body>
</html>