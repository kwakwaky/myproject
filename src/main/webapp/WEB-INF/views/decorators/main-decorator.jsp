<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- w3부트스트랩을 사용하기위한 설정-->
<title><sitemesh:write property="title"/></title>
<sitemesh:write property="head"/>
<style type="text/css">
	
</style>
</head>

<body>

<c:url value="/login" var="login"/>
<c:url value="/regist" var="regist"/>
<!-- Header -->
<nav class="w3-topnav w3-margin w3-light-grey">
<h1><a href="/myproject/"><strong>Mens Health</strong></a></h1>
<a href="#">회사소개</a>
<a href="#">게시판</a>
<a href="#">Menu1</a>
<a href="#">Menu2</a>
<a href="#">Menu3</a>
<a href="${login}" class="w3-right">로그인</a>
<a href="${regist}" class="w3-right">회원가입</a>
</nav>



<section id="main" class="w3-container w3-margin">
	<div class="w3-center">
	<sitemesh:write property="body"/>
	</div>
</section>

</body>
</html>