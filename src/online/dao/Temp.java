package online.dao;

public class Temp {
	
	private int id;
	
	private String date;
	
	private String type;
	
	private double amount;

	public Temp(int id, String date, String type, double amount) {
		super();
		this.id = id;
		this.date = date;
		this.type = type;
		this.amount = amount;
	}

	public Temp() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
