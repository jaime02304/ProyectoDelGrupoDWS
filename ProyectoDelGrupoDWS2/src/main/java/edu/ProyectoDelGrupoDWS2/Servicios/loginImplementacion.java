package edu.ProyectoDelGrupoDWS2.Servicios;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
import edu.ProyectoDelGrupoDWS2.Util.utilidades;
import jakarta.ws.rs.client.ClientBuilder;

@Service
public class loginImplementacion {

	private utilidades util = new utilidades();

	// representa un patrón de expresión regular para luego compararla
	private Pattern email1 = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.(com|net|es)$");

	/**
	 * Metodo privado que valida el email correctamente
	 * 
	 * @author jpribio - 19/11/24
	 * @param correo electronico introducido por el usuario
	 * @return devuelve el email validado
	 */
	private boolean validarEmail(String email) {
		if (email == null) {
			return false;
		}
		return email1.matcher(email).matches();
	}

	public ModelAndView enviarDatosLogin(UsuariosDto usuario) throws Exception {

		if (!validarEmail(usuario.getCorreoUsu())) {
			System.out.println("Error al validar la contraseña");
		}

		usuario.setContraseniaUsu(util.encriptarContrasenia(usuario.getContraseniaUsu()));

		ObjectMapper objetoMapeador = new ObjectMapper();
		String formatoJson = objetoMapeador.writeValueAsString(usuario);

		jakarta.ws.rs.client.Client cliente = ClientBuilder.newClient();

		jakarta.ws.rs.core.Response respuestaApi = cliente
				.target("http://localhost:8081/api/ProyectoDWS/verificarUsuario?correoUsuario="
						+ usuario.getCorreoUsu() + "&contraseniaUsuario=" + usuario.getContraseniaUsu())
				.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get();

		System.out.println(respuestaApi.getStatus());
		if (respuestaApi.getStatus() == 200) {

			UsuariosDto respuestaCuerpoApi = respuestaApi.readEntity(UsuariosDto.class);

			if (respuestaCuerpoApi.EsAdmin()) {
				return new ModelAndView("index");
			} else {
				return new ModelAndView("index");
			}
		} else {
			return new ModelAndView("login");
		}
	}

}
