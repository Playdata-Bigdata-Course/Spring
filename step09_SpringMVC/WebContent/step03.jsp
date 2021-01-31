<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>

<%
	// test�� Cookie ������ �����ؼ� client���� ����
	/*	spring ����� sub controller���� 
		@CookieValue("key�̸�")���� ������ Ȱ��
	*/
	Cookie c = new Cookie("id", "cookieData");
	c.setMaxAge(60 * 60);
	response.addCookie(c);

	//test�� Session ������ ����
	session.setAttribute("id", "tester");
	session.setAttribute("age", 100);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>step03.jsp</title>
<style type="text/css">
/* a link ���� */
a {
	text-decoration: none;
}
</style>
</head>
<body>

<h2>Spring ����� ���� ���� ���</h2>
	<br><hr><br>
	
	* test�� ���� ��Ű�� ���� �����ʹ� �ش� jsp���� �������� <br>	
	

	<br><hr><br>
	<h3>[1] Cookie API Ȱ��</h3>
	<a href="sessiontracking/cookietest">1.sessiontracking/cookietest & @CookieValue</a>
	
	<br><hr><br>
	<h3>[2] HttpSession API Ȱ��</h3>
	<a href="sessiontracking/sessionTest1">2-1. HttpSession API Ȱ�� </a>
	
	<br><br>
	<a href="sessiontracking/sessionTest2">2-2. @SessionAttributes �����ϱ� </a>
	
	<br><br>
	
	<a href="sessiontracking/sessionTest3DTO?id=khk&age=20">2-3. DTO ��ü�� ���ǿ� ����(name, age ������ ����)</a>

</body>
</html>