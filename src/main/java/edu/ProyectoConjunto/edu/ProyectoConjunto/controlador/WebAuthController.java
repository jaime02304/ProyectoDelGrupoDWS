package edu.ProyectoConjunto.edu.ProyectoConjunto.controlador;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.UsuarioService;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.entidadUsuario;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.usuarioRepositorio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class WebAuthController {

    private final UsuarioService usuarioService;
    private  usuarioRepositorio usuarioRepositorio;

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

    @PostMapping("/registro")
    public ResponseEntity<String> register(@RequestBody usuarioDto usuarioDto) {
        boolean registrado = usuarioService.registroUser(usuarioDto);
        if (registrado) {
            return ResponseEntity.ok("Usuario registrado con éxito");
        } else {
            return ResponseEntity.status(400).body("El correo ya está en uso");
        }
    }
}

