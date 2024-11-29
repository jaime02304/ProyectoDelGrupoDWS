package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
import jakarta.servlet.http.HttpSession;

/**
 * Clase principal (controlador) donde se encuentra los metodos de la pagina login
 * @author jpribio - 28/11/24
 */
@Controller
@RequestMapping("/")
public class indexControlador {
	/**
	 * metodo que devuelve la vista de la pagina principal
	 * @author jpribio - 28/11/24
	 * @return
	 */
//	@GetMapping
//	public ModelAndView index(HttpSession sesionIniciada) {
//		ModelAndView  vista = new ModelAndView();
//   String loginCorreo = (String) sesionIniciada.getAttribute("correo");
//		vista.addObject("succes", true);
//		vista.setViewName("index");
//		System.out.println(vista);
//		return vista;
//	}

}
