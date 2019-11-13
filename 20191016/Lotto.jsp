<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPEhtml> <!-- Lotto.jsp -->
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<jsp:useBean id="lotto" class="bean.user.Lotto2">
<jsp:setProperty name="lotto" property="num" value=" "/>
</jsp:useBean>
<title>Lotto 실습</title></head>
<body>
<h2> LOTTO </h2>
	<jsp:getProperty name ="lotto" property="num"/><br/>
<a href=Lotto.jsp>로또 번호 재생성 </a>
</body>
</html>
