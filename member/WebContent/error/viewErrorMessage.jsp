<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page isErrorPage="true" %>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>에러메세지</title>
</head>
<body>
	에러타입 <%= exception.getClass().getName() %><br>
	에러 메세지<b> <%= exception.getMessage() %></b><br>
	
	<img alt="" src="<%= request.getContextPath() %>/image/4054104dca8ef0af15253fc99a2416dc.gif">
</body>
</html>