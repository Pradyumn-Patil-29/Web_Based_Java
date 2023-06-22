package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;

@Service //mandatory annotaiton to tell sc ,following is a spring bean
// Containing B.L

@Transactional //mandatory annotaitons to tell SC to manage the txs:automatically!
public class DepartmentServiceImpl implements DepartmentService {

	//dependecy:dao layer i/f
	@Autowired //by type:field level DI
	private DepartmentDao deptDao;
	@Override
	public List<Department> getAllDepartments() {
		
		return deptDao.getAllDepartment();
	}

}
