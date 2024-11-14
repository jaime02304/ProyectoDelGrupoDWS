package edu.ProyectoConjunto.edu.ProyectoConjunto.dtos;

public class usuarioDto {
     long idUsuario;
     String nombreUsuario;
     String apellidoUsuario;
     String correoUsuario;
     String contraseniaUsuario;
     String dniUsuario;
     Boolean esAdmin;
     byte[] imagenUsuario; // Imagen como array de bytes
     String direccion;
     String alias;
     String clubPerteneciente;

    // Constructor
    public usuarioDto(Long idUsuario, String nombreUsuario, String apellidoUsuario, String correoUsuario, 
                      String contraseniaUsuario, String dniUsuario, Boolean esAdmin, byte[] imagenUsuario, 
                      String direccion, String alias, String clubPerteneciente) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.correoUsuario = correoUsuario;
        this.contraseniaUsuario = contraseniaUsuario;
        this.dniUsuario = dniUsuario;
        this.esAdmin = esAdmin;
        this.imagenUsuario = imagenUsuario;
        this.direccion = direccion;
        this.alias = alias;
        this.clubPerteneciente = clubPerteneciente;
    }

    // Getters y setters
    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public String getDniUsuario() {
        return dniUsuario;
    }

    public void setDniUsuario(String dniUsuario) {
        this.dniUsuario = dniUsuario;
    }

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public byte[] getImagenUsuario() {
        return imagenUsuario;
    }

    public void setImagenUsuario(byte[] imagenUsuario) {
        this.imagenUsuario = imagenUsuario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getClubPerteneciente() {
        return clubPerteneciente;
    }

    public void setClubPerteneciente(String clubPerteneciente) {
        this.clubPerteneciente = clubPerteneciente;
    }
}
