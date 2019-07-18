/**
 * 
 */
package com.mballem.demoajax.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author andersonnogueira
 * @since Jul 17, 2019
 */
@Controller
public class HomeController {
	
	@GetMapping("/")
	public String init() {
		return "redirect:/promocao/add";
	}
}
