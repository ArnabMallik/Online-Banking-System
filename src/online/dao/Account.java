package online.dao;

public class Account {
	
	private int accno;
	
	private double balance;

	public Account(int accno, double balance) {
		super();
		this.accno = accno;
		this.balance = balance;
	}

	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Account() {
		super();
	}
	
	

}
