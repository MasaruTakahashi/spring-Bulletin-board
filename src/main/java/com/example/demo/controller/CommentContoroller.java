package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Thread;
import com.example.demo.form.CommentForm;
import com.example.demo.form.ThreadForm;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.ThreadRepository;

@Controller
public class CommentContoroller {

	@Autowired
	ThreadRepository threadRe;
	@Autowired
	CommentRepository commentRe;
	@Autowired
	HttpSession session;


	@RequestMapping(value = "/comment", method = RequestMethod.GET)
	public ModelAndView commentGet(@ModelAttribute ThreadForm threadForm,
			@ModelAttribute CommentForm commentForm, ModelAndView mav) {
		Thread thread = threadRe.findById(threadForm.getId()).get();
		mav.addObject("thread", thread);
		List<Comment> comment = commentRe.findByThredId(threadForm.getId().intValue());
		mav.addObject("commentList", comment);
		mav.setViewName("comment");
		return mav;
	}

	@RequestMapping(value = "/comment", method = RequestMethod.POST)
	public ModelAndView commentPost(@Valid @ModelAttribute CommentForm commentForm, BindingResult br, ModelAndView mav) {

		if (br.hasErrors()) {
			ThreadForm threadForm = new ThreadForm();
			threadForm.setId((long) commentForm.getThreadId());
			return commentGet(threadForm, commentForm, mav);
		}
		Comment comment = new Comment();
		comment.setDetail(commentForm.getDetail());
		comment.setThredId(commentForm.getThreadId());
		comment.setUserId(Integer.parseInt(session.getAttribute("userid").toString()));
		comment.setCreateDate(new Date());

		commentRe.save(comment);
		mav.setViewName("redirect:/comment"+"?id="+comment.getThredId());
		return mav;
	}
}
