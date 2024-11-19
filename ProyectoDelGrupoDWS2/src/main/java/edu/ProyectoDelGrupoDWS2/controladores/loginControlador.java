package edu.ProyectoDelGrupoDWS2.controladores;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
import edu.ProyectoDelGrupoDWS2.Servicios.loginImplementacion;
import edu.ProyectoDelGrupoDWS2.Servicios.loginInterfaz;

@RestController
@RequestMapping("/login")
public class loginControlador {

	loginInterfaz metodosLogin = new loginImplementacion();
	
	// Mapea la ruta "/login"
	public ModelAndView login() {
		return new ModelAndView("login"); // Renderiza la página de login
	}
	
	public ResponseEntity<?> metodoDeLoguearse(@ModelAttribute UsuariosDto usuarios){
		return metodoDeLoguearse(usuarios);
	}


}
