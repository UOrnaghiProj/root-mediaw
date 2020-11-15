package com.freeinfo.mediaw.rootservice.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.freeinfo.mediaw.rootservice.model.Location;


@FeignClient(name = "Geolocalization")
public interface GeolocalizationClient {
	
	@GetMapping(value = "/geolocalize/location/{location}")
	public ResponseEntity<Location> getLocation(@PathVariable("location") String location);

}
