package edu.ProyectoDelGrupoDWS2.Servicios;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;

import edu.ProyectoDelGrupoDWS2.Dtos.UsuariosDto;

/**
 * Aqui se encuentra la cabeceras de los metodos que tienen relacion con la
 * configuracion basca de la informacion en relacion al login
 * 
 * @author jpribio - 19/11/24
 */
public interface loginInterfaz {

	/**
	 * Metodo que manda el contenido hacia la API y recibe una rspuesta para esta misma llevarla al javascript y hacer lo necesario
	 * @author jpribio - 19/11/24
	 * @param Los datos del usuario en formato DTO
	 * @return Devuelve la respuesta
	 * @throws Exception
	 */
	public ResponseEntity<?> enviarDatosLogin(UsuariosDto usuario) throws Exception; 
}
