package com.freeinfo.mediaw.rootservice.exception;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Controller
public class ExceptionHandler extends ResponseEntityExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
	@ResponseStatus
	public final String exceptionControllerHandler(NotFoundException ex, Model model){
		
		model.addAttribute("errore",true);
		model.addAttribute("messaggio",ex.getMessaggio());
		
		return "index :: errMsg";
		
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler(MediaworldException.class)
	@ResponseStatus
	public final String exceptionControllerHandler(MediaworldException ex, Model model){
		
		model.addAttribute("errore",true);
		model.addAttribute("messaggio",ex.getMessaggio());
		
		return "index :: errMsg";
		
	}
	
	

}
