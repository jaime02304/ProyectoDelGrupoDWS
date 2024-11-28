package edu.ProyectoConjunto.edu.ProyectoConjunto.dtos;

public class UsuarioConAliasDto {
    private String alias;
    private String nombreUsuario;   // nombre_usuario
    private String apellidoUsuario; // apellido_usuario
    private Boolean esAdmin;        // esAdmin
    byte[] imagenUsuario; // Imagen como array de bytes
    private String direccion;       // direccion

    // Getters y setters
    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
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
}




