<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	form {
		max-width: 250px;
		margin: auto auto;
	}
</style>
<script type="text/javascript">


$(function() {

	$("#email").blur(function(){
	    var email = $('#email').val();
	    
	    $.ajax({
	    	type: "POST",
	   		url: "ajax/email", //이페이지에서 중복체크를 한다
	    	data: "email=" + email,
	   		cache: false,
	    	success: function(data){
	       		$("#emailtext").html(data); //해당 내용을 보여준다
	    	}
	    });
	});
	
	$("#passwordcheck").blur(function(){
	    var password = 'password=' + $('#password').val();
	    var passwordcheck = 'passwordcheck=' + $('#passwordcheck').val();
	    $.post(
		    "ajax/password",
		    password,
		    passwordcheck,
		    function(data) {
		    	$("#passwordtext").html(data);
		});
	   
	});
	
	 
	

});



</script>
</head>
<body>
<h1>Regist Form</h1>

<form:form commandName="regist" action="regist" method="post" cssClass="w3-container w3-center">

	
	<!-- email -->
	<div class="w3-group">
		<form:input path="email" cssClass="w3-input" required="required"/>
		<label class="w3-label">email</label>
	</div>
	<div id="emailtext"></div>
	
	<!-- password -->
	<div class="w3-group">
		<form:password path="password" cssClass="w3-input" required="required"/>
		<label class="w3-label">password</label>
	</div>
	
	<!-- passwordCheck -->
	<div class="w3-group">
		<form:password path="passwordcheck" cssClass="w3-input" required="required"/>
		<label class="w3-label">passwordCheck</label>
	</div>
	<div id="passwordtext"></div>
	
	<!-- name -->
	<div class="w3-group">
		<form:input path="name" cssClass="w3-input" required="required"/>
		<label class="w3-label">name</label>
	</div>
	
	<!-- phone -->
	<div class="w3-group">
		<form:input path="phone" cssClass="w3-input" required="required"/>
		<label class="w3-label">phone</label>
	</div>
	
	<!-- gender -->
	<div class="w3-group">
		<form:input path="gender" cssClass="w3-input" required="required"/>
		<label class="w3-label">gender</label>
	</div>
	
	<!-- birth -->
	<div class="w3-group">
		<form:input path="birth" cssClass="w3-input" required="required"/>
		<label class="w3-label">birth</label>
	</div>
	
	<!-- choice -->
	<div class="w3-group">
		<form:input path="choice" cssClass="w3-input" required="required"/>
		<label class="w3-label">choice</label>
	</div>

	<!-- regist 버튼 -->
	<input type="submit" value="Regist" class="w3-btn w3-light-grey">
	
	<form:errors cssClass="w3-margin" element="div"/>

</form:form>

</body>
</html>