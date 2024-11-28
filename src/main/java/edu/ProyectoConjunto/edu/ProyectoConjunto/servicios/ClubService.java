package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.ModificarClubDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.clubDto;

@Service
public class ClubService {

	@Autowired
    private clubRepositorio clubRepositorio; // Asegúrate de inyectarlo correctamente
	
    private List<entidadClub> listaClubs = new ArrayList<>();

    public void crearClub(clubDto clubDTO) {
        entidadClub club = new entidadClub();
        club.setIdClub(clubDTO.getIdClub());
        club.setNombreClub(clubDTO.getNombreClub());
        club.setCorreoClub(clubDTO.getCorreoClub());
        club.setContraseniaClub(clubDTO.getContraseniaClub());
        club.setSedePrincipalClub(clubDTO.getSedePrincipalClub());
        club.setLocalidadClub(clubDTO.getLocalidadClub());
        club.setImagenClub(clubDTO.getImagenClub());
        listaClubs.add(club);
        
        entidadClub clubGuardado = clubRepositorio.save(club);
        clubDTO.setIdClub(clubGuardado.getIdClub());
    }

    public void eliminarClubPorNombre(String nombreClub) {
        // Buscar el club por su nombre
    	entidadClub club = clubRepositorio.findByNombreClub(nombreClub);
        if (club != null) {
            // Eliminar el club encontrado
            clubRepositorio.delete(club);
            System.out.println("Club con nombre " + nombreClub + " eliminado.");
        } else {
            // Lanzar excepción si no se encuentra
            throw new IllegalArgumentException("Club con nombre " + nombreClub + " no encontrado.");
        }
    }



    public List<clubDto> obtenerTodosClubs() {
    	List<entidadClub> clubs = clubRepositorio.findAll();
        List<clubDto> resultado = new ArrayList<>();
        for (entidadClub club : listaClubs) {
            clubDto dto = new clubDto();
            dto.setIdClub(club.getIdClub());
            dto.setNombreClub(club.getNombreClub());
            dto.setCorreoClub(club.getCorreoClub());
            dto.setSedePrincipalClub(club.getSedePrincipalClub());
            dto.setLocalidadClub(club.getLocalidadClub());
            dto.setImagenClub(club.getImagenClub());
            resultado.add(dto);
        }
        return resultado;
    }

    public boolean modificarClub(String nombreClub, ModificarClubDto modificarClubDto) {
        // Buscar el club por nombre
        entidadClub clubExistente = clubRepositorio.findByNombreClub(nombreClub);

        if (clubExistente == null) {
            return false; // Club no encontrado
        }

        // Modificar solo los campos que tienen valor en el DTO
        if (modificarClubDto.getNombreClub() != null) {
            clubExistente.setNombreClub(modificarClubDto.getNombreClub());
        }
        if (modificarClubDto.getCorreoClub() != null) {
            clubExistente.setCorreoClub(modificarClubDto.getCorreoClub());
        }
        if (modificarClubDto.getSedePrincipalClub() != null) {
            clubExistente.setSedePrincipalClub(modificarClubDto.getSedePrincipalClub());
        }
        if (modificarClubDto.getLocalidadClub() != null) {
            clubExistente.setLocalidadClub(modificarClubDto.getLocalidadClub());
        }
        if (modificarClubDto.getImagenClub() != null) {
            clubExistente.setImagenClub(modificarClubDto.getImagenClub());
        }

        // Guardar los cambios en la base de datos
        clubRepositorio.save(clubExistente);

        return true; // Club actualizado con éxito
    }

}
