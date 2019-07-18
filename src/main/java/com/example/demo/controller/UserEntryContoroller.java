package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entity.User;
import com.example.demo.form.UserForm;
import com.example.demo.repository.UserRepository;

@Controller
public class UserEntryContoroller {

	@Autowired
	UserRepository userRe;

	@RequestMapping(value = "/entry", method = RequestMethod.GET)
	public ModelAndView entryGet(@ModelAttribute UserForm userForm, ModelAndView mav) {
		mav.setViewName("userEntry");
		return mav;
	}

	@RequestMapping(value = "/entry", method = RequestMethod.POST)
	public ModelAndView entryPost(@Valid @ModelAttribute UserForm userForm,
			BindingResult br,
			ModelAndView mav) {

		if(userRe.findByLoginId(userForm.getLoginId()) != null) {
			mav.addObject("errMsg","このログインIDは使用されています");
			mav.setViewName("redirect:/entry");
			return mav;
		}

		if (!userForm.getPassword().equals(userForm.getPasswordCon())) {
			mav.addObject("errMsg", "パスワードが一致してません。");
			mav.setViewName("redirect:/entry");
			return mav;
		}

		if (br.hasErrors()) {

			return entryGet(userForm, mav);
		}

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String pass = encoder.encode(userForm.getPassword());

		User user = new User();
		user.setLoginId(userForm.getLoginId());
		user.setPassword(pass);
		user.setName(userForm.getName());

		userRe.save(user);

		mav.setViewName("redirect:/login");
		return mav;

	}

}
