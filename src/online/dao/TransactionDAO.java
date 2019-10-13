package online.dao;

import java.sql.*;
import java.util.ArrayList;

public class TransactionDAO {
	
	 private String driver="com.mysql.jdbc.Driver";
		
		private String jdbcurl="jdbc:mysql://localhost/transaction";
		
		private String username="root";
		
		private String password="root";
	
		private Connection con;
		
		private PreparedStatement pstmt,getpstmt;
		
		private String createsql="INSERT INTO HISTORY(ACCOUNTNO,T_DATE,T_TYPE,AMOUNT) VALUES (?,?,?,?)";
		
		
		private String getsql="SELECT T_ID,T_DATE,T_TYPE,AMOUNT FROM HISTORY WHERE ACCOUNTNO=?";
		
		public TransactionDAO()throws ClassNotFoundException,SQLException
		
		{

			Class.forName(driver);
			con=DriverManager.getConnection(jdbcurl,username,password);
			System.out.println("Connection established....");
			pstmt=con.prepareStatement(createsql);
			getpstmt=con.prepareStatement(getsql);
			
		}
		
		 public void create(Transaction c) throws SQLException
		 	
		 {
		 		//pstmt.setInt(1,c.getAccno());
			 
			 pstmt.setInt(1,c.getAccno());
		 		pstmt.setString(2,c.getTdate());
		 		
		 		pstmt.setString(3,c.getTtype());
		 		
		 		pstmt.setDouble(4,c.getAmount());
		 		
		 	
		 		
		 		/*pstmt.setString(4,c.getActype());
		 		//pstmt.setString(13,c.getAcno());
		 		pstmt.setString(5,c.getUsername());
		 		pstmt.setString(6,c.getPassword());
		 		pstmt.setDouble(7, c.getBalance());
		 		*/
		 		
		 		pstmt.executeUpdate();
		 		
		 		
		 		
		 		
		 	}
		 
		 
		 public ArrayList get(int accno)throws SQLException
		 
		 {
			 getpstmt.setInt(1,accno);
			 
			 ResultSet rs=getpstmt.executeQuery();
			 
			 ArrayList al=new ArrayList();
			 
			 while(rs.next())
				 
			 {
				 int a=rs.getInt(1);
				 String b=rs.getString(2);
				 String c=rs.getString(3);
				 double d=rs.getDouble(4);
				 
				 Temp t1=new Temp(a,b,c,d);
				 
				 al.add(t1);
			 }
			 return al;
			 
		
			 
		

}
}
