<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginform.jsp</title>
<link rel="stylesheet" href="resources/w3.css">
<style type="text/css">
	form {
		max-width: 250px;
		margin: auto auto;
	}
</style>
</head>
<body>
<h1>Login Form</h1>

<form:form commandName="login" action="login" method="post" cssClass="w3-container w3-center">

<div class="w3-group">
<form:input path="email" cssClass="w3-input" required="required"/>
<!-- <input type="text" class="w3-input" required="required"> -->
<label class="w3-label">email</label>
</div>

<div class="w3-group">
<form:password path="password" cssClass="w3-input" required="required"/>
<!-- <input type="text" class="w3-input" required="required"> -->
<label class="w3-label">password</label>
</div>

<input type="submit" value="login" class="w3-btn w3-light-grey">


</form:form>

</body>
</html>