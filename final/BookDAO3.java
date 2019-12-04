package book2pkg;

import java.sql.*;
import java.util.*;
import book2pkg.*;
public class BookDAO3 {
	
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	String url, user, pass;

	public BookDAO3() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		url = "jdbc:mysql://localhost:3306/hdbwork";
		user = "hstud";
		pass = "gkrtod123A!";
	}

	public int insertBook(String book_name,String book_author,String book_publish, String book_price, String book_isbn, String book_genre) throws SQLException {
		String sql = "insert into book(book_name, book_author, book_publish, book_price, book_isbn, book_genre) values (?,?,?,?,?,?);";
		try {
			conn = DriverManager.getConnection(url, user, pass);
			ps = conn.prepareStatement(sql);
			ps.setString(1,book_name);
			ps.setString(2,book_author);
			ps.setString(3,book_publish);
			ps.setString(4,book_price);
			ps.setString(5,book_isbn);
			ps.setString(6,book_genre);
			int rec_no = ps.executeUpdate();
			return rec_no;
		} finally {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}
	}

	public List<BookDTO3> findAllBook(String book_search) throws SQLException {
		String sql = "select * from book where book_name=? or book_author=? or book_publish=? or book_isbn=? or book_genre=? or book_price=?;";
		List<BookDTO3> list = new ArrayList<BookDTO3>();
		try
		{
			conn = DriverManager.getConnection(url,user,pass);
			ps = conn.prepareStatement(sql);
			ps.setString(1,book_search);
			ps.setString(2,book_search);
			ps.setString(3,book_search);
			ps.setString(4,book_search);
			ps.setString(5,book_search);
			ps.setString(6,book_search);
			ResultSet rs = ps.executeQuery();
			list = makelist(rs);
			return list;
		} finally {
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
			if (rs != null)
				rs.close();
		}
	}
	public List<BookDTO3>findNameBook(String book_search)throws SQLException{
		String sql="select * from book where book_name=?;";
		List<BookDTO3>list = new ArrayList<BookDTO3>();
		try {
			conn = DriverManager.getConnection(url,user,pass);
			ps = conn.prepareStatement(sql);
			ps.setString(1,book_search);
			
			
			ResultSet rs = ps.executeQuery();
			list = makelist(rs); 
			return list;
		} finally {
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
		}
	}	

	public List<BookDTO3>findBookAuthor(String book_search)throws SQLException{
		String sql="select * from book where book_author=?;";
		List<BookDTO3>list = new ArrayList<BookDTO3>();
		try {
			conn = DriverManager.getConnection(url,user,pass);
			ps = conn.prepareStatement(sql);
			ps.setString(1,book_search);
			
			
			ResultSet rs = ps.executeQuery();
			list = makelist(rs); 
			return list;
		} finally {
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
		}
	}
	public List<BookDTO3>findBookGenre(String book_search)throws SQLException{
		String sql="select * from book where book_genre=?;";
		List<BookDTO3>list = new ArrayList<BookDTO3>();
		try {
			conn = DriverManager.getConnection(url,user,pass);
			ps = conn.prepareStatement(sql);
			ps.setString(1,book_search);
			
			
			ResultSet rs = ps.executeQuery();
			list = makelist(rs); 
			return list;
		} finally {
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
		}
	}
	public List<BookDTO3>findBookIsbn(String book_search)throws SQLException{
		String sql="select * from book where book_isbn=?;";
		List<BookDTO3>list = new ArrayList<BookDTO3>();
		try {
			conn = DriverManager.getConnection(url,user,pass);
			ps = conn.prepareStatement(sql);
			ps.setString(1,book_search);
			
			
			ResultSet rs = ps.executeQuery();
			list = makelist(rs); 
			return list;
		} finally {
			if(ps != null)
				ps.close();
			if(conn != null)
				conn.close();
			if(rs != null)
				rs.close();
		}
	}
	public List<BookDTO3>makelist(ResultSet rs)throws SQLException{
		List<BookDTO3>list = new ArrayList<BookDTO3>();
		while(rs.next()) {
			BookDTO3 dto = new BookDTO3();
			dto.setBook_name(rs.getString("book_name"));
			dto.setBook_author(rs.getString("book_author"));
			dto.setBook_publish(rs.getString("book_publish"));
			dto.setBook_price(rs.getString("book_price"));
			dto.setBook_isbn(rs.getString("book_isbn"));
			dto.setBook_genre(rs.getString("book_genre"));
			
			list.add(dto);
		}
		return list;
	}
	
}
