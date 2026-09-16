package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.entity.EmployeeEntity;
import com.example.demo.service.MyService;

@Controller
@RequestMapping("/app")
public class MyController {

	private final MyService service;

	public MyController(MyService service) {
		super();
		this.service = service;
	}

	@GetMapping("/registration")
	public String registrationView() {
		return "registration";
	}

	@PostMapping("/registration/save")
	public String registrationSaveEmployee(@ModelAttribute EmployeeRequestDto employeeRequest,
			RedirectAttributes redirectAttrs) {

		System.out.println("Received registration request data: " + employeeRequest);

		try {
			EmployeeEntity savedEmployee = service.save(employeeRequest);
			System.out.println("Save operation successful. Saved employee entity: " + savedEmployee);
			redirectAttrs.addFlashAttribute("saveActionSuccess", "Data saved successfully.");
		} catch (Exception e) {
			System.out.println("Save operation failed. Exception: " + e);
			redirectAttrs.addFlashAttribute("saveActionFailure",
					"Some problem occurred in saving data. Please try again later.");
		}
		return "redirect:/app/registration"; // P-R-G Pattern (Post-Redirect-Get)
	}

}
