package bean.user;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;
public class Dbmain_Temp_HW {
	public static void main(String[] args){
			boolean flag = false;
			Connection conn = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch (ClassNotFoundException e)
			{
				e.printStackTrace();
			}
			PreparedStatement pstmt=null;
			String book_name, book_author, book_publish, book_genre, book_price;
			try{
				System.out.println("모두 지웁니다");
				Mdelete_HW mdelete = new Mdelete_HW();
				flag = mdelete.mdelete("all", "");
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
		}
}
