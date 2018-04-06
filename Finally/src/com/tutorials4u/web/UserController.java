package com.tutorials4u.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.tutorials4u.domain.User;
import com.tutorials4u.service.UserService;

@SuppressWarnings("deprecation")
public class UserController extends SimpleFormController {
	private UserService userService;

	public UserController() {

		setCommandClass(User.class);

		setCommandName("user");

	}

	public void setUserService(UserService userService) {

		this.userService = userService;

	}

	@Override
	protected ModelAndView onSubmit(Object command) throws Exception {

		User user = (User) command;

		userService.add(user);

		return new ModelAndView("success", "user", user);

	}
}
