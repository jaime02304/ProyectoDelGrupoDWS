package edu.ProyectoConjunto.edu.ProyectoConjunto.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.UsuarioService;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.entidadUsuario;

@RestController
@RequestMapping("/api/ProyectoDWS")
public class WebAuthController {

	@Autowired
    private final UsuarioService usuarioService;

    
    public WebAuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    
    @GetMapping("/verificarUsuario")
    public ResponseEntity<Map<String, Object>> verificarUsuario(
            @RequestParam String correoUsuario,
            @RequestParam String contraseniaUsuario) {
        
        entidadUsuario usuario = usuarioService.verificarUsuario(correoUsuario, contraseniaUsuario);
        
        Map<String, Object> response = new HashMap<>();
        if (usuario != null) {
            response.put("esAdmin", usuario.getEsAdmin());// Asumiendo que tienes un método isAdmin()
            response.put("correoUsu", usuario.getCorreoUsuario());
            response.put("contraseniaUsu", usuario.getContraseniaUsuario());
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("esAdmin", false);
            return ResponseEntity.ok(response); // Cambiado a 200 para mantener la consistencia
        }
    }

    @PostMapping("/registro")
    public ResponseEntity<String> register(@RequestBody usuarioDto usuarioDto) {
        try {
            usuarioService.crearUsuario(usuarioDto);
            return ResponseEntity.ok("Usuario registrado con éxito");
        } catch (Exception e) {
            // Manejo de errores, por ejemplo, si el correo ya está en uso
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El correo ya está en uso");
        }
    }
}

