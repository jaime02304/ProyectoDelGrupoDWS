package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
import edu.ProyectoDelGrupoDWS2.Servicios.loginImplementacion;

@RestController
@RequestMapping("/login")
public class loginControlador {

	@Autowired
	private loginImplementacion metodosLogin;

	@GetMapping
	public ModelAndView login() {
		ModelAndView vista = new ModelAndView("/login");
		return vista;
	}

	@PostMapping
	public ModelAndView metodoDeLoguearse(@ModelAttribute UsuariosDto usuarios) {
		ModelAndView vista = new ModelAndView("/login");
		try {
			return metodosLogin.enviarDatosLogin(usuarios);
		} catch (Exception e) {
			vista.addObject("error", "Error al iniciar sesión.");
			return vista;
		}
	}
}
