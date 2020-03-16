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
		var message = "${result.message}";
		var result = "${result.result}";
		var id = "${result.body.userId}";

		alert(message);	
		alert(result);
		pageMove(result);
		
		function pageMove(result){
			if(result=="true"){
				sessionStorage.setItem("id",id);
				$(location).attr('href','home');
			}else{
				$(location).attr('href','loginPage');
			}
		}
	})
</script>
</head>
<body>
<div>
	
</div>
</body>
</html>
