package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginContoroller {

	@RequestMapping("/login")
	public ModelAndView loginGet(ModelAndView mav) {
		mav.setViewName("login");
		return mav;
	}
}
