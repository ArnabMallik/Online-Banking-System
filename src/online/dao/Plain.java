package online.dao;

public class Plain {
	
	private int a;
	
	private String b;
	
	private double c;

	public Plain(int a, String b,double c) {
		super();
		this.a = a;
		this.b = b;
		this.c= c;
	}

	public Plain() {
		super();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}
	
	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c= c;
	};

}
