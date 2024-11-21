package edu.ProyectoConjunto.edu.ProyectoConjunto.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

    private final UsuarioService usuarioService;

    @Autowired
    public WebAuthController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

//    @GetMapping("/verificarUsuario")
//    public ResponseEntity<String> verificarUsuario(@RequestParam String correoUsuario, @RequestParam String contraseniaUsuario) {
//        entidadUsuario usuario = usuarioService.verificarUsuario(correoUsuario, contraseniaUsuario);
//        
//        if (usuario != null) {
//            boolean isAdmin = usuario.getEsAdmin();
//            if (isAdmin) {
//                return ResponseEntity.ok("{\"success\": true, \"isAdmin\": true}");
//            } else {
//                return ResponseEntity.ok("{\"success\": true, \"isAdmin\": false}");
//            }
//        } else {
//            return ResponseEntity.ok("{\"success\": false, \"isAdmin\": false}"); // Usuario no encontrado o contraseña incorrecta
//        }
//    }
    
    @GetMapping("/verificarUsuario")
    public ResponseEntity<Map<String, Object>> verificarUsuario(
            @RequestParam String correoUsuario,
            @RequestParam String contraseniaUsuario) {
        
        entidadUsuario usuario = usuarioService.verificarUsuario(correoUsuario, contraseniaUsuario);
        
        Map<String, Object> response = new HashMap<>();
        if (usuario != null) {
            response.put("success", true);
            response.put("isAdmin", usuario.getEsAdmin()); // Asumiendo que tienes un método isAdmin()
            return ResponseEntity.ok(response);
        } else {
            response.put("success", false);
            response.put("isAdmin", false);
            return ResponseEntity.ok(response); // Cambiado a 200 para mantener la consistencia
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

