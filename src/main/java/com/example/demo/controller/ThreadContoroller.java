package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Thread;
import com.example.demo.repository.ThreadRepository;

@Controller
public class ThreadContoroller {

	@Autowired
	ThreadRepository thrreadRe;

	@RequestMapping("/threadList")
	private ModelAndView threadGet(ModelAndView mav) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		String name = auth.getName();
		mav.addObject("name",name);

		List<Thread> threadList = thrreadRe.findAll();
		mav.addObject("threadList",threadList);
		mav.setViewName("thread");
		return mav;

	}
}
