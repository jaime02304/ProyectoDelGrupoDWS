package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
import edu.ProyectoDelGrupoDWS2.Servicios.loginImplementacion;
import jakarta.servlet.http.HttpSession;

/**
 * Clase controladora de la parte login
 *  @author jpribio - 28/11/24
 */
@Controller
@RequestMapping("/login")
public class loginControlador {

	@Autowired
	private loginImplementacion metodosLogin;

	/**
	 * metodo que devuelve la vista de la pagina login
	 * @author jpribio - 28/11/24
	 * @return
	 */
	@GetMapping
	public ModelAndView login() {
		ModelAndView vista = new ModelAndView("login");
		return vista;
	}

	/**
	 * Metodo post que envia los atributos del login al mtodo de enviar datos en la implementacion del login
	 *  @author jpribio - 28/11/24
	 * @param usuarios (Atributos del usuario del login)
	 * @return ModelAndView
	 */
	@PostMapping
	public ModelAndView metodoDeLoguearse(@ModelAttribute UsuariosDto usuarios, HttpSession sesionIniciada,Model modelo) {
		ModelAndView vista = new ModelAndView("login");
		try {
			return metodosLogin.enviarDatosLogin(usuarios,sesionIniciada,modelo);
		} catch (Exception e) {
			vista.addObject("error", "Error al iniciar sesión.");
			vista.addObject("esAdmin", true);
			vista.addObject("succes",true);
			return vista;
		}
	}
}
