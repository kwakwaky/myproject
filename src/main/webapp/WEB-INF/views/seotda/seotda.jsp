<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>seotda.jsp</title>
<link rel="stylesheet" href="resources/w3.css">
<link rel="stylesheet" href="resources/js/jquery-ui-1.11.4/jquery-ui.css">
<script type="text/javascript" src="resources/js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.11.4/jquery-ui.js"></script>

<style type="text/css">
	
	#box {
		border: 1px solid blue;
/* 		max-width: 500px; */
		margin: auto auto;
	}
	
	#counting1, #counting2 {
/* 		float: left; */
	}

</style>

<script type="text/javascript">
$(document).ready(function() {
	var flag = 0;
	var card1 = "";
	var card2 = "";
	
	// 패 뽑기
	$('#hit').click(function() {
		
		if (flag == 0) {
			$.getJSON('seotda/counting', function(data) {
				$('#counting1').html('<img src="resources/img/' + data +'.jpg">')
				flag = 1;
				card1 = data;
				console.log(data)
			});
		}
		
		if (flag == 1) {
			$.getJSON('seotda/counting', function(data) {
				if (card1 != data) {
					$('#counting2').html('<img src="resources/img/' + data +'.jpg">')
					flag = 2;
					card2 = data;
					console.log(data)
				}
			});
		}
		console.log(flag)
		
		if (card1 != "" && card2 != "") {
			$.post(
			    "seotda/result"					,
			    {card1: card1, card2: card2}	,
			    function(data) {
			    	$('#result').html(data)
			    }
			);
			console.log(card1 + "/" + card2)
		}
		
	});
	
	
	
	
});
</script>
</head>
<body>



<button id="hit">패 뽑기</button>

<div id="box" class="w3-padding">
	<span id="counting1"></span>
	<span id="counting2"></span>
</div>

<label id="result"></label>


</body>
</html>