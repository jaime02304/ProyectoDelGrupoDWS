package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	loginImplementacion metodosLogin;

	@GetMapping("/")
	public ModelAndView login() {
		return new ModelAndView("login"); // Renderiza la página de login
	}

	@PostMapping("/enviarDatos")
	public ResponseEntity<?> metodoDeLoguearse(@ModelAttribute UsuariosDto usuarios) {
		try {
			ResponseEntity<?>respuestaEntity = metodosLogin.enviarDatosLogin(usuarios);
			return respuestaEntity;
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"success\": false, \"message\": \"Error De excepcion del login\"}");
		}
	}

}
