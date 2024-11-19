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

    // Autenticar al usuario solo con correoUsuario y contraseniaUsuario
    public boolean authenticate(String correoUsuario, String contraseniaUsuario) {
        entidadUsuario usuario = usuarioRepositorio.findByCorreoUsuario(correoUsuario);  // Buscar usuario por correo
        return usuario != null && usuario.getContraseniaUsuario().equals(contraseniaUsuario);  // Validar contraseña
    }

    // Verificar si el usuario es administrador
    public boolean isAdmin(String correoUsuario) {
    	entidadUsuario usuario = usuarioRepositorio.findByCorreoUsuario(correoUsuario);  // Buscar usuario por correo
        return usuario != null && usuario.getEsAdmin();  // Verificar si es administrador
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
