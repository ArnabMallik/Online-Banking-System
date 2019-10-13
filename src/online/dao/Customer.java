package online.dao;

public class Customer {
	
	private String name;
	private String DOB;
	private String email;
	private String actype;
	private String username;
	private String password;
	private double balance;
	private int accno;
	private String pan;
	
	
	
	
	public Customer(String name) {
		super();
		this.name = name;
	}

	

	
/*	public Customer(String name, String dOB, String email, String actype,
			String username, String password, double balance, int accno,
			String pan) {
		super();
		this.name = name;
		DOB = dOB;
		this.email = email;
		this.actype = actype;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.accno = accno;
		this.pan = pan;
	}*/




	public Customer(String name, String dOB, String email, String actype,
			String username, String password, double balance, int accno,
			String pan) {
		super();
		this.name = name;
		DOB = dOB;
		this.email = email;
		this.actype = actype;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.accno = accno;
		this.pan = pan;
	}


	public Customer(String name, String dOB, String email, String actype,
			String username, String password, double balance,String pan) {
		super();
		this.name = name;
		this.DOB = dOB;
		this.email = email;
		this.actype = actype;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.pan=pan;
		
	}


	public Customer() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActype() {
		return actype;
	}

	public void setActype(String actype) {
		this.actype = actype;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getAccno() {
		return accno;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}
	
}