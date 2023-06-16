package dao;

import java.time.LocalDate;
import java.util.List;

import pojos.Course;
import pojos.Student;

public interface StudentDao {
	
	String NewRegistration(Student NewStudent);
   //String fName,String LName,String Email,String PassWord,Course course,LocalDate dob
	
	String StudentLogin(String Email,String PassWord);
	
	List<Student> GetStudentsFromCourse(Course course);
	
	Student UpdateCourse(Integer id,Course course);
}
