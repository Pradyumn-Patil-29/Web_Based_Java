package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;

@Repository//Mandatory annotation to tell sc:following is a spring bean containing data access logic
public class DepartmentDaoImpl implements DepartmentDao {

	//depedemcy:SF
	@Autowired //mandatory dependency:required =true,field level D.I
	
	private SessionFactory sf;//automatically supllied by spring suplied
	//:localSessionFactoryBean
	
	@Override
	public List<Department> getAllDepartment() {
		
		return sf.getCurrentSession()
				.createQuery("select d from Department d",Department.class)
				.getResultList();
	}
	

}
