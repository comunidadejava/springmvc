package com.sandbox.spring.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sandbox.spring.domains.User;
import com.sandbox.spring.models.IModel;
import com.sandbox.spring.models.UsersModel;

@Controller
@RequestMapping("/users")
@SessionAttributes("user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String form(User user, Model model) {
		logger.info("Welcome create User! The user info is {}.", user);

		model.addAttribute(user);

		return "createUser";
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@Valid User user, BindingResult result) {
		logger.info("Welcome create User! The user info is {}.", user);
		
		if (result.hasErrors()) {
			return "createUser";
		} else {
			return "redirect:/users/create";
		}
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") int id, Model model) {
		logger.info("Welcome User info! The user id {}.", id);
		IModel<User> userModel = new UsersModel();
		User user = userModel.getById(id);

		model.addAttribute(user);

		return "user";
	}
}
