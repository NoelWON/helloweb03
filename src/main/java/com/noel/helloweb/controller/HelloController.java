package com.noel.helloweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	
	
	
	@RequestMapping("/hello")
	public String hello() {
		return "/WEB-INF/views/hello.jsp";
	}
	
	@RequestMapping("/hello2")
	public String hello2(String name) {
		// http://localhost:8080/helloweb03/hello2?name=noel 이렇게 하면 name 이 표시된다.
		System.out.println(name);
		return "/WEB-INF/views/hello.jsp";
	}
	
	// 데이터 전달하기
	// viewResolve 방식
	@RequestMapping("/hello3")
	public ModelAndView hello3(String n) {
		//http://localhost:8080/helloweb03/hello3?n=noel
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/WEB-INF/views/hello3.jsp");
		// jsp 에서 name 으로 받는다.
		mv.addObject("name",n);	
		return mv;
	}
	// model 방식
	@RequestMapping("/hello4")
	public String hello4(String n , Model model) {
		// jsp 에서 name 으로 받는다.
		model.addAttribute("name",n);
		
		return "/WEB-INF/views/hello3.jsp";
	}
}
