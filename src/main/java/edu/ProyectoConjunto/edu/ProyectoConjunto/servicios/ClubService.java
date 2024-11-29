package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.ModificarClubDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.clubDto;

@Service
public class ClubService {

	@Autowired
    private clubRepositorio clubRepositorio; // Asegúrate de inyectarlo correctamente
	
	public ClubService(clubRepositorio clubRepositorio) {
        this.clubRepositorio = clubRepositorio;
	}

    public void crearClub(clubDto clubDTO) {
        entidadClub club = new entidadClub();
        club.setIdClub(clubDTO.getIdClub());
        club.setNombreClub(clubDTO.getNombreClub());
        club.setCorreoClub(clubDTO.getCorreoClub());
        club.setContraseniaClub(clubDTO.getContraseniaClub());
        club.setSedePrincipalClub(clubDTO.getSedePrincipalClub());
        club.setLocalidadClub(clubDTO.getLocalidadClub());
        club.setImagenClub(clubDTO.getImagenClub());
        
        
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
        for (entidadClub club : clubs) {
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

    @Transactional
    public boolean modificarClub(String nombreClub, ModificarClubDto clubDto) {
        // Buscar el club por nombre
        entidadClub clubExistente = clubRepositorio.findByNombreClub(nombreClub);

        if (clubExistente == null) {
            return false; // Club no encontrado
        }
        
        System.out.println("Antes de la modificación: " + clubExistente);

        // Modificar solo los campos que tienen valor en el DTO
        if (clubDto.getNombreClub() != null) {
            clubExistente.setNombreClub(clubDto.getNombreClub());
        }
        
        if (clubDto.getSedePrincipalClub() != null) {
            clubExistente.setSedePrincipalClub(clubDto.getSedePrincipalClub());
        }
        if (clubDto.getLocalidadClub() != null) {
            clubExistente.setLocalidadClub(clubDto.getLocalidadClub());
        }
        if (clubDto.getImagenClub() != null) {
            clubExistente.setImagenClub(clubDto.getImagenClub());
        }

        // Guardar los cambios en la base de datos
        clubRepositorio.save(clubExistente);
        
        System.out.println("Después de la modificación: " + clubExistente);

        return true; // Club actualizado con éxito
    }

}
