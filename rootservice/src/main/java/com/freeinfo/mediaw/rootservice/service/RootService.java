package com.freeinfo.mediaw.rootservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freeinfo.mediaw.rootservice.connector.GeolocalizationClient;
import com.freeinfo.mediaw.rootservice.connector.MediaworldClient;
import com.freeinfo.mediaw.rootservice.model.Location;
import com.freeinfo.mediaw.rootservice.model.MediaAvabilityDTO;

import feign.FeignException;

@Service
public class RootService {

	@Autowired
	GeolocalizationClient geolocalizationClient;
	
	@Autowired
	MediaworldClient mediaworldClient;
	
	public MediaAvabilityDTO getMediaLocations(String itemCode, String cordinate) {
		
		MediaAvabilityDTO response = new MediaAvabilityDTO();
		
		try {
			response = mediaworldClient.getAvability(itemCode, cordinate).getBody();
		} catch(FeignException ex) {
			System.out.println(ex);
		}
		
		
		
		return response;
		
	}
	
	public String getYourLocation(String location) {
		
		Location feignResponse = new Location();
		
		try {
			feignResponse = geolocalizationClient.getLocation(location).getBody();
		} catch(FeignException ex) {
			//TODO gestione della eccezione
		}
		
		return this.setCordiante(feignResponse);
	}
	
	private String setCordiante(Location location) {
		
		Double latitudine = location.getResults().get(0).getGeometry().getLat();
		Double longitudine = location.getResults().get(0).getGeometry().getLng();
	
		return latitudine + "," + longitudine;
		
	}
	
}
