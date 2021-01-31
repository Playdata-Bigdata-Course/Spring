<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>step01hello7</title>
</head>
<body>
	step01hello7.jsp : ${param.id.hashCode()}, ${param.id2.hashCode() }
	서버의 controller에서 새로 저장된 데이터값 출력 : - ${requestScope.newData} -
</body>
</html>