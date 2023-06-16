package tester;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getFactory;

public class AddNewStudent {

	public static void main(String[] args) {
	 
		try(SessionFactory ss=getFactory();Scanner sc=new Scanner(System.in))
		{
		    StudentDaoImpl StudentDao=new StudentDaoImpl();
			System.out.println("Enter | fName,String LName,String Email,String PassWord,Course course,LocalDate dob");
			
			Student NewStudent=new Student(sc.next(),sc.next(),sc.next(),sc.next(),Course.valueOf(sc.next().toUpperCase()),LocalDate.parse(sc.next()));
			
			System.out.println(StudentDao.NewRegistration(NewStudent));
		}

	}

}
