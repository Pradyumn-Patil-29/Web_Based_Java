package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.service.DepartmentService;

@Controller
@RequestMapping("/departments") //optional but recommended for separation
//:this spring bean will handle all dept related requested
public class DepartmentController {
	
	//depedency:service layer i/f
	@Autowired //by type,filed level DI
	private DepartmentService deptService;
	
	public DepartmentController() {
		System.out.println("in department Controller Constructor"+getClass());
	}
	
	//add request handling method
	@GetMapping("/list")
	public ModelAndView getAllDepartment() {
		 System.out.println("in get dept list");
		return new ModelAndView("/dept/list","dept_list",deptService.getAllDepartments());
		
		//controller-->MnV-->D.S-->LVN-->V.R-->AVN-->/WEB-INF/views/dept/list.jsp-->D.S Checks for model
		//-->YES-->RD rd=Request.getRD("")-->rd.forward(request, response)-->JSP:${...}
		
		
	}

}
