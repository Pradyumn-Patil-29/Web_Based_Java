  package com.app.controller;

import java.time.LocalDateTime;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller //Mandatory to tell sc:following is req handling
//controller==Handler,Containing req handling methods
public class HomePageController {
	public HomePageController() {
		System.out.println("in Constructor of"+getClass());
	}
	
	//add req handlinbg method to forward the client to index.jsp
	
	//key=/,value=FullyQualified Name
	@RequestMapping("/")//can intercept get/put/post/delete
	public ModelAndView showHomePage() {
		 System.out.println("in show home page(model and view)");
		 //API o.s.w.s.ModelAndView(String Ivn,String modelAttrName,Object Value)
		 return new ModelAndView("/index","timestamp",LocalDateTime.now());
		 //handler methods returns-->MnV-->D.S-->sends (logical view name)LVN-->V.R-->AVN:/WEB-INF/views/index.jsp-->D.S
		 //checks model attr-->yes-->saves under request scope-->why??-->coz its server pull-->RD rd=request.getRD("/WEB-INF/views/)
		 //rd.forward(request,resp)-->JSP-->
	}

}
