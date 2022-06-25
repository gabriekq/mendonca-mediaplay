package com.mendonca.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControler {

	
	@PreAuthorize("hasRole('USER')")
	@RequestMapping("/home")
	public String homePage() {
		return "homePage";
	}
	
	@RequestMapping("/sendMusic")
	public String musicUploadPage() {
		return "uploadMusic";
	}
	
	
}
