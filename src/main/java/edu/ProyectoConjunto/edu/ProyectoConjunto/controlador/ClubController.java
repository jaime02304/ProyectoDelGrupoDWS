package edu.ProyectoConjunto.edu.ProyectoConjunto.controlador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.ModificarClubDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.clubDto;
import edu.ProyectoConjunto.edu.ProyectoConjunto.servicios.ClubService;

@RestController
@RequestMapping("/api/clubs")
public class ClubController {

    @Autowired
    private ClubService clubService;

    // Alta de club
    @PostMapping("/alta")
    public ResponseEntity<String> altaClub(@RequestBody clubDto clubDTO) {
        clubService.crearClub(clubDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Club creado con éxito");
    }

    @PostMapping("/baja")
    public ResponseEntity<String> bajaClub(@RequestBody String nombreClub) {
        try {
            clubService.eliminarClubPorNombre(nombreClub);
            return ResponseEntity.status(HttpStatus.OK).body("Club con nombre " + nombreClub + "eliminado con éxito.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



    @GetMapping("/obtenerTodosClubs")
    public ResponseEntity<List<Map<String, Object>>> obtenerTodosClubs() {
        // Obtener todos los clubs del servicio
        List<clubDto> clubs = clubService.obtenerTodosClubs();

        // Crear una lista de mapas donde cada mapa representa un club
        List<Map<String, Object>> respuestaClubs = new ArrayList<>();

        // Si hay clubs, transformarlos en mapas de clave-valor
        if (clubs != null && !clubs.isEmpty()) {
            for (clubDto club : clubs) {
                Map<String, Object> response = new HashMap<>();
                response.put("idClub", club.getIdClub());
                response.put("nombreClub", club.getNombreClub());
                response.put("correoClub", club.getCorreoClub());
                response.put("sedePrincipalClub", club.getSedePrincipalClub());
                response.put("localidadClub", club.getLocalidadClub());
                response.put("imagenClub", club.getImagenClub());

                // Añadir el mapa a la lista
                respuestaClubs.add(response);
            }

            return ResponseEntity.ok(respuestaClubs); // Retorna la lista con código 200 OK
        } else {
            // Si no hay clubs, retorna 204 No Content
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(respuestaClubs);
        }
    }


    @PutMapping("/modificar/{nombreClub}")
    public ResponseEntity<String> modificarClub(@PathVariable String nombreClub, 
                                                @RequestBody ModificarClubDto clubDto) {
        boolean clubModificado = clubService.modificarClub(nombreClub, clubDto);

        if (clubModificado) {
            return ResponseEntity.ok("Club actualizado con éxito");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Club no encontrado");
        }
    }

}

