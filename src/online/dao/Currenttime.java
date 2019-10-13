package online.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Currenttime {
	
	public static String gettime()
	{

	
	DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	Calendar cal = Calendar.getInstance();
	String s=dateFormat.format(cal.getTime());
	return s;
}
}