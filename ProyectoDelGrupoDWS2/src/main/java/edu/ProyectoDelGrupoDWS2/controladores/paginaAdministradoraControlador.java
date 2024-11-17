package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class paginaAdministradoraControlador {

	// Mapea la ruta "/paginaAdministradora"
	@GetMapping("/paginaAdministradora")
	public String paginaAdministradora() {
		return "paginaAdministradora"; // Renderiza la página de administrador
	}
}
