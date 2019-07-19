package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Thread;
import com.example.demo.form.ThreadForm;
import com.example.demo.repository.ThreadRepository;

@Controller
public class ThreadContoroller {

	@Autowired
	ThreadRepository thrreadRe;

	@RequestMapping(value = "/threadList",method = RequestMethod.POST)
	public ModelAndView threadGet(ModelAndView mav) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		mav.addObject("userinfo",auth);

		List<Thread> threadList = thrreadRe.findAll();
		mav.addObject("threadList",threadList);
		mav.setViewName("ThreadList");
		return mav;

	}

	@RequestMapping(value = "/threadcreate",method = RequestMethod.POST)
	public ModelAndView createThread(ModelAndView mav,
			@Valid@ModelAttribute ThreadForm threadForm,
			BindingResult br) {
		return mav;

	}
}
