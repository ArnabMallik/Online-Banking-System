package online.dao;

import java.sql.*;
import java.util.*;


public class CustomerDAO {
	
  private String driver="com.mysql.jdbc.Driver";
	
	private String jdbcurl="jdbc:mysql://localhost:3306/banking";
	
	private String username="root";
	
	private String password="root";
	
	private Connection con;
    
	private PreparedStatement pstmt,checkpstmt,namepstmt,accpstmt,getpstmt,cgetPstmt,balPstmt,transferPstmt,checkno,getnopstmt,checkuserPstmt,getallpstmt;
	
	
	private String getaccsql="SELECT ACCOUNTTYPE FROM OB WHERE NAME=?";
	private String getnamesql="SELECT NAME FROM OB WHERE USERNAME=?";
	private String checksql="SELECT USERNAME,PASSWORD FROM OB";
	private String amountsql="SELECT BALANCE FROM OB WHERE ACCOUNTNO=?";
	private String getsql="SELECT ACCOUNTNO,ACCOUNTTYPE,BALANCE FROM OB WHERE USERNAME=?";
	private String cgetsql="SELECT NAME,DOB,EMAIL,ACCOUNTTYPE,USERNAME,PASSWORD,BALANCE,PAN_NO FROM OB WHERE USERNAME=?";
	//private String getsql="SELECT ACCOUNTNO,ACCOUNTTYPE,BALANCE FROM OB WHERE USERNAME=?";
	private String createsql="INSERT INTO OB(NAME,DOB,EMAIL,ACCOUNTTYPE,USERNAME,PASSWORD,BALANCE,PAN_NO) VALUES (?,?,?,?,?,?,?,?)";
	private String check="SELECT ACCOUNTNO FROM OB WHERE USERNAME=?";
	private String transfersql="SELECT ACCOUNTNO FROM OB WHERE USERNAME=?";
	private String checkusersql="SELECT USERNAME FROM OB";
	private String getnosql="SELECT ACCOUNTNO FROM OB WHERE USERNAME=?";
	private String getallsql="SELECT NAME,DOB,EMAIL,ACCOUNTTYPE,ACCOUNTNO,USERNAME,PASSWORD,BALANCE FROM OB";
	
     public CustomerDAO() throws SQLException,ClassNotFoundException
	
	{
			Class.forName(driver);
			con=DriverManager.getConnection(jdbcurl,username,password);
			System.out.println("Connection established....");
			pstmt=con.prepareStatement(createsql);
			checkpstmt=con.prepareStatement(checksql);
			namepstmt=con.prepareStatement(getnamesql);
			accpstmt=con.prepareStatement(getaccsql);
			getpstmt=con.prepareStatement(getsql);
			cgetPstmt=con.prepareStatement(cgetsql);
			balPstmt=con.prepareStatement(amountsql);
			transferPstmt = con.prepareStatement(transfersql);
			checkuserPstmt = con.prepareStatement(checkusersql);
			getnopstmt=con.prepareStatement(getnosql);
			checkno=con.prepareStatement(check);
			getallpstmt=con.prepareStatement(getallsql);


			
		}
     
     public void create(Customer c) throws SQLException
 	
 	{
 		pstmt.setString(1,c.getName());
 		pstmt.setString(2,c.getDOB());
 		pstmt.setString(3,c.getEmail());
 		pstmt.setString(4,c.getActype());
 		pstmt.setString(5,c.getUsername());
 		pstmt.setString(6,c.getPassword());
 		pstmt.setDouble(7,c.getBalance());
 		pstmt.setString(8,c.getPan());
 		
 		pstmt.executeUpdate();
 		
 		
 		
 	}
     
     public boolean check(String username,String password)throws SQLException
     
     {
    	   	 
    	 ResultSet rs=checkpstmt.executeQuery();
    	
    	 
    	 while(rs.next())
    	 {
    		
    		 if(username.equals(rs.getString(1)) && password.equals(rs.getString(2)))
    			 return true;
    	 }
    	
    	 return false;
    	
     }
     
     
        String name;
		String dob;
		String email;
		String actype;
		String cusername;
		String Password;
		double balance;
		int accno;
		String pan;
		
	public Customer all(String Username)throws SQLException
	{
		cgetPstmt.setString(1, Username);
		ResultSet rs1=cgetPstmt.executeQuery();
		if(rs1.next())
		{
		name=rs1.getString(1);
		//System.out.println("INSIDE DAO all()\n"+name);
		dob=rs1.getString(2);
		email=rs1.getString(3);
		actype=rs1.getString(4);
		cusername=rs1.getString(5);
		Password=rs1.getString(6);
		balance=rs1.getDouble(7);
		pan=rs1.getString(8);
		
		}
		
		Customer c=new Customer(name,dob,email,actype,cusername,Password,balance,pan);
		//System.out.println("INSIDE DAO\n"+c.getName());
		return c;
	}
	
