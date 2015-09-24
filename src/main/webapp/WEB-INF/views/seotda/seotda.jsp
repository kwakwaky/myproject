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
	#droppable { width: 400px; height: 350px; padding: 0.5em; float: left; margin: 10px; }

</style>

<script type="text/javascript">
$(document).ready(function() {
	$('#hit').click(function() {
		$.getJSON('seotda/counting', function(data) {
			console.log(data);
		});
	});
});
</script>
</head>
<body>

<!-- <div id="droppable" class="ui-widget-header"> -->
<!-- 	<p>Drop here</p> -->
<!-- </div> -->

<button id="hit">패 뽑기</button>

<!-- <div> -->
<!-- 	<img alt="" src="resources/img/3g.jpg"> -->
<!-- 	<img alt="" src="resources/img/8g.jpg"> -->
<!-- 	<img alt="" src="resources/img/1p_1.jpg"> -->
<!-- </div> -->

</body>
</html>