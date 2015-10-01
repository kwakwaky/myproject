<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="sitemesh" tagdir="/WEB-INF/tags/sitemesh"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- w3부트스트랩을 사용하기위한 설정-->
<link rel="stylesheet" href="resources/w3.css">
<link rel="stylesheet" href="resources/js/jquery-ui-1.11.4/jquery-ui.css">
<script type="text/javascript" src="resources/js/jquery-ui-1.11.4/external/jquery/jquery.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.11.4/jquery-ui.js"></script>
<title><sitemesh:write property="title"/></title>
<sitemesh:write property="head"/>
<style type="text/css">

	.zeta-menu-bar {
		background: grey;
		display: inline-block;
		width: 100%;
	}
	
	.zeta-menu {
		margin: 0;
		padding: 0;
	}
	
	.zeta-menu li {
		float: left;
		list-style: none;
		position: relative;
	}
	
	.zeta-menu li:hover {
		background: white;
	}
	
/* 	.zeta-menu li:hover>a { */
/* 		color: hotpink; */
/* 	} */
	
	.zeta-menu a {
/* 		color: white; */
		display: block;
		padding: 10px 20px;
		text-decoration: none;
	}
	
	.zeta-menu ul {
		background: #eee;
		border: 1px solid silver;
		display: none;
		padding: 0;
		position: absolute;
		left: 0;
		top: 100%;
		width: 180px;
	}
	
	.zeta-menu ul li {
		float: none;
	}
	
	.zeta-menu ul li:hover {
		background: #ddd;
	}
	
	.zeta-menu ul li:hover a {
		color: black;
	}
	
	.zeta-menu ul a {
		color: black;
	}
	
</style>
<script type="text/javascript">
$(function() {
	$(".zeta-menu li").hover(function() {
		$('ul:first', this).show();
	}, function() {
		$('ul:first', this).hide();
	});
// 	$(".zeta-menu>li:has(ul)>a").each(function() {
// 		$(this).html($(this).html() + ' &or;');
// 	});
	$(".zeta-menu ul li:has(ul)").find("a:first").append(
			"<p style='float:right;margin:-3px'>&#9656;</p>");
});
</script>

</head>

<body>

<c:url value="/login" var="login"/>
<c:url value="/logout" var="logout"/>
<c:url value="/regist" var="regist"/>
<c:url value="/infoupdate" var="infoupdate"/>
<c:url value="/unregist" var="unregist"/>
<c:url value="/seotda" var="seotda"/>

<!-- Header -->
<nav class="w3-topnav w3-margin w3-light-grey">
	<h1 id="testani"><a href="/myproject/"><strong>Mens Health</strong></a></h1>
</nav>

<div class='zeta-menu-bar w3-light-grey'>
  <ul class="zeta-menu">
    <li><a href="#">회사소개</a></li>
    <li><a href="#">게시판</a></li>
    <li><a href="${seotda}">섯다</a></li>
    
    <c:choose>
		<c:when test="${not empty auth}">
			<li class="w3-right"><a href="${logout}">Logout</a></li>
			<li class="w3-right"><a href="#">${auth.name}</a>
				<ul>
					<li><a href="${infoupdate}">정보 조회/변경</a></li>
					<li><a href="${unregist}">회원 탈퇴</a></li>
				</ul>
			</li>
		</c:when>
		<c:otherwise>
			<li class="w3-right"><a href="${login}">Login</a></li>
			<li class="w3-right"><a href="${regist}">회원가입</a></li>
		</c:otherwise>
	</c:choose>
  </ul>
</div>

<section id="main" class="w3-container w3-margin">
	<div class="w3-center">
	<sitemesh:write property="body"/>
	</div>
</section>

</body>
</html>