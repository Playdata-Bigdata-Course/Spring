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
	<a href="sessiontracking/sessionDelete">1.HttpSession API�� ����</a>
	<br>
	<a href="sessiontracking/sessionDelete2">2.Spring API�� ����</a>
	
	<br><hr><br>
	���ǿ� cust��� key�� ����� Customer ������ : ${sessionScope.cust.id}
</body>
</html>