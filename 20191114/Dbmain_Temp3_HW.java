package bean.user;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Dbmain_Temp3_HW {
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
				System.out.println("고양이의 하루 입력합니다");
				book_name = "고양이의 하루";
				book_author = "미스캣";
				book_publish = "학고재(도)";
				book_genre = "외국수필";
				book_price = "14,000";
				Minsert_HW minst = new Minsert_HW();
				flag = minst.minsert(book_name, book_author, book_publish, book_genre, book_price);
				System.out.println("울타리의 노래 입력합니다");
				book_name = "울타리의 노래";
				book_author = "이설빈";
				book_publish = "문학과지성사(주)";
				book_genre = "한국시";
				book_price = "9,000";
				flag = minst.minsert(book_name, book_author, book_publish, book_genre, book_price);
				System.out.println("입력 결과 보기");
				Mselect_HW mselect = new Mselect_HW();
				List<Bookinfo> booklists = new ArrayList<Bookinfo>();
				booklists = mselect.mselect("all","");
				for(int i =0; i<booklists.size(); i++) {
					System.out.println(booklists.get(i).getBook_name()+","+booklists.get(i).getBook_publish());
				}
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
