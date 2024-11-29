package edu.ProyectoConjunto.edu.ProyectoConjunto.dtos;

public class clubDto {
	long idClub;
	String nombreClub;
	String correoClub;
	String contraseniaClub;
	String sedePrincipalClub;
	String localidadClub;
	private byte[] imagenClub; // Array de bytes para la imagen

    // Constructor
    public void ClubDto(long idClub, String nombreClub, String correoClub, String contraseniaClub,
                   String sedePrincipalClub, String localidadClub, byte[] imagenClub) {
        this.idClub = idClub;
        this.nombreClub = nombreClub;
        this.correoClub = correoClub;
        this.contraseniaClub = contraseniaClub;
        this.sedePrincipalClub = sedePrincipalClub;
        this.localidadClub = localidadClub;
        this.imagenClub = imagenClub;
    }

    // Getters y setters
    public long getIdClub() {
        return idClub;
    }

    public void setIdClub(long idClub) {
        this.idClub = idClub;
    }

    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
    }

    public String getCorreoClub() {
        return correoClub;
    }

    public void setCorreoClub(String correoClub) {
        this.correoClub = correoClub;
    }

    public String getContraseniaClub() {
        return contraseniaClub;
    }

    public void setContraseniaClub(String contraseniaClub) {
        this.contraseniaClub = contraseniaClub;
    }

    public String getSedePrincipalClub() {
        return sedePrincipalClub;
    }

    public void setSedePrincipalClub(String sedePrincipalClub) {
        this.sedePrincipalClub = sedePrincipalClub;
    }

    public String getLocalidadClub() {
        return localidadClub;
    }

    public void setLocalidadClub(String localidadClub) {
        this.localidadClub = localidadClub;
    }

    public byte[] getImagenClub() {
        return imagenClub;
    }

    public void setImagenClub(byte[] imagenClub) {
        this.imagenClub = imagenClub;
    }
}