package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    private final usuarioRepositorio usuarioRepositorio;

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
}
