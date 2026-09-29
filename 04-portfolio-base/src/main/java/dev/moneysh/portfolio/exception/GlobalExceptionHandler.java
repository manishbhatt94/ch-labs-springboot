package dev.moneysh.portfolio.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.moneysh.portfolio.util.ReferrerParser;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(Exception.class)
	@ExceptionHandler(value = { Exception.class })
	public String handleGeneralException(Exception ex, RedirectAttributes redirectAttrs, HttpServletRequest req) {
		redirectAttrs.addFlashAttribute("result", "Something went wrong.");
		String referrerPath = ReferrerParser.getReferrerPath(req);
		System.out.println("[GlobalExceptionHandler.handleGeneralException] referrerPath: " + referrerPath);
		return "redirect:" + referrerPath;
	}

}
