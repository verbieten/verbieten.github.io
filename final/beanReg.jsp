<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html> <!-- ~/beanReg.jsp -->
<html><head><meta charset=utf-8"/>
<meta name="viewport" content="width=device-width,initial-scale=1"/>
<style>
	* {padding:0; margin:0;}
	body {font-family: Verdana, sans-serif; font-size:0.8em}
	header, nav, section, article, aside, footer
	{margin:5px; padding:8px; text-align:center;}
	nav ul {margin:0; padding:0;}
	nav ul li {display:inline; margin:5px;}
	a:link {color:blue; text-decoration:none;}
	a:visited {color:black; text-decoration:none;}
	a:hover {text-decoration:none;}
	a:active {color:red; text-decoration:none;}
	section {height:450px;}
	.id_form {width:50px;}
	.label_form {display:inline-block; width:55px; height:14px; color:green; padding:5px;}
	.button_form {width:60px; margin-left:5px;}
	.fset {padding:15px;}
	#dupBtn {height:25px;}
	ul.level_1 > li {list-style:none; display:inline-block; vertical-align:bottom;}
	ul.level_1 > li > ul {list-style:none;}
	.level_2 li {padding-top:5px;}
	.level_2 span {display:inline-block; width:70px;}
	.level_2 input {width:100px;}
	#loginBtn button {margin-left:5px; height:42px;}
	body {
		background-image : url('background.jpg');
		background-repeat : no-repeat;
		background-size : cover;
	}
	legend {
		display: block;
		padding-left: 20px;
		padding-right: 20px;
		border: none;
	}
	fieldset {
		background:white;
		 background-color: rgba( 255, 255, 255, 0.5 );
	}
	#find_form {width:150px; height:20px; color:red;}
	table, th, td {border:1px solid black; border-collapse:collapse;}
	table {width:100%; height:80%;}
	th, td {text-align:center; padding:10px; vertical-align:bottom;}
	tr:nth-child(odd) {background-color:lightgray;}
	th {background-color:gray; color:white;}
	table.ex1 {table-layout:auto;}
</style><title>도서 관리</title></head>
<jsp:useBean id="dto2" class="book2pkg.BookDTO3"/>
<jsp:setProperty name="dto2" property="*"/>
<jsp:useBean id="dao2" class="book2pkg.BookDAO3"/>
</head>
<body><header><h1>도서 관리</h1></header>
<nav><ul>
<li><a href="./beanHome.html">메인</a></li><li><a href="./beanReg.html">도서 등록</a></li><li><a href="./beanFind.html">도서 검색</a></li></ul></nav>
<section>
<fieldset class="fset"><legend>등록 결과</legend> <!-- 자바 스크립트 함수 호출 -->
<%
	int rec_no = dao2.insertBook(dto2.getBook_name(), dto2.getBook_author(), dto2.getBook_publish(), dto2.getBook_price(), dto2.getBook_isbn(), dto2.getBook_genre());
	if (rec_no > 0) {
%>
<script> alert("성공"); location.href = "./beanHome.html"; </script>
<% } else { %>
<script> alert("실패"); location.href = "./beanHome.html"; </script>
<% } %>
</fieldset>
</section>
<footer><p>&copy; 2019 Made by 20171345. All rights reserved. </p></footer></body></html>
