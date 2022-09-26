/**
 * 
 */
package com.prodemy.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wyant
 *
 */
@Controller
public class HelloController {

	@RequestMapping("/")
	public String display(Model model) {
		model.addAttribute("greeting", "Hello awy");
		return "index";
	}
}
