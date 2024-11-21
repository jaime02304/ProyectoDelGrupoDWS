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

    @GetMapping("/verificarUsuario")
    public ResponseEntity<String> verificarUsuario(@RequestParam String correoUsuario, @RequestParam String contraseniaUsuario) {
        entidadUsuario usuario = usuarioService.verificarUsuario(correoUsuario, contraseniaUsuario);
        
        if (usuario != null) {
            boolean isAdmin = usuario.getEsAdmin();
            if (isAdmin) {
                return ResponseEntity.ok("{\"success\": true, \"isAdmin\": true}");
            } else {
                return ResponseEntity.ok("{\"success\": true, \"isAdmin\": false}");
            }
        } else {
            return ResponseEntity.ok("{\"success\": false, \"isAdmin\": false}"); // Usuario no encontrado o contraseña incorrecta
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

