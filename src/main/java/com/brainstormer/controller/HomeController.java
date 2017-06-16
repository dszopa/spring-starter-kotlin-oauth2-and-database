package com.brainstormer.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/")
	public String home() {
		return "home";
	}

	@PreAuthorize("permitAll()")
	@RequestMapping("/remember")
	public String remember() {
		return "remember";
	}
}