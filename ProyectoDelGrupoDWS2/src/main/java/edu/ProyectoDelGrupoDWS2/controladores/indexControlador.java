package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

/**
 * Clase principal (controlador) donde se encuentra los metodos de la pagina
 * login
 * 
 * @author jpribio - 28/11/24
 */
@Controller
@RequestMapping("/")
public class indexControlador {

	@GetMapping
	public ModelAndView index(HttpSession sessionIniciada) {
		Boolean isAdmin = (Boolean) sessionIniciada.getAttribute("isAdmin");
		Boolean afirmacion = (Boolean) sessionIniciada.getAttribute("afirmacion");
		ModelAndView vista = new ModelAndView();
		vista.addObject("esAdmin", isAdmin);
		vista.addObject("afirmacion", afirmacion);
		vista.setViewName("index");
		return vista;
	}
/**
 * Metodo que te cierra la sesion del usuario
 * @author jpribio - 05/12/24
 * @param sesionCerrada la sesion
 * @return devuelve la vista nueva del index modificada
 */
	@GetMapping("/cerrarSesion")
	public ModelAndView cerrarSession(HttpSession sesionCerrada) {
		sesionCerrada.invalidate();
		ModelAndView vista = new ModelAndView();
		vista.setViewName("index");
		return vista;
	}

}
