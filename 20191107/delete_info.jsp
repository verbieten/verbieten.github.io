<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPEhtml> <!-- delete_info.jsp -->
<html><head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1"/>
<title>JDBC delete 실습</title></head>
<body>
<%
	Class.forName("com.mysql.jdbc.Driver");
	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hdbwork","hstud","gkrtod123A!");
	String sql = "DELETE FROM t20171345badge WHERE stud_id=?;";
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,"id");
	pstmt.executeUpdate();
	ResultSet rs = pstmt.executeQuery("SELECT* FROM t20171345badge where stud_id='id';");
	while(rs.next()) {
		out.println(rs.getString("stud_id"));
		out.println(rs.getString("stud_passwd"));
		out.println(rs.getString("stud_name"));
		out.println(rs.getString("stud_email"));
		out.println(rs.getString("stud_gender"));
	}
	rs.close();
	pstmt.close();
	conn.close();
%>
</body></html>
