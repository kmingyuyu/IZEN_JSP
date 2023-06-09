<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    html, body {
    	height: 100%;
    	margin: 0;
    }
    
    form {
    	height: 100%;
    	display: flex;
    	align-items: center;
    }
    
	label {
		width: 70px;
		display: inline-block;
	}
	
	div {
		width: 300px;
		margin: 0 auto;
	}
	
	h1 {
		font-size: 20px;
	}

</style>

<!-- jquery -->
<script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-pvPw+upLPUjgMXY0G+8O0xUf+/Im1MZjXxxgOcBQBXU=" crossorigin="anonymous"></script>
</head>
<body>
<%
Cookie[] c = request.getCookies();
if (c != null) {
	for (Cookie cf : c) {
		if (cf.getName().equals("loginChk") && cf.getValue().equals("Y")) {
			System.out.println(cf.getValue());
			%>
			<script>
			$(function(){				
				$("#loginChk").prop("checked", true);
			});
			</script>
			<%
		} else {
			%>
			<script>
			$(function(){				
				$("#loginChk").prop("checked", false);
			});
			</script>
			<%
		}
	}
}
%>
<form action="login.jsp" method="post">
	<div>	
		<h1>관리시스템 로그인</h1>
        <label for="id">아이디</label>
        <input type="text" name="id" id="id" />
        <br />
        <label for="pw">비밀번호</label>
        <input type="password" name="pw" id="pw" />
		<br />
		<br />
		<input type="checkbox" name="loginChk" id="loginChk"/> 아이디 기억
		<br />
		<input type="submit" value="로그인" /> 
		<input type="reset" value="취소" />
	</div>
</form>
</body>
</html>