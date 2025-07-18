package com.lacomer.app.api.facades;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.lacomer.app.api.dto.Response;
import com.lacomer.app.api.dto.RootIP;


@Component
public class DirectionsFacade {

	private RestTemplate restTemplate;
	
	@Value(value = "${lacomer.copomex.api.base}")
	private String apiCopomex;

	@Autowired
	public DirectionsFacade(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public Response getDirectionByName() {
		ResponseEntity<RootIP> ipPhysical = this.restTemplate.exchange(this.apiCopomex, HttpMethod.GET, null, RootIP.class);
		
		return ipPhysical.getBody().getMultiserviciosweb().getResponse();
	}
	
	
}
