package bean.user;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class Dbmain_Temp3 {
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
			String stud_id, stud_passwd, stud_name, stud_email, stud_gender;
			try{
				System.out.println("모두 지웁니다");
				Mdelete mdelete = new Mdelete();
				flag = mdelete.mdelete("all", "");
				System.out.println("홍길동 입력합니다");
				stud_id = "kdhong";
				stud_passwd = "1234";
				stud_name = "홍길동";
				stud_email = "kdhong@abc.com";
				stud_gender = "남자";
				Minsert minst = new Minsert();
				flag = minst.minsert(stud_id, stud_passwd, stud_name, stud_email, stud_gender);
				System.out.println("이몽룡 입력합니다");
				stud_id = "mrlee";
				stud_passwd = "4321";
				stud_name = "변학도";
				stud_email = "hdbyun@abc.com";
				stud_gender = "남자";
				flag = minst.minsert(stud_id, stud_passwd, stud_name, stud_email, stud_gender);
				System.out.println("입력 결과 보기");
				Mselect mselect = new Mselect();
				List<Userinfo> userlists = new ArrayList<Userinfo>();
				userlists = mselect.mselect("all","");
				for(int i =0; i<userlists.size(); i++) {
					System.out.println(userlists.get(i).getStud_id()+","+userlists.get(i).getStud_name());
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
