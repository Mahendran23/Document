package com.helloworld.springbootdemo;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("/Home.html")
	public ModelAndView Home(HttpSession session) {
		session.setAttribute("username", "Santosh");
		return new ModelAndView("Home");
	}

	@RequestMapping("/Welcome.html")
	public ModelAndView Hello() {
		return new ModelAndView("Welcome");
	}

	@RequestMapping("/Register.html")
	public ModelAndView Registartion() {
		return new ModelAndView("Register");
	}

	@RequestMapping("/error.html")
	public ModelAndView error() {
		return new ModelAndView("Error");
	}

	@RequestMapping("/Cart.html")
	public ModelAndView AddtoCart() {
		return new ModelAndView("Cart");
	}
}
