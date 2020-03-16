<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function(){
	    $(".join_btn").click(function(){
	    	$(location).attr('href','joinPage');
	    });
	});
</script>
</head>
<body>
client_ip : <%= request.getAttribute("client_ip") %>

<div>
	<fieldset class="login_form" style="text-align:center;width:30px;">
		<legend class="blind">로그인</legend>
		<form action="login" method="post">
			<div class="id_area">
				<input type="text" maxlength=40 class = "id" name ="id" placeholder="아이디">
			</div>
			<br>
			<div class="pw_area">
				<input type="text" maxlength=40 class = "pw" name ="passwd" placeholder="비밀번호">
			</div>
			<div class="login_btn_area">
				<br>
				<input type="submit" class = "login_btn" value="로그인" >&nbsp&nbsp
				<input type="button" class = "join_btn" value="회원가입" >
			</div>
		</form>
		
	</fieldset>
</div>
</body>
</html>
