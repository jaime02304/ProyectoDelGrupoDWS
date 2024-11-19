package edu.ProyectoDelGrupoDWS2.controladores;

import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;

@RestController
public class loginControlador {

	// Mapea la ruta "/login"
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("login"); // Renderiza la página de login
	}

	@PostMapping("/login/accederUsuario")
	public Response postMethodName(@ModelAttribute UsuariosDto usuario) throws Exception {

		return Response;
	}

}
