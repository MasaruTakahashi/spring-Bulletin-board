package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserEntryContoroller {

	@RequestMapping(value = "/entry", method = RequestMethod.GET)
	public ModelAndView entryGet(ModelAndView mav) {
		mav.setViewName("userEntry");
		return mav;
	}

	@RequestMapping(value = "/entry")
	public ModelAndView entryPost() {

	}

}
