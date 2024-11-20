package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class erroresControlador implements org.springframework.boot.web.servlet.error.ErrorController {

	@RequestMapping("/error")
	public ModelAndView handleError() {
		// Puedes agregar un mensaje personalizado o redirigir a una página específica
		return new ModelAndView("login"); // Redirige a una vista 'error.html' (debe existir en tu carpeta de templates)
	}

	public ModelAndView getErrorPath() {
		return new ModelAndView("login");
	}
}
