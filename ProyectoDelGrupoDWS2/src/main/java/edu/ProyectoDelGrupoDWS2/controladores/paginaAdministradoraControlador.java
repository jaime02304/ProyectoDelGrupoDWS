package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class paginaAdministradoraControlador {

	// Mapea la ruta "/paginaAdministradora"
	@GetMapping("/paginaAdministradora")
	public ModelAndView paginaAdministradora() {
		return  new ModelAndView( "paginaAdministradora"); // Renderiza la página de administrador
	}

//	@GetMapping("/login/accederUsuario")
//	public
}
