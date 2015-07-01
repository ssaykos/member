<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>404 에러 발생</title>
</head>
<body>
	<div>
		<img src="<%= request.getContextPath() %>/image/404.png" alt="" />
	</div>
	<!-- 
	http(HyperText Transfer Protocol) 보안이 취약하다. 이를 자바의 서블릿에서 해결했고 너무 심해서 세션이 나와서 보정을 햇다.
	는 응답상태 코드를 이용하여 서버의 처리결과를 웹브라우저에 알려주며 
	주요 응답상태는 코드로는 다음 같은것들이 존재한다.
	200 - OK
	307 - 임시 리다이렉트
	400 - 문법 에러
	403 - 접근불가..(관리자만 접근 가능)
	404 - URL 에 따른 페이지가 존재하지 않음
	405 - 요청된 메소드는 허용 불가 (get방식, post방식) 일때..
	500 - 서버 내부 에러.. JSP 에서 익셉션이 발생했을 경우
	503 - 서버부하..예)DDOS
	
	JSP 가 정상적으로 실행되는 응답코드로 200이 전송되며,
	response.sendReddirect()를 이용할경우 응답코드로 307이 전송된다.
	(디버깅 할 때 쓴다.)
	-->
</body>
</html>