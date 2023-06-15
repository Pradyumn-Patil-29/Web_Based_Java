package Tester;
import static hUtills.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import Dao.DAOhiberImpl;

import Pojo.EmpType;
import Pojo.Employee;
public class Tester {

	public static void main(String[] args) {
	
		DAOhiberImpl dao=new DAOhiberImpl();
		try(SessionFactory Session=getFactory();Scanner sc=new Scanner(System.in)){
			
			System.out.println("Enter details: FirstName|LstNAme|Email|Psswaord|JoiningDate|Type|salary");
			Employee NewEmployee=new Employee(sc.next(),sc.next(),sc.next(),sc.next(),LocalDate.parse(sc.next()),EmpType.valueOf(sc.next().toUpperCase()),sc.nextDouble());
			System.out.println(dao.insertEmployee(NewEmployee));
		}catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
