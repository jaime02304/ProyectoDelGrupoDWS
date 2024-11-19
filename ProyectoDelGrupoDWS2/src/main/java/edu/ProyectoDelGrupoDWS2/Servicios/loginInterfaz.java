package edu.ProyectoDelGrupoDWS2.Servicios;

/**
 * Aqui se encuentra la cabeceras de los metodos que tienen relacion con la
 * configuracion basca de la informacion en relacion al login
 * 
 * @author jpribio - 19/11/24
 */
public interface loginInterfaz {

	/**
	 * Metodo que devuelve verdadero si se ha verificcado el correo electronico bien
	 * 
	 * @author jpribio - 19/11/24
	 * @param el correo electronico
	 * @return devuelve verdadero si esta validado bien y false si esta mal
	 */
	public boolean validarEmail(String email);
}
