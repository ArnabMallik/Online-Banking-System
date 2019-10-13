package online.dao;

public class Transaction {

	private int accno;
	
	private int tid;
	
	private String tdate;
	
	private String ttype;
	
	private double amount;

	public Transaction(String tdate, String ttype, double amount,int accno) {
		super();
		this.tdate = tdate;
		this.ttype = ttype;
		this.amount = amount;
		this.accno=accno;
	}

	public Transaction() {
		super();
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTdate() {
		return tdate;
	}

	public void setTdate(String tdate) {
		this.tdate = tdate;
	}

	public String getTtype() {
		return ttype;
	}

	public void setTtype(String ttype) {
		this.ttype = ttype;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

	
	
	
	
}
