<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css" />
<style>
* {
  margin: 0;
  padding: 0;
}

html {
  font-size: 15px;
}

ul,
li {
  list-style: none;
}


a {
  text-decoration: none;
  color: inherit;
  cursor:pointer;
}

.wrap {
}

h1 {
	text-align: center;
	margin : 50px 0;
}

.main_memberbox{
	display : flex;
	margin-top: 50px;
}

.memberbox_in{
	height : 200px;
	width: 130px;
	margin: 0 30px;
	border: 1px solid grey;
}

.main_img {
	background-repeat: no-repeat;
	width: 50px;
	height: 50px;
}

</style>

</head>
<body>
<c:if test="${memberList == null && error == null}">
		<jsp:forward page="main" />
	</c:if>
<div class="wrap">
<header>
		<div style="background-color: green; width:100%; height:130px;">
		<p style="float:left; color:white; font-size:20px">회원 관리</p>
		<p style="float:left; color:white; font-size:20px">Member management</p>
		</div>
</header>
<main>
		<table>
		 <thead>
          <tr>
            <th>이름</th>
            <th>핸드폰 번호</th>
            <th>시작 일</th>
            <th>종료 일</th>
          </tr>
        </thead>
        <tbody>
       <!--  for (Board board : boardList) -->
       <c:forEach var="member" items="${memberList}" varStatus="status">
       	<tr>
            <td> ${member.member_name}</td>
            <td> ${member.member_phone}</td>
            <td> ${member.member_reg_date}</td>
            <td> ${member.member_end_date}</td>
            <td><a href="info?member_no=${member.member_no}"><button type="button">상세보기</button></a></td>
        </tr>
       </c:forEach>
        </tbody>
		
		</table>

         <a href="registration">회원 추가</a>
</main>                    
 <footer></footer>
    </div>
    <script>
    	<c:if test="${param.error != null}">
    		alert("${param.error}");
    	</c:if>
    	<c:if test="${error != null}">
			alert("${error}");
		</c:if>
    </script>




</body>
</html>