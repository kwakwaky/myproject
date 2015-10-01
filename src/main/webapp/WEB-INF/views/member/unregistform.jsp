<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>unregistform.jsp</title>
<link rel="stylesheet" href="resources/w3.css">
<link rel="stylesheet" href="resources/js/jquery-ui-1.11.4/jquery-ui.css">
<script type="text/javascript" src="resources/js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.11.4/jquery-ui.js"></script>

<style type="text/css">
	button[id^=question] {
		display: none;
	}
</style>

<script type="text/javascript">
$(document).ready(function() {
	
	$('#unregist-btn').click(function() {
		var password = $(this).prev().val();
		
		$.post(
		    "unregist"			,
		    {password: password},
		    function(map) {
		    	$("#unregist-label").html(map.a);
		    	
		    	if (map.b == 'success') {
		    		$('button[id^=question]').show();
		    		$("#unregist-btn").hide();
		    		$("#unregist-btn").prev().hide();
		    	}
		    	
		    }
		);
		console.log(password)
	});
	
	$('#question-yes').click(function() {
		alert("꺼져")
	});
	
});
</script>

</head>
<body>
<h1>회원 탈퇴</h1>



<div>
	<label id="unregist-label">회원 탈퇴를 위해 비밀번호를 입력하세요.</label><br>
	<div>
		<a href="unregist/action"><button id="question-yes">예</button></a>
		<a href="/myproject/"><button id="question-no">아니오</button></a>
	</div>
	<input type="text" class="w3-input" style="display: inline-block;">
	<button id="unregist-btn" class="w3-btn w3-margin">회원 탈퇴</button>
</div>

</body>
</html>