package dev.moneysh.portfolio.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(Exception.class)
	@ExceptionHandler(value = { Exception.class })
	public String handleGeneralException(Exception ex, RedirectAttributes redirectAttrs) {
		redirectAttrs.addFlashAttribute("result", "Something went wrong.");
		return "redirect:/client/contact";
	}

}
