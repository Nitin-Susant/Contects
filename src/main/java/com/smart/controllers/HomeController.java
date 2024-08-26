package com.smart.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.smart.entity.Contect;
import com.smart.entity.Users;
import com.smart.helper.UserHelper;
import com.smart.services.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@GetMapping("/home")
	public String homw() {

		return "home";
	}

	@GetMapping("/about")
	public String about() {

		return "about";
	}

	@PostMapping("/demoedit/{id}")
	public String demoediit(@PathVariable("id") int id, Model m) {
		Contect c = new Contect();
		m.addAttribute("cantect", c);

		return "user/update";
	}

	@GetMapping("/login")
	public String login(Model model) {

		Users user1 = new Users();
		user1.setEmail("manash@gmail");

		model.addAttribute("user", user1);

		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {

		UserHelper user1 = new UserHelper();
		user1.setUserName("manash");
		user1.setEmail("manash@gmail");

		model.addAttribute("user", user1);
		System.out.println("signup is good is ");
		return "regestration";
	}

	@PostMapping("/processuser")
	public String processuser(UserHelper dto) {

		userService.saveUser(dto);

		return "redirect:/login";

	}

}
