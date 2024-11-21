package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;

@Service
public class UsuarioService {

    private final usuarioRepositorio usuarioRepositorio;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); // Instancia directa

    @Autowired
    public UsuarioService(usuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

	 //Método para verificar si el usuario existe y si la contraseña es correcta
	    public entidadUsuario verificarUsuario(String correoUsuario, String contraseniaUsuario) {
	        entidadUsuario usuario = usuarioRepositorio.findByCorreoUsuario(correoUsuario);
	        if (usuario != null && passwordEncoder.matches(contraseniaUsuario, usuario.getContraseniaUsuario())) {
	            return usuario; // Retorna el usuario si la contraseña es correcta
	        }
	        return null; // Retorna null si no se encuentra el usuario o la contraseña es incorrecta
	    }
    
    
    	public boolean registroUser (usuarioDto usuarioDto) {
    	
        // Verificar si el correo ya está en uso
		if (usuarioRepositorio.findByCorreoUsuario(usuarioDto.getCorreoUsuario()) != null) {
		    return false; // El usuario ya existe
		}
		
		// Crear nueva entidad de usuario
		entidadUsuario nuevoUsuario = new entidadUsuario();
		nuevoUsuario.setNombreUsuario(usuarioDto.getNombreUsuario());
		nuevoUsuario.setApellidoUsuario(usuarioDto.getApellidoUsuario());
		nuevoUsuario.setCorreoUsuario(usuarioDto.getCorreoUsuario());
		nuevoUsuario.setContraseniaUsuario(passwordEncoder.encode(usuarioDto.getContraseniaUsuario())); // Hashear la contraseña
		nuevoUsuario.setDniUsuario(usuarioDto.getDniUsuario());
		nuevoUsuario.setEsAdmin(usuarioDto.getEsAdmin());
		nuevoUsuario.setImagenUsuario(usuarioDto.getImagenUsuario());
		nuevoUsuario.setDireccion(usuarioDto.getDireccion());
		nuevoUsuario.setAlias(usuarioDto.getAlias());
		// Aquí puedes establecer el clubPerteneciente si es necesario
		
		// Guardar el nuevo usuario en la base de datos
		usuarioRepositorio.save(nuevoUsuario);
		return true; // Registro exitoso
		}
}
