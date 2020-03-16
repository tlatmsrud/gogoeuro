<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
	<fieldset class="join_form" style="text-align:center;">
		<legend class="blind">회원가입</legend>
		<form action="join" method="post">
			<div class="id_area">
				아이디 : <input type="text" maxlength=40 class = "id" name ="id" placeholder="아이디를 입력하세요">
			</div>
			<br>
			<div class="passwd_area">
				비밀번호 : <input type="text" maxlength=40 class = "passwd" name ="passwd" placeholder="비밀번호를 입력하세요">
			</div>
			<br>
			<div class="passwd_confirm_area">
				비밀번호 확인 : <input type="text" maxlength=40 class = "passwd_confirm" name ="passwd_confirm" placeholder="비밀번호를 재입력하세요">
			</div>
			<br>
			<div class="email_area">
				이메일 : <input type="text" maxlength=40 class = "email" name ="email" placeholder="이메일을 입력하세요">
			</div>
			<br>
			<div class="nickname_area">
				닉네임 : <input type="text" maxlength=40 class = "nickname" name ="nickname" placeholder="닉네임을 입력하세요">
			</div>
			<br>
			<div class="phone_area">
				휴대폰 번호 : <input type="text" maxlength=40 class = "phone" name ="phone" placeholder="휴대폰 번호를 입력하세요">
			</div>
			<br>
			<div class="join_btn_area">
				<input type="submit" class = "join_btn" value="회원가입" >
			</div>
		</form>
	</fieldset>
</div>
</body>
</html>