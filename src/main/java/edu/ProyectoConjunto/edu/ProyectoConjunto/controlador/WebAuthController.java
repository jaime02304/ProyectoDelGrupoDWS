package edu.ProyectoConjunto.edu.ProyectoConjunto.controlador;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class WebAuthController {

    private final UsuarioService usuarioService;

    @Autowired
    public WebAuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody usuarioDto usuarioDto) {
        // Autenticar al usuario solo con correoUsuario y contraseniaUsuario
        boolean authenticated = usuarioService.authenticate(usuarioDto.getCorreoUsuario(), usuarioDto.getContraseniaUsuario());

        if (authenticated) {
            // Verificar si es admin o no
            boolean isAdmin = usuarioService.isAdmin(usuarioDto.getCorreoUsuario());
            if (isAdmin) {
                return ResponseEntity.ok("admin");  // Si es admin
            } else {
                return ResponseEntity.ok("user");  // Si no es admin
            }
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");  // Si las credenciales son incorrectas
        }
    }
}

