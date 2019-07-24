package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
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
import com.example.demo.entity.User;
import com.example.demo.form.ThreadForm;
import com.example.demo.repository.ThreadRepository;
import com.example.demo.repository.UserRepository;

@Controller
public class ThreadContoroller {

	@Autowired
	ThreadRepository threadRe;
	@Autowired
	UserRepository userRe;
	@Autowired
	HttpSession session;

	@RequestMapping(value = "/threadList", method = RequestMethod.GET)
	public ModelAndView threadGet(@ModelAttribute ThreadForm threadForm, ModelAndView mav) {
		List<Thread> threadList = threadRe.findAll();
		mav.addObject("userId",session.getAttribute("userid"));
		mav.addObject("threadList", threadList);
		mav.setViewName("ThreadList");
		return mav;
	}

	@RequestMapping(value = "/threadList", method = RequestMethod.POST)
	public ModelAndView threadPost(ModelAndView mav) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRe.findByLoginId(auth.getName());
		Long id = user.getId();
		session.setAttribute("userid", id);
		mav.setViewName("redirect:/threadList");
		return mav;

	}

	@RequestMapping(value = "/threadcreate", method = RequestMethod.POST)
	public ModelAndView createThread(ModelAndView mav,
			@Valid @ModelAttribute ThreadForm threadForm,
			BindingResult br) {

		if (br.hasErrors()) {
			return threadGet(threadForm, mav);
		}

		Thread thread = new Thread();
		thread.setName(threadForm.getName());
		thread.setUserId(Integer.parseInt((String) session.getAttribute("userid").toString()));
		thread.setCreateDate(new Date());

		threadRe.save(thread);

		mav.setViewName("redirect:/threadList");
		return mav;

	}
	@RequestMapping(value = "/threaddelete")
	public ModelAndView deleteThread(ModelAndView mav,@ModelAttribute ThreadForm threadForm) {
		threadRe.deleteById(threadForm.getId());
		mav.setViewName("redirect:/threadList");
		return mav;


	}
}
