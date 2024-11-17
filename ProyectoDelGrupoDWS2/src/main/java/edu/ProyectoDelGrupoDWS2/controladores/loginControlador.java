package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class loginControlador {

	// Mapea la ruta "/login"
	@GetMapping("/login")
	public String login() {
		return "login"; // Renderiza la página de login
	}
}
