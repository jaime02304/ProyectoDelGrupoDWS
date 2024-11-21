package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;


@Service
public class UsuarioService {

    private final usuarioRepositorio usuarioRepositorio;
    //private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Instancia directa

    @Autowired
    public UsuarioService(usuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    
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

        // Guardar el nuevo usuario en la base de datos
        usuarioRepositorio.save(nuevoUsuario);
    }
}
