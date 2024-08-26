package com.smart.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
 
public class democont {

	@GetMapping("/man")
	public String name() {
		return "admine/index";
	}
}
