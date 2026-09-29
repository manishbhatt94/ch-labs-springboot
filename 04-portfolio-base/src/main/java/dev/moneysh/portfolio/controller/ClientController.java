package dev.moneysh.portfolio.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientController {

	@GetMapping("/home")
	public String indexPage(Model model) {
		Map<String, String> navItemCssClass = new HashMap<>();
		navItemCssClass.put("home", "active");
		model.addAttribute("navItemCssClass", navItemCssClass);
		return "index";
	}

	@GetMapping("/about")
	public String aboutPage(Model model) {
		Map<String, String> navItemCssClass = new HashMap<>();
		navItemCssClass.put("about", "active");
		model.addAttribute("navItemCssClass", navItemCssClass);
		return "about";
	}

	@GetMapping("/contact")
	public String contactPage(Model model) {
		Map<String, String> navItemCssClass = new HashMap<>();
		navItemCssClass.put("contact", "active");
		model.addAttribute("navItemCssClass", navItemCssClass);
		return "contact";
	}

	@GetMapping("/services")
	public String servicesPage(Model model) {
		Map<String, String> navItemCssClass = new HashMap<>();
		navItemCssClass.put("services", "active");
		model.addAttribute("navItemCssClass", navItemCssClass);
		return "services";
	}

}
