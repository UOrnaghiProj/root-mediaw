package com.freeinfo.mediaw.rootservice.connector;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.freeinfo.mediaw.rootservice.model.MediaAvabilityDTO;


@FeignClient(name = "Mediaworld")

public interface MediaworldClient {

	@GetMapping(value = "/mediaworld/avability")
	public ResponseEntity<MediaAvabilityDTO> getAvability(@RequestParam(value = "itemCode") String itemCode,
			@RequestParam(value = "cordinate") String cordinate);
	
}
