package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.ModificarUsuarioDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.UsuarioConAliasDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;

	/*
	 * Servicio donde se encuentra la logica de los usuarios.
	 * CHI - 02/12/2024
	 */

@Service
public class UsuarioService {
	
	/*
	 * Método que llama a usuarioRepositorio que contiene por lo que se va a buscar a los usuarios.
	 * CHI - 02/12/2024
	 */
	@Autowired
    private final usuarioRepositorio usuarioRepositorio;
    //private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Instancia directa

    
    public UsuarioService(usuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    /*
   	 * Método que a traves del correo y la contraseña verifica que el usuario exista en la bbdd y que la contraseña es correcta.
   	 * CHI - 02/12/2024
   	 */
    public entidadUsuario verificarUsuario(String correoUsuario, String contraseniaUsuario) {
        System.out.println("Verificando usuario: " + correoUsuario);
        entidadUsuario usuario = usuarioRepositorio.findByCorreoUsuario(correoUsuario);
        
        if (usuario != null) {
            System.out.println("Usuario encontrado: " + usuario.getCorreoUsuario());
            System.out.println("Contraseña almacenada: " + usuario.getContraseniaUsuario()); // Log para ver la contraseña almacenada
            if (usuario.getContraseniaUsuario().equals(contraseniaUsuario)) {
                System.out.println("Contraseña correcta");
                return usuario;
            } else {
                System.out.println("Contraseña incorrecta");
            }
        } else {
            System.out.println("Usuario no encontrado");
        }
        return null;
    }
   
    /*
   	 * Método que con que se crea un usuario a la bbdd.
   	 * CHI - 02/12/2024
   	 */
    
 // Método en UsuarioService
    public void crearUsuario(usuarioDto usuarioDTO) {
        // Convertir el DTO a la entidad
        entidadUsuario nuevoUsuario = new entidadUsuario();
        
        nuevoUsuario.setNombreUsuario(usuarioDTO.getNombreUsuario());
        nuevoUsuario.setApellidoUsuario(usuarioDTO.getApellidoUsuario());
        nuevoUsuario.setCorreoUsuario(usuarioDTO.getCorreoUsuario());
        nuevoUsuario.setContraseniaUsuario(usuarioDTO.getContraseniaUsuario());
        nuevoUsuario.setDniUsuario(usuarioDTO.getDniUsuario());
        nuevoUsuario.setEsAdmin(usuarioDTO.getEsAdmin());
        nuevoUsuario.setImagenUsuario(usuarioDTO.getImagenUsuario());
        nuevoUsuario.setDireccion(usuarioDTO.getDireccion());
        nuevoUsuario.setAlias(usuarioDTO.getAlias());
        // nuevoUsuario.setClubPerteneciente(usuarioDTO.getClubPerteneciente());

        /// Guardar el nuevo usuario en la base de datos
        entidadUsuario usuarioGuardado = usuarioRepositorio.save(nuevoUsuario);
        
        // Establecer el ID en el DTO, si es necesario para responder al frontend
        usuarioDTO.setIdUsuario(usuarioGuardado.getIdUsuario());
    }
    
	    public void eliminarUsuarioPorAlias(String alias) {
	        // Buscar el usuario por alias
	        entidadUsuario usuario = usuarioRepositorio.findByAlias(alias);
	        if (usuario != null) {
	            usuarioRepositorio.delete(usuario); // Eliminar el usuario encontrado
	            System.out.println("Usuario con alias " + alias + " eliminado.");
	        } else {
	            throw new IllegalArgumentException("Usuario con alias " + alias + " no encontrado.");
	        }
	    }
    
    
    
    public List<UsuarioConAliasDto> obtenerTodosUsuarios() {
        // Recuperamos todos los usuarios de la base de datos
        List<entidadUsuario> usuarios = usuarioRepositorio.findAll();
        
        // Creamos una lista para los DTOs
        List<UsuarioConAliasDto> usuariosDto = new ArrayList<>();
        
        // Convertimos cada usuario en un DTO
        for (entidadUsuario usuario : usuarios) {
            UsuarioConAliasDto dto = new UsuarioConAliasDto();
            dto.setAlias(usuario.getAlias());
            dto.setNombreUsuario(usuario.getNombreUsuario());
            dto.setApellidoUsuario(usuario.getApellidoUsuario());
            dto.setDireccion(usuario.getDireccion());
            dto.setEsAdmin(usuario.getEsAdmin());
            dto.setImagenUsuario(usuario.getImagenUsuario());  // Si tienes la imagen almacenada como un String o byte[] en la base de datos
            
            usuariosDto.add(dto);
        }

        return usuariosDto;  // Devolvemos la lista de usuarios en formato DTO
    }
    
    public boolean modificarUsuario(String alias, ModificarUsuarioDto usuarioDto) {
        // Buscar el usuario por alias
        entidadUsuario usuarioExistente = usuarioRepositorio.findByAlias(alias);

        if (usuarioExistente == null) {
            return false; // Usuario no encontrado
        }

        // Modificar solo los campos que tienen valor en el DTO
        if (usuarioDto.getNombreUsuario() != null) {
            usuarioExistente.setNombreUsuario(usuarioDto.getNombreUsuario());
        }
        if (usuarioDto.getApellidoUsuario() != null) {
            usuarioExistente.setApellidoUsuario(usuarioDto.getApellidoUsuario());
        }
        if (usuarioDto.getDireccion() != null) {
            usuarioExistente.setDireccion(usuarioDto.getDireccion());
        }
        if (usuarioDto.getImagenUsuario() != null) {
            usuarioExistente.setImagenUsuario(usuarioDto.getImagenUsuario());
        }
        if (usuarioDto.getEsAdmin() != null) {
            usuarioExistente.setEsAdmin(usuarioDto.getEsAdmin());
        }

        // Guardar el usuario actualizado en la base de datos
        usuarioRepositorio.save(usuarioExistente);

        return true; // Usuario actualizado con éxito
    }

}
