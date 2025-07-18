package com.lacomer.app.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response {

	private String ip;
	private String continentName;
	private String continentCode;
	private String countryName;
	private String countryCode;
	private String cityName;
	private String postalCode;
	private Double latitude;
	private Double longitude;
	private String timeZone;
	private String urlGoogleMaps;
	private String mapGoogleMaps;
}
