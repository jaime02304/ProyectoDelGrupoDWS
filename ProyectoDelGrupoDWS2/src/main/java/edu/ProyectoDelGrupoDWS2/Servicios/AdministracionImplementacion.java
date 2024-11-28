package edu.ProyectoDelGrupoDWS2.Servicios;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosCompletosDto;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.Response;

/**
 * Clase donde se encuentra los metodos de la parte administradora
 * 
 * @author jpribio - 28/11/24
 */
@Service
public class AdministracionImplementacion {
	// Respuesta de la API
	// public List<UsuariosCompletosDto> respuestaCuerpoApi = new
	// ArrayList<UsuariosCompletosDto>();

	/**
	 * Método público para recoger la información de los usuarios necesarios
	 * 
	 * @author jpribio - 28/11/24
	 */
	public ModelAndView recogifaDeUsuarios() throws Exception {
		ModelAndView vista = new ModelAndView();

		// Crear un cliente REST para acceder a la API
		Client cliente = ClientBuilder.newClient();
		String url = "http://192.168.30.150:8081/api/usuarios/obtenerTodosUsuarios";

		// Llamar a la API
		Response respuestaApi = cliente.target(url).request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get();

		if (respuestaApi.getStatus() == 200) {
		UsuariosCompletosDto usus = listadoUsuarios(respuestaApi);
		List<UsuariosCompletosDto> usuListadoCompletosDtos = new ArrayList<UsuariosCompletosDto>();
		usuListadoCompletosDtos.add(usus);
		// Agregar la lista de usuarios al modelo
			vista.addObject("listadoUsuarios", usuListadoCompletosDtos);

			// Configurar la vista
			vista.setViewName("parteAdministrativa");
		} else {
			// En caso de error, agregar mensaje de error
			vista.addObject("error", "No se ha encontrado ningun usuario");
			vista.setViewName("parteAdministrativa");
		}
		return vista;
	}

	private UsuariosCompletosDto listadoUsuarios(Response respuestaApi) throws Exception {
		JSONObject jsonRespuesta = new JSONObject(respuestaApi);
		String base64String = jsonRespuesta.getString("imagenUsu"); // Recuperar como String
		byte[] byteArray = base64String.getBytes();
		UsuariosCompletosDto usuarioCompletado = new UsuariosCompletosDto(
				jsonRespuesta.getString("nombreUsu"),
				jsonRespuesta.getString("apellidoUsu"),
				jsonRespuesta.getBoolean("esAdmin"), 
				byteArray,
				jsonRespuesta.getString("direccionUsu"),
				jsonRespuesta.getString("alias"));
		return usuarioCompletado;
	}
}
