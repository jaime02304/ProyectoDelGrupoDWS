package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;


@RestController
public class indexControlador {

	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}
	
}
