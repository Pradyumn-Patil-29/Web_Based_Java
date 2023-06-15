package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import Pojo.Employee;

import static hUtills.HibernateUtils.getFactory;

public class DAOhiberImpl implements DAOhiber {
	
	private String msg="";
	
	@Override
	public String insertEmployee(Employee NewEmployee) {
		Session session=getFactory().openSession();
		
		Transaction tr=session.beginTransaction();
		
		try{
			session.save(NewEmployee);
			tr.commit();
			msg="successfully added!!!";
			
		}catch(Exception e) {
		if(session!=null)
			tr.rollback();
			
		}finally{
			if(session!=null)
				session.close();
		}

		return msg;
	}

}
