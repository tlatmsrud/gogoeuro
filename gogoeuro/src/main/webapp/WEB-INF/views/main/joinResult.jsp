<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="//code.jquery.com/jquery-3.2.1.min.js">
	$(document).ready(function(){
	    $('.join_btn').click( function(){
	    	$(location).attr('href','join.jsp');
	    });
	});
	
</script>
</head>
<body>
회원가입 결과 메시지 : ${result.message}<br>
로그인 페이지로 돌아가기 버튼
</body>
</html>
