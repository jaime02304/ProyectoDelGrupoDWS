package edu.ProyectoDelGrupoDWS2.Dtos;

/**
 * Clase donde se encuentra todos los atributes
 */
public class UsuariosCompletosDto {
	String nombreUsu = "aaaaa";
	String apellidoUsu = "aaaaa";
	boolean esAdmin = false;
	byte[] imagenUsu;
	String direccionUsu = "aaaaa";
	String alias = "aaaaa";

	public String getNombreUsuString() {
		return nombreUsu;
	}

	public void setNombreUsuString(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getApellidoUsuString() {
		return apellidoUsu;
	}

	public void setApellidoUsuString(String apellidoUsu) {
		this.apellidoUsu = apellidoUsu;
	}

	public boolean isEsAdmin() {
		return esAdmin;
	}

	public void setEsAdmin(boolean esAdmin) {
		this.esAdmin = esAdmin;
	}

	public byte[] getImagenUsu() {
		return imagenUsu;
	}

	public void setImagenUsu(byte[] imagenUsu) {
		this.imagenUsu = imagenUsu;
	}

	public String getDireccionUsu() {
		return direccionUsu;
	}

	public void setDireccionUsu(String direccionUsu) {
		this.direccionUsu = direccionUsu;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public UsuariosCompletosDto(String nombreUsu, String apellidoUsu, boolean esAdmin, byte[] imagenUsu,
			String direccionUsu, String alias) {
		super();
		this.nombreUsu = nombreUsu;
		this.apellidoUsu = apellidoUsu;
		this.esAdmin = esAdmin;
		this.imagenUsu = imagenUsu;
		this.direccionUsu = direccionUsu;
		this.alias = alias;
	}

	public UsuariosCompletosDto() {
		super();
	}

	
	
}
