package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ProyectoDelGrupoDWS2.Servicios.AdministracionImplementacion;
import jakarta.servlet.http.HttpSession;

/**
 * Clase de la pagina administradora que hace de controlador de la misma pagina
 * 
 * @author jpribio - 28/11/24
 */
@Controller
@RequestMapping("/paginaAdministradora")
public class paginaAdministradoraControlador {

	private AdministracionImplementacion implementacionLogin;

	public paginaAdministradoraControlador(AdministracionImplementacion implementacionLogin) {
		super();
		this.implementacionLogin = implementacionLogin;
	}

	/**
	 * metodo que devuelve la vista de la pagina administradora
	 * 
	 * @author jpribio - 28/11/24
	 * @return
	 */
	@GetMapping
	public ModelAndView paginaAdmin(HttpSession sessionIniciada) {
		Boolean isAdmin = (Boolean) sessionIniciada.getAttribute("isAdmin");
		Boolean afirmacion = (Boolean) sessionIniciada.getAttribute("afirmacion");
		ModelAndView vista = new ModelAndView();
		vista.addObject("esAdmin", isAdmin);
		vista.addObject("afirmacion", afirmacion);
		vista.setViewName("parteAdministrativa");
		return vista;
	}

	@GetMapping("/recogerUsuarios")
	public ModelAndView recogerLosUsuarios() {
		ModelAndView vista = new ModelAndView();
		try {
			return implementacionLogin.recogidaDeDatos();

		} catch (Exception e) {
			vista.addObject("error", "No se ha encontrado ningun usuario, por un error en la web");
			vista.setViewName("parteAdministrativa");
			return vista;
		}
	}

}
