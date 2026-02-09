package com.spring.system.controller;

import com.spring.system.dto.UserCreateDTO;
import com.spring.system.dto.UserUpdateDTO;
import com.spring.system.dto.UserResponseDTO;
import com.spring.system.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Tag(name = "Users", description = "Operaciones CRUD sobre usuarios")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Operation(summary = "Obtener todos los usuarios")
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @Operation(summary = "Obtener usuario por ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @Operation(summary = "Crear un nuevo usuario")
    @PostMapping
    public ResponseEntity<UserResponseDTO> save(@Valid @RequestBody UserCreateDTO dto) {
        UserResponseDTO response = userService.save(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar un usuario existente")
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> update(@PathVariable Long id,
                                                  @Valid @RequestBody UserUpdateDTO dto) {
        UserResponseDTO updated = userService.update(id, dto);
        return ResponseEntity.ok(updated);
    }

    @Operation(summary = "Eliminar un usuario por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}