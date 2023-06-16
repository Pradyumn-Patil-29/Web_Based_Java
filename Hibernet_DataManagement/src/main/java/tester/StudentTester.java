package tester;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

public class StudentTester {

	public static void main(String[] args) {
		
		boolean exit=false;
		try(SessionFactory session=getFactory();Scanner sc=new Scanner(System.in))
		{
			StudentDaoImpl dao=new StudentDaoImpl();
			
			do {
				
				System.out.println("Enter 1.RegisterStudnet 2.login 3.details from course 4.update course 5.Exit");
				
				switch(sc.nextInt())
				{
				case 1://register
					
					System.out.println("Enter | fName,String LName,String Email,String PassWord,Course course,LocalDate dob");
					
					Student NewStudent=new Student(sc.next(),sc.next(),sc.next(),sc.next(),Course.valueOf(sc.next().toUpperCase()),LocalDate.parse(sc.next()));
					
					System.out.println(dao.NewRegistration(NewStudent));
					break;
					
				case 2: //login
					//Student login=new Student(sc.next(),sc.next());
					System.out.println("Enter Email and PassWord");
					
					System.out.println(dao.StudentLogin(sc.next(),sc.next()));
					break;
					
				case 3://details from course
					System.out.println("Enter Course");
					
					List <Student> list=dao.GetStudentsFromCourse(Course.valueOf(sc.next().toUpperCase()));
					for(Student s: list)
						System.out.println(s);
					break;
					
				case 4://update course
					System.out.println("Enter ID and Course to change");
					
					System.out.println(dao.UpdateCourse(sc.nextInt(),Course.valueOf(sc.next().toUpperCase())));
					break;
					
				case 5://exit
					exit=true;
					System.out.println("----Exit----");
					break;
				}
				
			}while(!exit);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
