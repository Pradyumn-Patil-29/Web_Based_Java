package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;
import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String NewRegistration(Student NewStudent) {
		
		    String msg="";
		     //getting Session
		      Session session=getFactory().getCurrentSession();
		      
		      //create transaction
		      Transaction tr=session.beginTransaction();		    
		    try
		    {
		    	session.save(NewStudent);
		    	tr.commit();
		    	
		        msg = "new Student registered";
		    }
		    catch (RuntimeException e) {
		    	if(tr!=null)
		    	tr.rollback();
		    	throw e;
		    }
		    return msg;
	}

	@Override
	public String StudentLogin(String Email, String password) {
	   
		  String msg="not valid";
		  Student Stud=null;
		       
		  String jpql="select s from Student s where s.Email=:eid and s.password=:pass";
		  
		  Session session=getFactory().getCurrentSession();
		  
		  Transaction tr=session.beginTransaction();
		  
		  try {
			  Stud=session.createQuery(jpql,Student.class).setParameter("eid",Email).setParameter("pass",password).getSingleResult();
			  
			  tr.commit();
			  msg="login is successfully ";
		  }catch(RuntimeException e) {
			  tr.rollback();
			  throw e;
		  }
		  
		return msg;
	}

	@Override
	public List<Student> GetStudentsFromCourse(Course course) {
	
		List<Student> Stud=null;
		
		String jpql="select s from Student s where s.course=:course";
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tr=session.beginTransaction();
		try {
			Stud=session.createQuery(jpql,Student.class)
					.setParameter("course",course)
					.getResultList();
			
			tr.commit();
		}catch(RuntimeException e)
		{
			tr.rollback();
			throw e;
		}
		return Stud;
	}

	@Override
	public Student UpdateCourse(Integer id, Course course) {
        
		Student student=null;
	
		
	
		
		Session session=getFactory().getCurrentSession();
		
		Transaction tr=session.beginTransaction();
		
		try {
			student=session.get(Student.class,id);
			if(student!=null)
				student.setCourse(course);
			tr.commit();
		}catch(RuntimeException e) {
			
			tr.rollback();
			throw e;
		}
		
		return student;
	}

}
