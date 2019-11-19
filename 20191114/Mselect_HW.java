package bean.user;
import java.util.List;
import java.util.ArrayList;
import java.sql.*;
public class Mselect_HW
{
	private Connection conn = null;
	public List<Bookinfo> mselect(String namex, String book_name) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Bookinfo> booklists = null;
		try
		{
			booklists = new ArrayList<Bookinfo>();
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hdbwork","hstud","gkrtod123A!");
			if(namex=="all") {
				pstmt = conn.prepareStatement("select* from t20171345badge");
			}
			else
			{
				pstmt = conn.prepareStatement("select* from t20171345badge where book_name=?");
				pstmt.setString(1, book_name);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Bookinfo booklist = new Bookinfo();
				booklist.setBook_name(rs.getString("book_name"));
				booklist.setBook_author(rs.getString("book_author"));
				booklist.setBook_publish(rs.getString("book_publish"));
				booklist.setBook_genre(rs.getString("book_genre"));
				booklist.setBook_price(rs.getString("book_price"));
				booklists.add(booklist);
			}
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
			return booklists;
		}
	}
}
