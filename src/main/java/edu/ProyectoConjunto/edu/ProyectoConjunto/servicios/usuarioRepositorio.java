package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface usuarioRepositorio extends JpaRepository<entidadUsuario, Long> {
	
    // Busca un usuario por correo
    entidadUsuario findByCorreoUsuario(String correoUsuario);
    
    entidadUsuario findByAlias(String alias);
    
    List<entidadUsuario> findAll();

}