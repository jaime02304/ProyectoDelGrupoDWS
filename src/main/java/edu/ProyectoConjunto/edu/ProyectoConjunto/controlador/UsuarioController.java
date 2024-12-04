package edu.ProyectoConjunto.edu.ProyectoConjunto.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.ModificarUsuarioDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.UsuarioConAliasDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.UsuarioService;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.entidadUsuario;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.usuarioRepositorio;

/*
 * Clase del programa que controla la parte de los usuarios, los metodos de alta, baja y modificar.
 * CHI - 22/11/2024
 * */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
	
	/*
	 * Llamada al metodo service donde se encuentra toda la logica de la alta, baja, modificacion y muestra de usuarios.
	 * CHI - 02/12/2024
	 */
    @Autowired
    private UsuarioService usuarioService;
    
    /*
	 * Método que con el postmapping, la url y la llamada al usuarioService crea un usuario.
	 * CHI - 02/12/2024
	 */
    @PostMapping("/alta")
    public ResponseEntity<String> altaUsuario(@RequestBody usuarioDto usuarioDTO) {
        // Llamar al servicio para crear el nuevo usuario
        usuarioService.crearUsuario(usuarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario creado con éxito");
    }
    
    /*
	 * Método que con el postmapping, la url y la llamada al usuarioService da de baja un usuario.
	 * CHI - 02/12/2024
	 */
    @PostMapping("/baja")
    public ResponseEntity<String> bajaUsuario(@RequestBody String alias) {
        try {
            usuarioService.eliminarUsuarioPorAlias(alias);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario con alias " + alias + " eliminado con éxito.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    
    /*
	 * Método que con el getmapping, la url y la llamada al usuarioService muestra todos los usuarios y los envia al frontend.
	 * CHI - 02/12/2024
	 */
    @GetMapping("/obtenerTodosUsuarios")
    public ResponseEntity<List<Map<String, Object>>> obtenerTodosUsuarios() {
        // Obtener todos los usuarios del servicio
        List<UsuarioConAliasDto> usuarios = usuarioService.obtenerTodosUsuarios();
        
        // Crear una lista de mapas donde cada mapa representa un usuario
        List<Map<String, Object>> respuestaUsuarios = new ArrayList<>();
        
        // Si hay usuarios, transformarlos en mapas de clave-valor
        if (usuarios != null && !usuarios.isEmpty()) {
            for (UsuarioConAliasDto usuario : usuarios) {
                Map<String, Object> response = new HashMap<>();
                response.put("alias", usuario.getAlias());
                response.put("nombreUsu", usuario.getNombreUsuario());
                response.put("apellidoUsu", usuario.getApellidoUsuario());
                response.put("direccionUsu", usuario.getDireccion());
                response.put("esAdmin", usuario.getEsAdmin());
                response.put("imagenUsu", usuario.getImagenUsuario());
                
                // Añadir el mapa a la lista
                respuestaUsuarios.add(response);
            }
            
            return ResponseEntity.ok(respuestaUsuarios);  // Retorna la lista con código 200 OK
        } else {
            // Si no hay usuarios, retorna 204 No Content
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(respuestaUsuarios);
        }
    }
    
    /*
   	 * Método que con el putmapping, la url y la llamada al usuarioService edita un usuario.
   	 * CHI - 02/12/2024
   	 */
    @PutMapping("/modificar/{alias}")
    public ResponseEntity<String> modificarUsuario(@PathVariable String alias, 
                                                    @RequestBody ModificarUsuarioDto usuarioDto) {
        // Llamar al servicio para modificar el usuario
        boolean usuarioModificado = usuarioService.modificarUsuario(alias, usuarioDto);

        if (usuarioModificado) {
            // Si la modificación fue exitosa
            return ResponseEntity.ok("Usuario actualizado con éxito");
        } else {
            // Si no se encontró el usuario
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario no encontrado");
        }
    }



}
