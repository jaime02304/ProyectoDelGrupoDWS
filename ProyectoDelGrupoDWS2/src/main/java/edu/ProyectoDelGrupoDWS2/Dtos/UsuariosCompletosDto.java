package edu.ProyectoDelGrupoDWS2.Dtos;

/**
 * Clase donde se encuentra todos los atributes
 * @author jpribio - 05/12/24
 */
public class UsuariosCompletosDto {
	String nombreUsu = "aaaaa";
	String apellidoUsu = "aaaaa";
	boolean esAdmin = false;
	byte[] imagenUsu;
	String direccionUsu = "aaaaa";
	String alias = "aaaaa";
	String correoUsu = "aaaaa";
	String contraseniaUsu = "aaaaa";
	String dNIUsu = "aaaaa";
	String clubPerteneciente = "aaaaa";

	public String getNombreUsu() {
		return nombreUsu;
	}

	public void setNombreUsu(String nombreUsu) {
		this.nombreUsu = nombreUsu;
	}

	public String getApellidoUsu() {
		return apellidoUsu;
	}

	public void setApellidoUsu(String apellidoUsu) {
		this.apellidoUsu = apellidoUsu;
	}

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

	public String getdNIUsu() {
		return dNIUsu;
	}

	public void setdNIUsu(String dNIUsu) {
		this.dNIUsu = dNIUsu;
	}

	public String getClubPerteneciente() {
		return clubPerteneciente;
	}

	public void setClubPerteneciente(String clubPerteneciente) {
		this.clubPerteneciente = clubPerteneciente;
	}

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

	public UsuariosCompletosDto(String nombreUsu, String apellidoUsu, boolean esAdmin, byte[] imagenUsu,
			String direccionUsu, String alias, String correoUsu, String contraseniaUsu, String dNIUsu,
			String clubPerteneciente) {
		super();
		this.nombreUsu = nombreUsu;
		this.apellidoUsu = apellidoUsu;
		this.esAdmin = esAdmin;
		this.imagenUsu = imagenUsu;
		this.direccionUsu = direccionUsu;
		this.alias = alias;
		this.correoUsu = correoUsu;
		this.contraseniaUsu = contraseniaUsu;
		this.dNIUsu = dNIUsu;
		this.clubPerteneciente = clubPerteneciente;
	}

	public UsuariosCompletosDto() {
		super();
	}

}
