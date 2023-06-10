package utils;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Period;
import java.sql.Date;

public class Validations {
	
	public static Date validateAge(String dob) throws SQLException{
		
		         //LocalDate NewDate=LocalDate.parse(dob);
		LocalDate NewDate = LocalDate.parse(dob);
		       int years=Period.between(NewDate, LocalDate.now()).getYears();
		       Date newDob=Date.valueOf(NewDate);
		       if(years<=21)
		    	   throw new SQLException("small age!!");
		       
		       return newDob;
	}

}
