package edu.ProyectoDelGrupoDWS2.Servicios;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosCompletosDto;
import edu.ProyectoDelGrupoDWS2.Util.utilidades;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 * Clase donde se encuentra los metodos de la parte administradora
 * 
 * @author jpribio - 28/11/24
 */
@Service
public class AdministracionImplementacion {

	/**
	 * Método público para recoger la información de los usuarios necesarios
	 * 
	 * @author jpribio - 28/11/24
	 */
	public ModelAndView recogidaDeDatos() throws Exception {
		ModelAndView vista = new ModelAndView();

		// Crear un cliente REST para acceder a la API
		Client cliente = ClientBuilder.newClient();
		String url = "http://localhost:8081/api/usuarios/obtenerTodosUsuarios";

		// Llamar a la API
		Response respuestaApi = cliente.target(url).request(jakarta.ws.rs.core.MediaType.APPLICATION_JSON).get();

		if (respuestaApi.getStatus() == 200) {

			// Esta es la parte de los ususarios
			List<UsuariosCompletosDto> usuListadoCompletosDtos = listadoUsuarios(respuestaApi);
			// Crear una lista solo con los alias
			List<String> aliasLista = new ArrayList<>();
			for (UsuariosCompletosDto usuario : usuListadoCompletosDtos) {
				aliasLista.add(usuario.getAlias()); // Extraer solo el alias de cada usuario
			}

			// Aquideberia de estar la parte de los clubes

			// Configurar la vista
			vista.setViewName("parteAdministrativa");
			// Agregar la lista de usuarios al modelo
			vista.addObject("listadoUsuarios", aliasLista);
		} else {
			// En caso de error, agregar mensaje de error
			vista.addObject("error", "No se ha encontrado ningun usuario, por un error de la web (Api)");
			vista.setViewName("parteAdministrativa");
		}
		return vista;
	}

	/**
	 * Método que pasa de usuarioDto a Json y lo envía a la API (para crear el
	 * usuario)
	 * 
	 * @author amd - 30/11/24
	 * @param usuario, un dto usuarioDto
	 * @throws Exception
	 */

	public void crearUsuario(UsuariosCompletosDto usuario) throws Exception {
		String API_URL = "http://localhost:8081/api/usuarios/alta";
		if (!validarEmail(usuario.getCorreoUsu())) {
			throw new Exception("Email no válido");
		}
		usuario.setContraseniaUsu(util.encriptarContrasenia(usuario.getContraseniaUsu()));
		//Crea un objeto mapeador
		ObjectMapper objetoMapeador = new ObjectMapper();
		//Cambia el usuario a un string en formato json
		String formatoJson = objetoMapeador.writeValueAsString(usuario);
		jakarta.ws.rs.client.Client cliente = ClientBuilder.newClient();
		Response respuestaApi = cliente.target(API_URL).request(MediaType.APPLICATION_JSON)
				.post(Entity.entity(formatoJson, MediaType.APPLICATION_JSON));
		if (respuestaApi.getStatus() != 201) {
			throw new Exception("Error al añadir el usuario: " + respuestaApi.getStatus());
		}

	}

	/*----------------------------------------------------------------------------------------------------------------------------------------------------------------------------*/
	// METODOS PRIVADOS

	private utilidades util = new utilidades();
	private Pattern emailPattern = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.(com|net|es|us)$"); // Patrón que debe seguir
																								// el email

	/**
	 * Método que verifica si coincide el patrón del email
	 * 
	 * @author amd - 30/11/24
	 * @param email
	 * @return devuelve un true-false si coincide o no
	 */
	private boolean validarEmail(String email) {

		return email != null && emailPattern.matcher(email).matches();

	}

	/**
	 * MEtodo privado que coge el texto plano en formato JSON y lo convierte a un
	 * Dto y lo mete en una lista
	 * 
	 * @author jpribio - 28/11/24
	 * @param LE paso la rerspuesta de la api que contiene todos los usuarios en
	 *           texto plano
	 * @return devuelvo la lista de esos datos pero con un formato DTO
	 * @throws Exception
	 */
	private List<UsuariosCompletosDto> listadoUsuarios(Response respuestaApi) throws Exception {
		// Leer el JSON recibido
		String jsonString = respuestaApi.readEntity(String.class);

		// Parsear el JSON recibido
		JSONArray usuariosArray = new JSONArray(jsonString); // El JSON raíz es un array

		// Crear lista de Usuarios
		List<UsuariosCompletosDto> usuarios = new ArrayList<>();

		// recorrer el ArraJSON para ir extrayendo los campos y añadirlo al
		// usuarioCompletoDto
		for (int i = 0; i < usuariosArray.length(); i++) {
			JSONObject jsonUsuario = usuariosArray.getJSONObject(i);

			// Extraer datos del JSON
			String nombre = jsonUsuario.getString("nombreUsu");
			String apellido = jsonUsuario.getString("apellidoUsu");
			boolean esAdmin = jsonUsuario.getBoolean("esAdmin");

			// Manejo del campo imagenUsu (null o vacío)
			String imagenBase64 = jsonUsuario.optString("imagenUsu", null);
			byte[] imagen = null;
			if (imagenBase64 != null && !imagenBase64.isEmpty()) {
				imagen = Base64.getDecoder().decode(imagenBase64);
			}

			String direccion = jsonUsuario.getString("direccionUsu");
			String alias = jsonUsuario.getString("alias");

			// Crear objeto Usuario y añadirlo a la lista
			UsuariosCompletosDto usuario = new UsuariosCompletosDto(nombre, apellido, esAdmin, imagen, direccion,
					alias);
			usuarios.add(usuario);
		}
		return usuarios;
	}
}
