package com.example.demo.controller;

import org. springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation. ResponseBody;

@Controller
public class HomeController {
	
	@GetMapping("/hello-html")
	@ResponseBody
	public String helloHtml() {
		return """
				<html>
				<body style='font-family:Arial; '>
				<h2> Hello From Spring MVC Demo !< /h2>
				<p> this Html is returned as plain string (no JSP) .< /p>
				</html>
				""";
	}
	
	@GetMapping("/hello-jsp")
	public String helloJsp(Model model) {
		model.addAttribute("App_name"," Simple MVc Application");
		model.addAttribute("author", "Geetha");
		model.addAttribute("message","Hello From JSP Page via Spring MVC Application");
		return "hello";
	}
	
}

