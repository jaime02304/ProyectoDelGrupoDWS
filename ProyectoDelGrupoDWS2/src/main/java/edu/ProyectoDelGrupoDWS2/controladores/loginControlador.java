package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
import edu.ProyectoDelGrupoDWS2.Servicios.loginImplementacion;

@RestController
public class loginControlador {

	@Autowired
	private loginImplementacion metodosLogin;

	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login"); // Renderiza la página de login
	}

	@PostMapping("/login/verificarElUsuario")
	public ModelAndView metodoDeLoguearse(@ModelAttribute UsuariosDto usuarios) {
		try {
			ModelAndView vista = metodosLogin.enviarDatosLogin(usuarios);
			return vista;
		} catch (Exception e) {
			return new ModelAndView("login");
		}
	}
}
