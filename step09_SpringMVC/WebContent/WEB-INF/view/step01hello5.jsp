<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>step01hello5.jsp</title>
</head>
<body>
	step01hello5.jsp : <br>
	
	1. controller에서 저장한 데이터 : ${requestScope.newData }<br>
	2. html에서 parameter(web query string)로 넘긴 데이터 : ${param.id } - ${param.age }
</body>
</html>