package com.lacomer.app.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "DTO para pasar de la vista a la capa de negocio y viceversa")
public class UserUpDateVO {
    
	@Schema(description = "id de persona", example = "1")
    private Long id;
	
	@Schema(description = "Nombre de persona", example = "MarioX123")
    private String name;

    @Schema(description = "Apellido paterno", example = "Martinez")
    private String lastNameOne;

    @Schema(description = "Apellido materno", example = "Sanchez")
    private String lastNameTwo;

    @Schema(description = "Correo electrónico", example = "mariomartinez8310@gmail.com")
    private String mail;
    
    private String ip;


} 