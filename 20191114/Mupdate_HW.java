package bean.user;
import java.sql.*;
public class Mupdate_HW
{
	private Connection conn = null;
	public boolean mupdate(String book_name, String book_author, String book_publish, String book_genre, String book_price) throws SQLException {
		boolean flag = false;
		PreparedStatement pstmt = null;
		try
		{
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hdbwork","hstud","gkrtod123A!");
			String sql = "UPDATE t20171345badge SET book_author=?, book_publish=?, book_genre=?, book_price=? WHERE book_name=?;";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(5,book_name);
			pstmt.setString(1,book_author);
			pstmt.setString(2,book_publish);
			pstmt.setString(3,book_genre);
			pstmt.setString(4,book_price);
			pstmt.executeUpdate();
			flag = true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
			return flag;
		}
	}
}
