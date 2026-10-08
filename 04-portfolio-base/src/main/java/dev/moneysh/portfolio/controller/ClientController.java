package dev.moneysh.portfolio.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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
	public String saveContactMessage(@Valid @ModelAttribute ContactMessageDto contactMessageDto,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttrs) {

		if (bindingResult.hasErrors()) {
			// @formatter:off
		    Map<String, List<String>> errors = bindingResult.getFieldErrors().stream()
		            .collect(Collectors.groupingBy(
		                    FieldError::getField,
		                    LinkedHashMap::new,                                   // preserve field order
		                    Collectors.mapping(FieldError::getDefaultMessage,
		                                       Collectors.toList())));
		    // @formatter:on

			System.out.println("Grouped field errors: " + errors);

			model.addAttribute("errors", errors);
			model.addAttribute("result", "Contact Form has error(s). Please rectify & re-submit.");
			return "contact";
		}

		contactMessageService.saveContactMessage(contactMessageDto);
		redirectAttrs.addFlashAttribute("result", "Contact message sent successfully.");
		return "redirect:/client/contact";
	}

}
