package com.example.demo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.UserDto;
import com.example.demo.service.LoginService;

@Controller
public class LoginContoller {
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value = "login.html",method = RequestMethod.GET)
	public String goToLoginPage() {
		//  code
		
		System.out.println("Hello World");
		
		return "page.jsp";
	}
	
	
	@RequestMapping(value = "dologin.html",method = RequestMethod.POST)
	public String validateUser(Model model,@RequestParam("username") String username,@RequestParam("password") String password) {
		
		
		UserDto userDto = loginService.getUserByUsernameAndPassword(username, password);
		
		if(userDto == null) {
			//request.getRequestDispatcher("login.jsp").forward(request, response);
			
			//response.sendRedirect("page.html");
			
			return "redirect:login.html?msg=Wrong Username or Password";  // resp.sendR..
			
			
		}else {
			
			UserDto formData = new UserDto();
			
			model.addAttribute("formData", formData);
			
			
			List<UserDto> userList = loginService.findAllUsers();
			
			model.addAttribute("userList", userList);
			
			
			return "dashboard.jsp";  //  req.getREquest
		}
	}
	
	
	
	@RequestMapping(value = "processUser.html",method = RequestMethod.POST)
	public String processUserData(Model model,@ModelAttribute("formData") UserDto formData) {
		
		
		if(formData.getId() == null){
			
			loginService.save(formData);
		
		}else {
			
			
			loginService.updateUser(formData);
		}
		
		formData = new UserDto();
		
		model.addAttribute("formData", formData);
		
		
		List<UserDto> userList = loginService.findAllUsers();
		
		model.addAttribute("userList", userList);
		
		return "dashboard.jsp"; 
		
	}
	

}
