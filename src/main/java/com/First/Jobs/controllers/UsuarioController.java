package com.First.Jobs.controllers;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.First.Jobs.Dtos.UsuarioDto;
import com.First.Jobs.Service.UsuarioService;
import com.First.Jobs.models.ApiResponse;
import com.First.Jobs.models.Usuario;
import com.google.gson.Gson;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	
	UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<String> loginUser(@RequestBody Usuario usuario) {
        if (!isValidEmail(usuario.getNumero())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Gson().toJson(
                            new ApiResponse("El formato del número no es válido.", HttpStatus.BAD_REQUEST.value())));
        }
        return usuarioService.loginUsuario(usuario);
    }

    @PostMapping("/registrar")
    public ResponseEntity<String> registerUser(@RequestBody Usuario usuario) {
        if (!isValidEmail(usuario.getNumero())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Gson().toJson(
                            new ApiResponse("El formato del número no es válido.", HttpStatus.BAD_REQUEST.value())));
        }
        return usuarioService.registerUsuario(usuario);
    }

    private boolean isValidEmail(String email) {
        String dni = extractDNI(email);
        return usuarioService.isValidDNI(dni);
    }

    private String extractDNI(String email) {
        return email.substring(0, 8);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable Long id) {
        Optional<Usuario> usuarioOptional = this.usuarioService.obtenerPorId(id);
        return usuarioOptional.map(usuario -> ResponseEntity.ok(usuarioService.convertirAUsuarioDTO(usuario)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<String> eliminarPorId(@PathVariable Long id) {
        boolean eliminacionExitosa = this.usuarioService.eliminarUsuario(id);
        ApiResponse response = eliminacionExitosa
                ? new ApiResponse("Usuario eliminado con éxito", HttpStatus.OK.value())
                : new ApiResponse("No se pudo eliminar el usuario.", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(response.getEstado()).body(new Gson().toJson(response));
    }
}
