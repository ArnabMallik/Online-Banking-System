package online.dao;

import java.sql.*;
import java.util.ArrayList;

public class AccountDAO {
	
	private String driver="com.mysql.jdbc.Driver";
	
	private String jdbcurl="jdbc:mysql://localhost:3306/account";
	
	private String username="root";
	
	private String password="root";

	private Connection con;
	
	private PreparedStatement pstmt,createpstmt;
	
	private String getinfosql="SELECT CURRENTBALANCE FROM DETAILS WHERE ACCOUNTNO=?";
	
	private String createsql="INSERT INTO DETAILS(ACCOUNTNO,CURRENTBALANCE) VALUES (?,?)";
	
	
	
	



public AccountDAO()throws ClassNotFoundException,SQLException

{
	Class.forName(driver);
	con=DriverManager.getConnection(jdbcurl,username,password);
	
	//System.out.println("jhdsfjds");
	pstmt=con.prepareStatement(getinfosql);
	createpstmt=con.prepareStatement(createsql);
	
	
}

public void create(Account obj)throws SQLException

{
	createpstmt.setInt(1,obj.getAccno());
	createpstmt.setDouble(2,obj.getBalance());
	
	createpstmt.executeUpdate();
	
	
}

public double getinfo(int accno)throws SQLException
{
	pstmt.setInt(1, accno);
	
	ResultSet rs=pstmt.executeQuery();
	
	double balance=0;
	while(rs.next())
		
	{
		
	balance=rs.getDouble(1);
		
		
	}
	
	return balance;
	
}



	
	
	
}





