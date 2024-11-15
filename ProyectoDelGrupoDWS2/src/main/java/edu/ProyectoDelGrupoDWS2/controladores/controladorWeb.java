package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class controladorWeb {

	// Mapea la ruta raíz "/"
	@GetMapping("/")
	public String index() {
		return "index"; // Renderiza la plantilla index.html en templates
	}

	// Mapea la ruta "/paginaAdministradora"
	@GetMapping("/paginaAdministradora")
	public String paginaAdministradora() {
		return "paginaAdministradora"; // Renderiza la página de administrador
	}

	// Mapea la ruta "/login"
	@GetMapping("/login")
	public String login() {
		return "login"; // Renderiza la página de login
	}

}
