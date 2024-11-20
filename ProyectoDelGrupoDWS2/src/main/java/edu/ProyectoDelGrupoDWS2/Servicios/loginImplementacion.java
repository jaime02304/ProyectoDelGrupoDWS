package edu.ProyectoDelGrupoDWS2.Servicios;

import java.util.regex.Pattern;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;
import edu.ProyectoDelGrupoDWS2.Util.utilidades;

@Service
public class loginImplementacion{

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

	public ResponseEntity<?> enviarDatosLogin(UsuariosDto usuario) throws Exception {

		if (!validarEmail(usuario.getCorreoUsu())) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("{\"success\": false, \"message\": \"Formato del email invalido\"}");

		}
		// Encriptar la contraseña antes de enviar
		usuario.setContraseniaUsu(util.encriptarContrasenia(usuario.getContraseniaUsu()));

		// Serializar la lista de usuarios a JSON
		ObjectMapper objetoMapper = new ObjectMapper();
		String usuariosJson = objetoMapper.writeValueAsString(usuario);

		// Configurar encabezados HTTP
		HttpHeaders encabezado = new HttpHeaders();
		encabezado.setContentType(MediaType.APPLICATION_JSON);

		// Crear entidad HTTP (cuerpo + encabezados)
		HttpEntity<String> solicitudEntidad = new HttpEntity<>(usuariosJson, encabezado);

		// Crear instancia de RestTemplate
		RestTemplate manejosRespuestaRestTemplate = new RestTemplate();

		// Enviar solicitud POST y recibir respuesta
		ResponseEntity<String> respuestaApi = manejosRespuestaRestTemplate.exchange("http://localhost:8080/AplicacioPrueba/usuarios/enviarDatos", HttpMethod.POST, solicitudEntidad,
				String.class);

		return devolverRespuestaFrontMetodoPrivado(respuestaApi);

	}

	/**
	 * Metodo privado para separar y limpiar el codigo, devuelve la respuesta para
	 * la parte vista
	 * 
	 * @author jpribio - 19/11/24
	 * @param Respuesta de la API
	 * @return devuelve una respuesta para la parte vista
	 */
	private ResponseEntity<?> devolverRespuestaFrontMetodoPrivado(ResponseEntity<String> respuestaApi) {

		// Procesar la respuesta de la API externa
		if (respuestaApi.getStatusCode() == HttpStatus.OK) {
			String cuerpoRespuesta = respuestaApi.getBody();

			// Verificar si la respuesta contiene el campo "success" como true
			if (cuerpoRespuesta != null && cuerpoRespuesta.contains("\"success\": true")) {
				// Aquí asumimos que la API devuelve un campo "isAdmin" indicando si el usuario
				// es admin
				boolean isAdmin = cuerpoRespuesta.contains("\"isAdmin\": true");

				// Devolver la respuesta a frontend con el estado del usuario
				if (isAdmin) {
					return ResponseEntity.ok("{\"success\": true, \"isAdmin\": true}");
				} else {
					return ResponseEntity.ok("{\"success\": true, \"isAdmin\": false}");
				}
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
						.body("{\"success\": false, \"message\": \"Credenciales invalidas\"}");
			}
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("{\"success\": false, \"message\": \"Error con la API externa\"}");
		}
	}
}
