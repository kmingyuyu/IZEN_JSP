<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<span><a href="main">회원 관리 ></a><a href="info?member_no=${member.member_no}">상세 정보 ></a><a href="edit?member_no=${member.member_no}">회원 정보 수정</a></span>
		</div>
	</header>
	<main>
	<div class="registration_box">
		 <form name="frm" method="post" action="update?member_no=${member.member_no}" enctype="multipart/form-data">
          <h1>기본 정보</h1>
            <dl>
              <dt>이름</dt>
              <dd><input type="text" name="member_name" maxlength="10" placeholder="ex) 홍길동" value="${member.member_name}" /></dd>
            </dl>
            <dl>
              <dt>핸드폰 번호</dt>
              <dd><input type="text" name="member_phone" maxlength="20" placeholder="ex) 010-1111-1111" value="${member.member_phone}" /></dd>
            </dl>
            <dl>
              <dt>등록 일</dt>
              <dd><input type="text" name="member_reg_date" maxlength="20" placeholder="ex) 2023-01-01" value="${member.member_reg_date}"  /></dd>
            </dl>
            <dl>
              <dt>종료 일</dt>
              <dd><input type="text" name="member_end_date" maxlength="20" placeholder="ex) 2023-01-01" value="${member.member_end_date}" /></dd>
            </dl>
           
          <h1>상세 정보</h1>
             <select name="member_gender" >
          		<option value="" >--선택--</option>
          		<option value="남성" >남성</option>
          		<option value="여성" >여성</option>
          </select>
             <dl>
              <dt>나이</dt>
              <dd><input type="text" name="member_age" maxlength="10" placeholder="글쓴이 입력" value="${member.member_age}" /></dd>
            </dl>
             <dl>
              <dt>키</dt>
              <dd><input type="text" name="member_height" maxlength="10" placeholder="글쓴이 입력" value="${member.member_height}"  /></dd>
            </dl>
             <dl>
              <dt>몸무게</dt>
              <dd><input type="text" name="member_weight" maxlength="10" placeholder="글쓴이 입력" value="${member.member_weight}"  /></dd>
            </dl>
             <dl>
              <dt>주소</dt>
              <dd><input type="text" name="member_address" maxlength="10" placeholder="글쓴이 입력" value="${member.member_address}"  /></dd>
            </dl>    
          <select name="member_exercise">
          		<option value="거의 운동 X" selected>거의 운동 X</option>
          		<option value="가벼운 운동(주1-3)" >가벼운 운동(주1-3)</option>
          		<option value="적당한 운동(주3-5)" >적당한 운동(주3-5)</option>
          		<option value="활동적인 운동(주5-7)" >활동적인 운동(주5-7)</option>
          </select>
          <div style="padding-top:10px">
              <label style="font-size:1.4rem; padding-right: 20px;" for="file">이미지 업로드</label>
              <input type="file" name="file" id="file"/>
        </div>
       </form>
        <div style="margin-top:20px;">
          <a onclick="chkForm(); return false;"><button type="button">수정</button></a>
          <a href="main"><button type="button">취소</button></a>
		</div>
	</div>
	</main>
	<footer></footer>
	</div>
	<script type="text/javascript" src="./script.js"></script>
</body>
</html>