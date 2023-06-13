<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="wrap">
	<header>
	<div style="background-color: green; width:100%; height:130px;">
		<p style="float:left; color:white; font-size:20px">회원 관리</p>
		<p style="float:left; color:white; font-size:20px">Member management</p>
	</div>
	</header>
	<main>
		<div>
			<img src="${member.member_img}" alt="회원 이미지" style="width:50px; height:50px; ">
		</div>
		<div>
			<p>성함 : ${member.member_name}</p>
			<p>운동강도 : ${member.member_exercise}</p>
			<p>성별 : ${member.member_gender}</p>
			<p>나이 : ${member.member_age}</p>
			<p>키 : ${member.member_height}</p>
			<p>몸무게 : ${member.member_weight}</p>
			<p>핸드폰번호 : ${member.member_phone}</p>
			<p>주소 : ${member.member_address}</p>
			<p>시작 일 : ${member.member_reg_date}</p>
			<p>종료 일 : ${member.member_end_date}</p>
		</div>
		<div>
			<a href="main">목록</a>
          <a href="edit?member_no=${member.member_no}">수정</a>
		</div>
	</main>
	<footer></footer>
</div>
</body>
</html>