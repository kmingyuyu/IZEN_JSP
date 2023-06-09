<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
   <%! String hello = "Hello.Java.Server Pages";
   
   
   String getString(String text) {
	   return text;
   }
   
   
   %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>
	<%= getString(hello) %>
	</h3>
	
</body>
</html>