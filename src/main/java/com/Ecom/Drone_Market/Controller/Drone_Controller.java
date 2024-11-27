package com.Ecom.Drone_Market.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Drone_Controller {

	@RequestMapping("/")
	public String indexpage(){
		return "index";
		
	}
	
	@RequestMapping("/login")
	public String loginpage(){
		return "login";
		
	}
	
	@RequestMapping("/register")
	public String registerpage(){
		return "register";
		
	}
	
	@RequestMapping("/product")
	public String productpage() {
		return "product";
	}
	
	@RequestMapping("/view_prod")
	public String view_prod() {
		return "view_prod";
	}
	
	
	
	
}
