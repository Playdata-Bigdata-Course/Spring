<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>step03Session1.jsp</title>
</head>
<body>
	step03Session1.jsp : ${sessionScope.newData}, ${sessionScope.id} , ${sessionScope.age }
	<br><hr><br>
	<a href="sessiontracking/sessionDelete">1.HttpSession API로 삭제</a>
	<br>
	<a href="sessiontracking/sessionDelete2">2.Spring API로 삭제</a>
	
	<br><hr><br>
	세션에 cust라는 key로 저장된 Customer 데이터 : ${sessionScope.cust.id}
</body>
</html>