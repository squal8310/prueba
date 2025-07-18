package com.lacomer.app.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "DTO para pasar de la vista a la capa de negocio y viceversa")
public class AddresVO {

	private Long idDirection;
	
	private String street;

    private String city;

    private String state;

    private Integer postalCode;

}
