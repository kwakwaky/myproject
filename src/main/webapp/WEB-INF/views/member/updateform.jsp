<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/w3.css">
<link rel="stylesheet" href="resources/js/jquery-ui-1.11.4/jquery-ui.css">
<script type="text/javascript" src="resources/js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.11.4/jquery-ui.js"></script>

<style type="text/css">
	#info {
		max-width: 400px;
		margin: auto auto;
		font-family: '맑은 고딕';
	}
	
	td:first-child {
		font-weight: 900;
		width: 100px;
	}
	
	#input {
		display: none;
	}
	
	a[id$='cancle'] {
		margin-left: 10px;
	}
	
	
	
</style>
<script type="text/javascript">
$(document).ready(function() {
	
	$('#info').addClass('w3-table w3-bordered w3-border');
	$('a[id^="update"]').addClass('w3-right');
	$('a[id^="radio"]').addClass('w3-right');
	
	// 변경하기 버튼
	$('a[id="update-update"]').click(function() {
		$(this).parent().hide();
		$(this).parent().parent().children('#input').show();
	});
	
	// 취소 버튼
	$('a[id="update-cancle"]').click(function() {
		var text = $(this).parent().next().children('label').text();
// 		var value = $(this).parent().children('input').val();
// 		console.log(text);
		// 취소했으니까 원래값을 도로 집어넣었다.
		$(this).prev().val(text);
		$(this).parent().hide();
		$(this).parent().parent().children('#text').show();
	});
	
	// 완료 버튼
	$('a[id="update-complete"]').click(function() {
		var value = $(this).parent().children('input').val();
		//console.log(value);
		$(this).parent().parent().children('#text').children('label').text(value);
		$(this).parent().hide();
		$(this).parent().parent().children('#text').show();
	});
	
	// radio 변경하기 버튼
	$('a[id="radio-update"]').click(function() {
		$(this).parent().hide();
		$(this).parent().prev().show();
	});
	
	// radio 취소 버튼
	$('a[id="radio-cancle"]').click(function() {
		var text = $(this).parent().next().children('label').text();
// 		var sibal = $('label:contains('+ text +')').prev().attr("checked", true);
// 		var value = "";
// 		if (text == "남자") {
// 			value = "male";
// 		} else if (text == "여자") {
// 			value = "female";
// 		} else {
// 			value = "quitar";
// 		}
// 		console.log(text + "zz");
// 		console.log(value + "xx");
// 		console.log(sibal + "/ kkk");
		$('label:contains('+ text +')').prev().attr("checked", true);
// 		$('input:radio[name=gender]:input[value='+value+']').attr("checked", true);
		$(this).parent().hide();
		$(this).parent().parent().children('#text').show();
	});
	
	// radio 완료 버튼
	$('a[id="radio-complete"]').click(function() {
		var value = $(':radio[name="gender"]:checked').next().text();
		console.log(value + "zz");
		$(this).parent().parent().children('#text').children('label').text(value);
		$(this).parent().hide();
		$(this).parent().parent().children('#text').show();
	});
	
	
});
</script>
</head>
<body>
<h1>Update Form</h1>

<form:form commandName="update" action="update" method="post">
<table id="info">
	
	<tr><!-- Email -->
		<td>E-mail</td>
		<td id="input">
			<form:input path="email" value="${member.email}"/>
			<a href="#" id="update-cancle">취소</a>
			<a href="#" id="update-complete">완료</a>
		</td>
		<td id="text">
			<label>${member.email}</label>
			<a href="#" id="update-update">변경하기</a>
		</td>
		<td></td>
	</tr>

	<tr><!-- name -->
		<td>이름</td>
		<td id="input">
			<form:input path="name" value="${member.name}"/>
			<a href="#" id="update-cancle">취소</a>
			<a href="#" id="update-complete">완료</a>
		</td>
		<td id="text">
			<label>${member.name}</label>
			<a href="#" id="update-update">변경하기</a>
		</td>
		<td></td>
	</tr>
	
	<tr><!-- phone -->
		<td>전화번호</td>
		<td id="input">
			<form:input path="phone" value="${member.phone}"/>
			<a href="#" id="update-cancle">취소</a>
			<a href="#" id="update-complete">완료</a>
		</td>
		<td id="text">
			<label>${member.phone}</label>
			<a href="#" id="update-update">변경하기</a>
		</td>
		<td></td>
	</tr>
	
	<tr><!-- gender -->
		<td>성별</td>
		<td id="input">
			<form:radiobuttons path="gender" items="${genderlist}" />
			<a href="#" id="radio-cancle">취소</a>
			<a href="#" id="radio-complete">완료</a>
		</td>
		<td id="text">
			<label>${member.gender}</label>
			<a href="#" id="radio-update">변경하기</a>
		</td>
		<td></td>
	</tr>
	
	<tr><!-- birth -->
		<td>생년월일</td>
		<td id="input">
			<form:input path="birth" value="${member.birth}"/>
			<a href="#" id="update-cancle">취소</a>
			<a href="#" id="update-complete">완료</a>
		</td>
		<td id="text">
			<label>${member.birth}</label>
			<a href="#" id="update-update">변경하기</a>
		</td>
		<td></td>
	</tr>
	
	<tr><!-- choice -->
		<td>경로</td>
		<td id="input">
			<form:input path="choice" value="${member.choice}"/>
			<a href="#" id="update-cancle">취소</a>
			<a href="#" id="update-complete">완료</a>
		</td>
		<td id="text">
			<label>${member.choice}</label>
			<a href="#" id="update-update">변경하기</a>
		</td>
		<td></td>
	</tr>
	
	<tr>
		<td>가입일자</td>
		<td>${member.enter}</td>
	</tr>
</table>

<input type="submit" value="정보 수정" class="w3-btn w3-light-grey w3-margin">

</form:form>

</body>
</html>