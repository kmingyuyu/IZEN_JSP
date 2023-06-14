<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" />
</head>
<body>
<div class="wrap">
	<header>
		<div style=" float: left; font-size: 12px;" >
		<span><a href="main">회원 관리 ></a><a href="info?member_no=${member.member_no}">상세 정보</a></span>
		</div>
		<div style=" float: right">
		<a class="h_a" href="edit?member_no=${member.member_no}"><button type="button">수정</button></a>
        <a class="h_a" onclick="chkDelete(${member.member_no}); return false; "><button type="button">삭제</button></a>
		</div>
	</header>
	<main>
		<div class="info_box">
			<div class="box_f" >
			<img src="${member.member_img}" alt="회원 이미지" style="width:200px; height:300px; ">
			<div class="box_t">
			<p><span>성함 : </span>${member.member_name}</p>
			<p><span>운동강도 : </span>${member.member_exercise}</p>
			<p><span>성별 : </span>${member.member_gender}</p>
			<p><span>나이 : </span>${member.member_age}</p>
			<p><span>키 : </span>${member.member_height}</p>
			<p><span>몸무게 : </span>${member.member_weight}</p>
			<p><span>핸드폰번호 : </span>${member.member_phone}</p>
			<p><span>주소 : </span>${member.member_address}</p>
			<p><span>시작 일 : </span>${member.member_reg_date}</p>
			<p><span>종료 일 : </span>${member.member_end_date}</p>
			</div>
			</div>
		</div>
		
	</main>
	<footer></footer>
</div>
<script type="text/javascript" src="./script.js"></script>
</body>
</html>