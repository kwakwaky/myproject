<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<form action="" class="w3-container w3-center">

<div class="w3-group w3-center">
<input type="text" class="w3-input" required="required">
<label class="w3-label">email</label>
</div>

<div class="w3-group">
<input type="text" class="w3-input" required="required">
<label for="password" class="w3-label">password</label>
</div>

<input type="submit" value="login" class="w3-btn w3-light-grey">

</form>

</body>
</html>