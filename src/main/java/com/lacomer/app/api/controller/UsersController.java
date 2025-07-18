package com.lacomer.app.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lacomer.app.api.dto.UserUpDateVO;
import com.lacomer.app.api.dto.UserVO;
import com.lacomer.app.api.dto.out.ResponseDataDto;
import com.lacomer.app.api.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@Tag(name = "User", description = "API para gestionar Usuarios")
public class UsersController {

    private final UserService usersService;

    @PostMapping
    @Operation(summary = "Crear un nuev usuario", description = "Crea un nuevo usuario")
    @ApiResponse(responseCode = "201", description = "Usuario creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<ResponseDataDto> createUser(@Valid @RequestBody UserVO userVo) {
        return ResponseEntity.ok(usersService.create(userVo));
    }

    @GetMapping
    @Operation(
        summary = "Obtener todos los usuarios",
        description = "Obtiene todos los usuarios"
    )
    @ApiResponse(responseCode = "200", description = "Lista de usuarios")
    @ApiResponse(responseCode = "404", description = "Estrella no encontrada")
    public ResponseEntity<ResponseDataDto> getUsers() {
        return ResponseEntity.ok(usersService.getAllUsers());
    }

    @GetMapping("/{userId}")
    @Operation(
        summary = "Obtener datos de usuario",
        description = "Obtiene por id al usuario"
    )
    @ApiResponse(responseCode = "200", description = "Datos obtenidos exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<ResponseDataDto> getUserData(
        @Parameter(description = "ID del usuario", required = true)
        @PathVariable Long userId
    ) {
        return ResponseEntity.ok(usersService.getUserByIs(userId));
    }
    
    @PutMapping
    @Operation(summary = "Actualiza un usuario", description = "Actualiza un usuario")
    @ApiResponse(responseCode = "201", description = "Usuario actualizado exitosamente")
    @ApiResponse(responseCode = "400", description = "Datos de entrada inválidos")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<ResponseDataDto> updateUser(@Valid @RequestBody UserUpDateVO userUpdateVo) {
        return ResponseEntity.ok(usersService.update(userUpdateVo));
    }
    
    @DeleteMapping("/{userId}")
    @Operation(
        summary = "Borrado físico de usuario",
        description = "Borrado por id al usuario"
    )
    @ApiResponse(responseCode = "200", description = "Datos borrados exitosamente")
    @ApiResponse(responseCode = "404", description = "Usuario no encontrado")
    public ResponseEntity<ResponseDataDto> delUserData(
        @Parameter(description = "ID del usuario", required = true)
        @PathVariable Long userId
    ) {
        return ResponseEntity.ok(usersService.delUserByIs(userId));
    }
} 