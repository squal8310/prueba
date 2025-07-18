package com.lacomer.app.api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Schema(description = "DTO para pasar de la vista a la capa de negocio y viceversa")
public class UserVO {
    
	@Schema(description = "id de persona", example = "1")
    private Long id;
	
	@Schema(description = "Nombre de persona", example = "MarioX123")
    @NotNull(message = "El nombre no debe ser vacio")
    private String name;

    @Schema(description = "Apellido paterno", example = "Martinez")
    @NotNull(message = "El apellido paterno no debe ser vacio")
    private String lastNameOne;

    @Schema(description = "Apellido materno", example = "Sanchez")
    @NotNull(message = "El apellido materno no debe ser vacio")
    private String lastNameTwo;

    @Schema(description = "Correo electrónico", example = "mariomartinez8310@gmail.com")
    @NotNull(message = "No puede ir vacio el correo electrónico")
    private String mail;
    
    private String ip;

} 