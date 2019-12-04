<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %> <%@ page import="book2pkg.BookDTO3" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html> <!-- ~/beanResult.jsp -->
<html><head><meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
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
</style><title>도서 관리</title>
<jsp:useBean id="dto2" class="book2pkg.BookDTO3" scope="session"/>
<jsp:useBean id="dao2" class="book2pkg.BookDAO3" scope="session"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<%!
	boolean isNotEmpty(String str)
	{
		if((str == null) || str.equals("")) return false;
		return true;
	}
%>
</head>
<body>
<header><h1>도서 관리</h1></header>
<nav><ul>
<li><a href="./beanHome.html">메인</a></li><li><a href="./beanReg.html">도서 등록</a></li><li><a href="./beanFind.html">도서 검색</a></li></ul></nav>
<section>
<fieldset class="fset"><legend>검색 결과</legend>
<div style="overflow-x:auto; overflow-y:auto;">
	<table class="ex1">
		<tr><th>도서명</th><th>작가명</th><th>출판사</th><th>가격</th><th>ISBN</th><th>종류</th></tr>
<% String search_select=request.getParameter("search_select");
String book_search=request.getParameter("book_search");
List<BookDTO3> list = new ArrayList<BookDTO3>();
if(!isNotEmpty(search_select) || !isNotEmpty(book_search)){
 response.sendRedirect("./beanFind.html");
}
if("book_all".equals(search_select)){
    list = dao2.findAllBook(book_search);
  }else if("book_name".equals(search_select)){
    list = dao2.findNameBook(book_search);
  }else if("book_author".equals(search_select)){
    list = dao2.findBookAuthor(book_search);
  }else if("book_genre".equals(search_select)){
    list = dao2.findBookGenre(book_search);
  }else if("book_isbn".equals(search_select)){
    list = dao2.findBookIsbn(book_search);
  }
  for(int i=0;i<list.size();i++){
%>
<tr><td><%=list.get(i).getBook_name()%></td>
<td><%=list.get(i).getBook_author()%></td>
<td><%=list.get(i).getBook_publish()%></td>
<td><%=list.get(i).getBook_price()%></td>
<td><%=list.get(i).getBook_isbn()%></td>
<td><%=list.get(i).getBook_genre()%></td></tr>
<% } %>
</table>
</div>
</fieldset>
</section>
<footer><p>&copy; 2019 Made by 20171345. All rights reserved. </p></footer></body></html>
