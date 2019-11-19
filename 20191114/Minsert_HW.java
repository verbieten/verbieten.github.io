package bean.user;
import java.sql.*;
public class Minsert_HW {
	private Connection conn=null;
	public boolean minsert(String book_name, String book_author, String book_publish, String book_genre, String book_price) throws SQLException {
		boolean flag = false;
		PreparedStatement pstmt=null;
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hdbwork","hstud","gkrtod123A!");
			String sql = "INSERT INTO t20171345badge (book_name, book_author, book_publish, book_genre, book_price) VALUES (?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,book_name);
			pstmt.setString(2,book_author);
			pstmt.setString(3,book_publish);
			pstmt.setString(4,book_genre);
			pstmt.setString(5,book_price);
			pstmt.executeUpdate();
			flag=true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try
			{
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		return flag;
	}
}
