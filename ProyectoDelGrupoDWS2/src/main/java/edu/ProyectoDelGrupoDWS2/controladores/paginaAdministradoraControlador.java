package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/paginaAdministradora")
public class paginaAdministradoraControlador {

	@GetMapping
	public ModelAndView paginaAdmin() {
		ModelAndView vista = new ModelAndView();
		vista.setViewName("parteAdministradora");
		return vista;
	}

}
