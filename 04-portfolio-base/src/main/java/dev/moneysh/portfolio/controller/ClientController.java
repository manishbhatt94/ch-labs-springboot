package dev.moneysh.portfolio.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.moneysh.portfolio.dto.ContactMessageDto;
import dev.moneysh.portfolio.service.ContactMessageService;
import lombok.AllArgsConstructor;

@Controller
@RequestMapping("/client")
@AllArgsConstructor
public class ClientController {

	private final ContactMessageService contactMessageService;

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

	@PostMapping("/save-contact-message")
	public String saveContactMessage(@ModelAttribute ContactMessageDto contactMessageDto,
			RedirectAttributes redirectAttrs) {
		contactMessageService.saveContactMessage(contactMessageDto);
		redirectAttrs.addFlashAttribute("result", "Contact message sent successfully.");
		return "redirect:/client/contact";
	}

}
