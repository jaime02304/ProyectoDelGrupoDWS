package edu.ProyectoDelGrupoDWS2.Dtos;

/**
 * Clase donde se encuentra los atributos de los usuarios para el login
 * @author jpribio - 19/11/24
 */
public class UsuariosDto {


	private String correoUsu = "aaaaa";
	private String contraseniaUsu = "aaaaa";
	private boolean esAdmin=false;

	
	public String getCorreoUsu() {
		return correoUsu;
	}
	public void setCorreoUsu(String correoUsu) {
		this.correoUsu = correoUsu;
	}
	public String getContraseniaUsu() {
		return contraseniaUsu;
	}
	public void setContraseniaUsu(String contraseniaUsu) {
		this.contraseniaUsu = contraseniaUsu;
	}
	public boolean EsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}
	
	

}
