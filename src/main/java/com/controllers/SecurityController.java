package com.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@RequestMapping(value="/gotologin")
	public String gotoLoginPage() {
		System.out.println("Forwarding to my own login Page");
		
		return"login";
	}
	@RequestMapping(value="/loginfailpage")
	public String loginFail(Model model) {
		model.addAttribute("sms", "login fail!! Try again!!");
		return"login";
	}
	@RequestMapping(value="/homepage")
	public String homepage() {
		
		return "home";
	}
}
