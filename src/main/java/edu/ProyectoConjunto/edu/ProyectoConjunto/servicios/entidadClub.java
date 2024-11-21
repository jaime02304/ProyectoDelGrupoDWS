package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import java.util.List;

import edu.ProyectoConjunto.edu.ProyectoConjunto.dtos.usuarioDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * Entidad que representa la tabla Club. 	
 */
@Entity
@Table(name = "CLUB")
public class entidadClub {

    @Id
    private Long idClub;

    @Column(name = "nombreClub")
    private String nombreClub;

    @Column(name = "correoClub", unique = true, nullable = false)
    private String correoClub;

    @Column(name = "contraseniaClub")
    private String contraseniaClub;

    @Column(name = "sedePrincipalClub")
    private String sedePrincipalClub;

    @Column(name = "localidadClub")
    private String localidadClub;

    @Lob // Usado para almacenar tipos de datos grandes como imágenes
    @Column(name = "imagenClub")
    private byte[] imagenClub; // Imagen como array de bytes

    // Relación 1:N con Usuario
    //@OneToMany(mappedBy = "clubPerteneciente")  // "clubPerteneciente" es el nombre del campo en Usuario que tiene la relación
    //private List<entidadUsuario> usuarios;

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

    /*public List<entidadUsuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<entidadUsuario> usuarios) {
        this.usuarios = usuarios;
    }*/
}

