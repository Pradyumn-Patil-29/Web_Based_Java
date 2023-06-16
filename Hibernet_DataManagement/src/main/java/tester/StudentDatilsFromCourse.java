package tester;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;

public class StudentDatilsFromCourse {

	public static void main(String[] args) {
		

		try(SessionFactory session=getFactory();Scanner sc=new Scanner(System.in))
		{
			StudentDaoImpl dao=new StudentDaoImpl();
			
			//Student login=new Student(sc.next(),sc.next());
			System.out.println("Enter Course");
			
			System.out.println(dao.GetStudentsFromCourse(Course.valueOf(sc.next().toUpperCase())));
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
