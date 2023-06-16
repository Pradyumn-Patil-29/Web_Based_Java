package tester;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Student;

import static utils.HibernateUtils.getFactory;

public class StudentLogin {

	public static void main(String[] args) {
	
		try(SessionFactory session=getFactory();Scanner sc=new Scanner(System.in))
		{
			StudentDaoImpl dao=new StudentDaoImpl();
			
			//Student login=new Student(sc.next(),sc.next());
			System.out.println("Enter Email and PassWord");
			
			System.out.println(dao.StudentLogin(sc.next(),sc.next()));
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
