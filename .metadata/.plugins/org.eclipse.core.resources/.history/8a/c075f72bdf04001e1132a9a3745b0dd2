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
	<h2>고객 정보</h2> [<a href="/jsp_Study/customerControl"> 새로고침 </a>]
	<hr>
	<table border=1>
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>전화번호</th>
			<th>등급</th>
			<th>핸드폰 번호</th>
		</tr>
		<c:forEach var="p" items="${qs}">
		<tr>
			<td>
			${p.id}
			</td>
			<td>
			${p.name}
			</td>
			<td>
			${p.address}
			</td>
			<td>
			${p.grade}
			</td>
			<td>
			${p.phone} 
			</td>
		</tr>
		</c:forEach>
	</table>
	
	<h2>고객 등록</h2>
	<hr>
	<form action="/jsp_Study/customerControl?action=insert" method="post">
	<label></label><input type="text" name="name" placeholder="이름"/><br/>
	<label></label><input type="text" name="address" placeholder="주소"/><br/>
	<label></label><input type="text" name="grade" placeholder="등급"/><br/>
	<label></label><input type="text" name="phone" placeholder="핸드폰번호"/><br/>
	<br/>
	<button type="submit">등록</button>
	</form>
</body>
</html>