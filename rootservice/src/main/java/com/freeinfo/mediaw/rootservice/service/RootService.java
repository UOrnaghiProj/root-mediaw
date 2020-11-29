package com.freeinfo.mediaw.rootservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeinfo.mediaw.rootservice.connector.GeolocalizationClient;
import com.freeinfo.mediaw.rootservice.connector.MediaworldClient;
import com.freeinfo.mediaw.rootservice.exception.MediaworldException;
import com.freeinfo.mediaw.rootservice.exception.NotFoundException;
import com.freeinfo.mediaw.rootservice.model.Location;
import com.freeinfo.mediaw.rootservice.model.MediaAvabilityDTO;

import feign.FeignException;

@Service
public class RootService {

	@Autowired
	GeolocalizationClient geolocalizationClient;
	
	@Autowired
	MediaworldClient mediaworldClient;
	
	public MediaAvabilityDTO getMediaLocations(String itemCode, String cordinate) throws MediaworldException {
		
		MediaAvabilityDTO response = new MediaAvabilityDTO();
		
		try {
			response = mediaworldClient.getAvability(itemCode, cordinate).getBody();
			
		} catch(FeignException ex) {
			throw new MediaworldException();
		}
		
		
		
		return response;
		
	}
	
	public String getYourLocation(String location) throws NotFoundException {
		
		Location feignResponse = new Location();
		
		try {
			feignResponse = geolocalizationClient.getLocation(location).getBody();
		} catch(FeignException ex) {
			throw new NotFoundException(ex.getMessage());
		}
		
		return this.setCordiante(feignResponse);
	}
	
	private String setCordiante(Location location) {
		
		Double latitudine = location.getResults().get(0).getGeometry().getLat();
		Double longitudine = location.getResults().get(0).getGeometry().getLng();
	
		return latitudine + "," + longitudine;
		
	}
	
}
