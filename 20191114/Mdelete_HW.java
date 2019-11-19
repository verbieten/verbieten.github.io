package bean.user;
import java.sql.*;
public class Mdelete_HW {
	private Connection conn=null;
	public boolean mdelete(String namex, String book_name) throws SQLException {
		boolean flag = false;
		PreparedStatement pstmt=null;
		try{
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/hdbwork","hstud","gkrtod123A!");
			if(namex=="all") {
				pstmt = conn.prepareStatement("DELETE FROM t20171345badge");
			}
			else
			{
				pstmt = conn.prepareStatement("DELETE FROM t20171345badge WHERE book_name=?;");
				pstmt.setString(1,book_name);
			}
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
