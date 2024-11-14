package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Column;
import java.util.List;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;

/**
 * Entidad que representa la tabla Club. 	
 */
@Entity
public class entidadClub {

    @Id
    private Long idClub;

    @Column(name = "nombre_club")
    private String nombreClub;

    @Column(name = "correo_club", unique = true, nullable = false)
    private String correoClub;

    @Column(name = "contrasenia_club")
    private String contraseniaClub;

    @Column(name = "sede_principal_club")
    private String sedePrincipalClub;

    @Column(name = "localidad_club")
    private String localidadClub;

    @Lob // Usado para almacenar tipos de datos grandes como imágenes
    @Column(name = "imagen_club")
    private byte[] imagenClub; // Imagen como array de bytes

    // Relación 1:N con Usuario
    @OneToMany(mappedBy = "clubPerteneciente")  // "clubPerteneciente" es el nombre del campo en Usuario que tiene la relación
    private List<usuarioDto> usuarios;

    // Constructor vacío (requerido por JPA)
    public entidadClub() {}

    // Constructor con todos los atributos
    public entidadClub(Long idClub, String nombreClub, String correoClub, String contraseniaClub, 
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
    public Long getIdClub() {
        return idClub;
    }

    public void setIdClub(Long idClub) {
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

    public List<usuarioDto> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<usuarioDto> usuarios) {
        this.usuarios = usuarios;
    }
}

