package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface clubRepositorio extends JpaRepository<entidadClub, Long> {
	entidadClub findByNombreClub(String nombreClub);
	
	List<entidadClub> findAll();
}