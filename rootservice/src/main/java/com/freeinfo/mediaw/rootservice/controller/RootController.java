package com.freeinfo.mediaw.rootservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.freeinfo.mediaw.rootservice.exception.MediaworldException;
import com.freeinfo.mediaw.rootservice.exception.NotFoundException;
import com.freeinfo.mediaw.rootservice.model.MediaAvabilityDTO;
import com.freeinfo.mediaw.rootservice.service.RootService;


@Controller
public class RootController {
	
	@Autowired
	private RootService rootService;

	@GetMapping(value = "/avability")
	public String getCoordinates(@RequestParam(value = "location") String location,
								 @RequestParam(value = "itemCode") String itemCode,
								 Model model) throws NotFoundException, MediaworldException {
		
		String cordinate = rootService.getYourLocation(location);
		
		MediaAvabilityDTO resp = rootService.getMediaLocations(itemCode, cordinate);
		
		model.addAttribute("result",resp);
		
		return "index :: tabModale";
		
	}
	
	@GetMapping(value = "/")
	public String getHome(Model model) {
		
		model.addAttribute("errore",false);
		
		return "index";
	}
	
}
