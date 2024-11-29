package edu.ProyectoConjunto.edu.ProyectoConjunto.dtos;

public class ModificarClubDto {
    private String nombreClub;
    private String sedePrincipalClub;
    private String localidadClub;
    private byte[] imagenClub;

    // Getters y setters
    public String getNombreClub() {
        return nombreClub;
    }

    public void setNombreClub(String nombreClub) {
        this.nombreClub = nombreClub;
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