	public Customer ck(String username)throws SQLException
	{
		namepstmt.setString(1,username);
		ResultSet rs=namepstmt.executeQuery();
		if(rs.next())
			name=rs.getString(1);
		Customer c=new Customer(name);
		return c;
	}
     
     public String getname(String username)throws SQLException
     
     {
    	 
    	 namepstmt.setString(1,username);
    	 
    	 ResultSet rs=namepstmt.executeQuery();
    	 
    	 if(rs.next())
    		 
    		 return rs.getString(1);
    	 else
    		 
    		 return null;
    	 
    	 
    	 
     }
 
     
     
 public ArrayList getacc(String name)throws SQLException
     
     {
    	 
    	 accpstmt.setString(1,name);
    	 
    	 ResultSet rs=accpstmt.executeQuery();
    	 
    	 ArrayList<String> al=new ArrayList<String>();
    	 
    	 while(rs.next())
    		 
    	 {
    		 al.add(rs.getString(1));
    		 
    	 }
    		 
    		 return al;
    	 
    	 
    	 
     }
 
 public boolean checktransfer(String str,int value1,int value2)throws SQLException
 {
	 
	transferPstmt.setString(1,str);
	 
	 ResultSet rs=transferPstmt.executeQuery();
	 
	 int count=0;
	 
	 System.out.println(str+"InsiDE");
	
 
    	 while(rs.next())
    	 {
    		
    		 if(value1==rs.getInt(1))
    		 {
    			 count++;
    		 }
    		 if(value2==rs.getInt(1))
    		 {
    			 count++;
    		 }
    		 
    		
    		 
    	 }
    	 if(count==2 && value1!=value2)
    		 
    		 return true;
    	 
    	 else
    		 
    		 return false;
    			 
    	 
    	
	 
	}

 
 
 public Collection get(String name)throws SQLException
 
 {
	 
	 getpstmt.setString(1,name);
	 
	 ResultSet rs=getpstmt.executeQuery();
	 
	 ArrayList<Plain> al=new ArrayList<Plain> ();
	 
	 while(rs.next())
		 
	 {
		 int a=rs.getInt(1);
		 String b=rs.getString(2);
		 double c=rs.getDouble(3);
		
		 Plain p=new Plain(a,b,c);
		 
		 al.add(p);
		 
	 }
		 
		 return al;
	 
	 
	 
 }
	
	
public double getbalance(int accno)throws SQLException
{
	
	balPstmt.setInt(1, accno);
	ResultSet rs=balPstmt.executeQuery();
	rs.next();
	return rs.getDouble(1);
}
	

public boolean checkname(String username)throws SQLException
{
		ResultSet rs=checkuserPstmt.executeQuery();
		while(rs.next())
		{
			if(username.equals(rs.getString(1)));
			return true;
		}
		return false;
	}

public int getno(String username)throws SQLException

{
	 
	 getnopstmt.setString(1,username);
	 
	 ResultSet rs=getnopstmt.executeQuery();
	 
	 int accno=0;
	 while(rs.next())
	 {
		 
	   accno=rs.getInt(1);
		 
		
		 
	 }
	 
	 
	 return accno;
	 
}

public boolean checkid(String username,int id)throws SQLException

{
	 checkno.setString(1,username);
	 
	 ResultSet rs=checkno.executeQuery();
	 
	 int i=0;
	 
	 while(rs.next())
		 
	 {
		 
		 if(rs.getInt(1)==id)
			 
			 return true;
	 }
	 
	 return false;
}

public ArrayList getall()throws SQLException
{
	
	ResultSet rs=getallpstmt.executeQuery();
	
	ArrayList al=new ArrayList();
	
	while(rs.next())
		
	{
		String name=rs.getString(1);
		//System.out.println("INSIDE DAO all()\n"+name);
		String dob=rs.getString(2);
		String email=rs.getString(3);
		String actype=rs.getString(4);
		int accno=rs.getInt(5);
		String cusername=rs.getString(6);
		String Password=rs.getString(7);
		double balance=rs.getDouble(8);
		
		Customer c=new Customer(name,dob,email,actype,cusername,Password,balance,accno,pan);
		
		al.add(c);
		
	}
	
	return al;
		
		
	}




	}


