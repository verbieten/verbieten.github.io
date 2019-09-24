<%@page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE HTML> <!-- userLogin.jsp -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<!--[if It IE 9]>
<script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
</script>
<![endif]-->
<style>
	body{font-family: Verdana, sans-serif; font-size:0.8em;}
	header, nav, section, article, footer
	{border:1px solid gray; margin:5px; padding:8px;}
	nav ul {margin:0; padding:0;}
	nav ul li {display:inline; margin:5px;}
	.id_form {width:100px; height:14px; color:red;}
</style>
	<title>로그인 실습</title>
</head>
<body>
	<header>
	<h2>실습을 환영합니다</h2></header>
	<nav>
	<ul>
		<li><a href="www.dju.ac.kr">로그인</a></li>
		<li><a href="hive.dju.ac.kr">조회</a></li>
	</ul></nav>
	<section>
	<fieldset><legend>로그인 확인</legend>
		<label for="stud_suer">아이디</label>
		<label class="id_form"><%=request.getParameter("stud_user")%></label><br/><br/>
		<label for="stud_passwd">암호명</label>
		<label class="id_form"><%=request.getParameter("stud_passwd")%></label><br/><br/>
 	</fieldset>
	</section>
	<footer>
	<p>&copy;20XXMade by Korea. All rights reserved.</p>
	</footer>
</body>
</html> 
