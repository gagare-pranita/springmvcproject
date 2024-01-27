package com.jspider.springmvcproject.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jspider.springmvcproject.pojo.AdminPOJO;
import com.jspider.springmvcproject.service.AdminService;

@Controller


public class AdminController {
	@Autowired
	private AdminService service;
	@GetMapping("/createAccount")
	public String createAccountPage(ModelMap map)
	{
		AdminPOJO pojo=service.getAdmin();
		if(pojo!=null)
		{
			map.addAttribute("msg","account already exist");
			return "Login";
		}
		return "CreateAccount";
	}
	@PostMapping("/createAccount")
	public String createAccount(@RequestParam String username,@RequestParam String password,ModelMap map)
	{
		AdminPOJO pojo=service.createAccount(username,password);
		if(pojo!=null)
		{
			map.addAttribute("msg","Account Created Succesfully");
			return "Login";
		}
		map.addAttribute("msg","Account not created");
		return "Login";
		
	}
	@PostMapping("/login")
	public String login(@RequestParam String username,@RequestParam String password,ModelMap map,HttpSession session)
	{
		AdminPOJO pojo=service.login(username,password);
		if(pojo!=null)
		{
			session.setAttribute("login", pojo);
			session.setMaxInactiveInterval(1000);
			return "Home";
		}
		map.addAttribute("msg", "invalid username or password");
		return "Login";
	}
	@GetMapping("/logout")
	public String logout(ModelMap map,HttpSession session)
	{
		session.invalidate();
		map.addAttribute("msg","logout succsfully");
		return "Login";
	}

}
/*

requestparam this annotation it can be uesd to  fetach the value of parrameter based on its name whic is prestnt in query
hhtpsession is the interface  which is the imlicit object which is also resposible to perform the opertion on seesion attri
setattribut this method it can be used toinitalizze the attribute for the spi=ecific object and it also allow usto set the name of that session atribute
it u=is nonstatic whic h is prestint in the hhtpsession inteface it cab used to distory or terminate the currently seession attribut
setmaxinactiveinterval ithis method it cabn be used to  automatically destroy or terminate the currently active seeion attribute for the specific inatcive intervl
the interva are methond in the interger argment
and consider as the miliseconds
*/
