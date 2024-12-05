package edu.ProyectoConjunto.edu.ProyectoConjunto.dtos;

/**
 * Clase donde se encuentra los atributos de los usuarios DTO completos
 * @author jpribio - 05/12/24
 */
public class usuarioDto {
     Long idUsuario;
 	String nombreUsu = "aaaaa";
 	String apellidoUsu = "aaaaa";
 	Boolean esAdmin = false;
 	byte[] imagenUsu;
 	String direccionUsu = "aaaaa";
 	String alias = "aaaaa";
 	String correoUsu = "aaaaa";
 	String contraseniaUsu = "aaaaa";
 	String dNIUsu = "aaaaa";
 	String clubPerteneciente = "aaaaa";
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
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
	public Boolean getEsAdmin() {
		return esAdmin;
	}
	public void setEsAdmin(Boolean esAdmin) {
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
	public usuarioDto(Long idUsuario, String nombreUsu, String apellidoUsu, Boolean esAdmin, byte[] imagenUsu,
			String direccionUsu, String alias, String correoUsu, String contraseniaUsu, String dNIUsu,
			String clubPerteneciente) {
		super();
		this.idUsuario = idUsuario;
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
	public usuarioDto() {
		super();
	}

	
}