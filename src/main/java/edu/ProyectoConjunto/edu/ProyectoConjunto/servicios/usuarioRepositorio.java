package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;

import java.util.Optional;
@Repository
public interface usuarioRepositorio extends JpaRepository<entidadUsuario, Long> {
	
    // Busca un usuario por correo
    entidadUsuario findByCorreoUsuario(String correoUsuario);

}