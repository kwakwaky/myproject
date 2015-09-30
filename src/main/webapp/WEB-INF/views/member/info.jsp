<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>info.jsp</title>
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
	}
	
	#email_hide {
		display: none;
	}
	
</style>
<script type="text/javascript">
$(document).ready(function() {
	var flag = 0;
	if (flag == 0) {
		$('#email_update').bind('click', function() {
			$('#email_hide').show();
			flag = 1;
		});
	} else {	
		$('#email_update').bind('click', function() {
			$('#email_hide').css('display', 'none');
			flag = 0;
		});
	}
});
</script>
</head>
<body>
<h1>나의 정보</h1>

<table id="info" class="w3-table w3-striped w3-bordered w3-border">
	<tr id="email">
	  <td>E-mail</td>
	  <td>${member.email}</td>
	  <td id="email_update"><a href="#">수정</a></td>
	</tr>
	<tr id="email_hide">
		<td colspan="3">zzz</td>
	</tr>
	<tr>
	  <td>비밀번호</td>
	  <td></td>
	  <td><a>수정</a></td>
	</tr>
	<tr>
	  <td>이름</td>
	  <td>${member.name}</td>
	  <td><a>수정</a></td>
	</tr>
	<tr>
	  <td>전화번호</td>
	  <td>${member.phone}</td>
	  <td><a>수정</a></td>
	</tr>
	<tr>
	  <td>성별</td>
	  <td>${member.gender}</td>
	  <td><a>수정</a></td>
	</tr>
	<tr>
	  <td>생년월일</td>
	  <td>${member.birth}</td>
	  <td><a>수정</a></td>
	</tr>
	<tr>
	  <td>경로</td>
	  <td>${member.choice}</td>
	  <td><a>수정</a></td>
	</tr>
	<tr>
	  <td>가입일자</td>
	  <td>${member.enter}</td>
	  <td></td>
	</tr>
</table>

<c:url value="/update" var="update"/>
<a href="${update}">정보 수정</a>


</body>
</html>