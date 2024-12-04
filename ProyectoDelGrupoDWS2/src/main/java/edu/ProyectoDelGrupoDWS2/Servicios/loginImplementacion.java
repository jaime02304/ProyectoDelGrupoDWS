package edu.ProyectoDelGrupoDWS2.Servicios;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
import edu.ProyectoDelGrupoDWS2.Util.utilidades;
import jakarta.servlet.http.HttpSession;
import jakarta.ws.rs.client.ClientBuilder;

/**
 * Clase que implementa los metodos en relacion al login
 * 
 * @author jpribio - 26/11/24
 */
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

	/**
	 * Metodod que envia los datos del login hacia la api y recibe una respuesta
	 * 
	 * @param usuario (los datos del login)
	 * @return devuelve un modelAndView para cambiar de pagina y coger los objetos
	 *         imprescindible
	 * @throws Exception
	 */
	public ModelAndView enviarDatosLogin(UsuariosDto usuario, Model modelo, HttpSession sessionIniciada)
			throws Exception {
		ModelAndView vista = new ModelAndView();

		// Validación del correo electrónico
		if (!validarEmail(usuario.getCorreoUsu())) {
			System.out.println("Correo electrónico inválido.");
			vista.setViewName("login");
			return vista; // Aseguramos el retorno
		}

		// Encriptar contraseña
		usuario.setContraseniaUsu(util.encriptarContrasenia(usuario.getContraseniaUsu()));

		// Configuración de la solicitud API
		jakarta.ws.rs.client.Client cliente = ClientBuilder.newClient();
		String url = "http://localhost:8081/api/ProyectoDWS/verificarUsuario?correoUsuario=" + usuario.getCorreoUsu()
				+ "&contraseniaUsuario=" + usuario.getContraseniaUsu();

		jakarta.ws.rs.core.Response respuestaApi = cliente.target(url)
				.request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get();

		// Log de la respuesta
		System.out.println("Respuesta de la API: " + respuestaApi.getStatus());

		if (respuestaApi.getStatus() == 200) {
			// Mapear la respuesta al objeto UsuariosDto
			try {
				UsuariosDto respuestaCuerpoApi = respuestaApi.readEntity(UsuariosDto.class);

				// Validar si es admin
				boolean esAdmin = respuestaCuerpoApi.EsAdmin();
				sessionIniciada.setAttribute("esAdmin", esAdmin);
				sessionIniciada.setAttribute("afirmacion", true);
				vista.setViewName("index");


			} catch (Exception e) {
				System.err.println("Error al procesar la respuesta de la API: " + e.getMessage());
				sessionIniciada.setAttribute("esAdmin", false);
				sessionIniciada.setAttribute("afirmacion", false);
				vista.setViewName("login");

				modelo.addAttribute("error", "Usuario o contraseña incorrectos");
			}
		} else {
			System.err.println("Error en la solicitud: Código " + respuestaApi.getStatus());
			sessionIniciada.setAttribute("esAdmin", false);
			sessionIniciada.setAttribute("afirmacion", false);
			vista.setViewName("login");
			}

		// Retorno garantizado en todas las rutas de ejecución
		return vista;
	}

}
