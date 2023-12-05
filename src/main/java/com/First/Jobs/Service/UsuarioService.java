package com.First.Jobs.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.First.Jobs.Dtos.UsuarioDto;
import com.First.Jobs.models.ApiResponse;
import com.First.Jobs.models.Usuario;
import com.First.Jobs.repositories.UsuarioRepository;
import com.google.gson.Gson;


@Service
public class UsuarioService {
	 private final UsuarioRepository usuarioRepository;

	    public UsuarioService(UsuarioRepository usuarioRepository) {
	        this.usuarioRepository = usuarioRepository;
	    }

	    public ArrayList<Usuario> obtenerUsuarios() {
	        return (ArrayList<Usuario>) usuarioRepository.findAll();
	    }

	    public Usuario guardarUsuario(Usuario usuario) {
	        return usuarioRepository.save(usuario);
	    }

	    public Optional<Usuario> obtenerPorId(Long id) {
	        return usuarioRepository.findById(id);
	    }

	    public ArrayList<Usuario> obtenerPorPassword(Integer password) {
	        return usuarioRepository.findByPassword(password);
	    }

	    public boolean eliminarUsuario(Long id) {
	        try {
	            usuarioRepository.deleteById(id);
	            return true;
	        } catch (Exception err) {
	            return false;
	        }
	    }

	    public ResponseEntity<String> loginUsuario(Usuario usuario) {
	        String numero = usuario.getNumero();
	        String password = usuario.getPassword();
	        Usuario usuarioExistente = findByNumero(numero);
	        if (usuarioExistente == null) {
	            return ResponseEntity.status(HttpStatus.NOT_FOUND)
	                    .body(new Gson().toJson(new ApiResponse("Datos incorrectos.", HttpStatus.NOT_FOUND.value())));
	        }
	        if (!usuarioExistente.getPassword().equals(password)) {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                    .body(new Gson().toJson(new ApiResponse("Datos incorrectos.", HttpStatus.UNAUTHORIZED.value())));
	        }
	        return ResponseEntity.status(HttpStatus.OK)
	                .body(new Gson().toJson(new ApiResponse("Inicio de sesión exitoso", HttpStatus.OK.value())));
	    }

	    public ResponseEntity<String> registerUsuario(Usuario usuario) {
	        try {
	            if (findByNumero(usuario.getNumero()) != null) {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                        .body(new Gson()
	                                .toJson(new ApiResponse("El número ya está en uso.", HttpStatus.BAD_REQUEST.value())));
	            }
	            if (!isValidNumero(usuario.getNumero())) {
	                return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                        .body(new Gson().toJson(
	                                new ApiResponse("El número debe tener exactamente 8 dígitos.",
	                                        HttpStatus.BAD_REQUEST.value())));
	            }
	            guardarUsuario(usuario);
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body(new Gson()
	                            .toJson(new ApiResponse("Usuario registrado con éxito", HttpStatus.CREATED.value())));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body(new Gson().toJson(
	                            new ApiResponse("Error interno del servidor.", HttpStatus.INTERNAL_SERVER_ERROR.value())));
	        }
	    }

	    private boolean isValidNumero(String numero) {
	        return numero != null && numero.matches("\\d{8}");
	    }

	    public Usuario findByNumero(String email) {
	        return usuarioRepository.findByNumero(email);
	    }

	    public Usuario findByTipo(String userName) {
	        return usuarioRepository.findByTipo(userName);
	    }

	    public Usuario findByPassword(String password) {
	        return usuarioRepository.findByPassword(password);
	    }

	    public UsuarioDto convertirAUsuarioDTO(Usuario usuario) {
	        UsuarioDto usuarioDTO = new UsuarioDto();
	        usuarioDTO.setTipo(usuario.getTipo());
	        return usuarioDTO;
	    }

	    public boolean isValidDNI(String dni) {
	        return dni != null && dni.matches("\\d{8}");
	    }

	    public String extractDNI(String email) {
	        String[] parts = email.split("@");
	        if (parts.length == 2) {
	            return parts[1].substring(0, Math.min(parts[1].length(), 8));
	        } else {
	            return null;
	        }
	    }

}
