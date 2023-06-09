<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css"/>
</head>
<body>
	<form action="login.jsp" method="post" class="login_form">
		<div class="login_box">
		<h1>회원관리 로그인</h1>
		<label for="id"></label>
		<input type="text" name="id" id="id" placeholder="아이디"/>
		<br />
		<br />
		<label for="pw"></label>
		<input type="password" name="pw" id="pw" placeholder="비밀번호"/>
		<br />
		<br />
		<input type="submit" value="로그인" />
		<input type="reset" value="취소" />
		</div>
	</form>
</body>
</html>