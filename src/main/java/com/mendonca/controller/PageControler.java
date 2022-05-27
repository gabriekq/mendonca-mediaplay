package com.mendonca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageControler {

	
	
	@RequestMapping("/home")
	public String homePage() {
		return "homePage";
	}
	
	@RequestMapping("/sendMusic")
	public String musicUploadPage() {
		return "uploadMusic";
	}
	
	
}
