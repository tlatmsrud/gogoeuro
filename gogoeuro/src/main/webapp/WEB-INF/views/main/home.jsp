<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>WelCome GoGoEuro!</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
	$(document).ready(function(){
		function sessionCheck(){
			if(sessionStorage.getItem("id") != null){
				$(".login").attr("style","display:none");
				$(".logout").attr("style","display:block");
			}else{
				$(".logout").attr("style","display:none");
				$(".login").attr("style","display:block");
			}
		}
	    
		sessionCheck();
	    
		$('.login_go').click( function() {
	    	$(location).attr('href','loginPage');
	    });
	    
	    $('.logout_go').click( function() {
			var id = sessionStorage.getItem("id");
			sessionStorage.removeItem("id");
			console.log(id);
			location.reload(true);
		});

	  });
</script>
</head>
<body>
MAIN Page
	<div class="logout">
		<input type="button" class= "logout_go" value="로그아웃">
	</div>
	
	<div class="login">
		<input type="button" class = "login_go" value = "로그인하러가기">
	</div>
	
<div>
	
</div>
</body>
</html>
