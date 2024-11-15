package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * Clase donde se encuentra la representación del objeto usuario
 */
@Entity
@Table(name = "USUARIOS")
public class entidadUsuario {

    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;

    @Column(name = "nombreUsuario")
    private String nombreUsuario;

    @Column(name = "apellidoUsuario")
    private String apellidoUsuario;

    @Column(name = "correoUsuario", unique = true, nullable = false)
    private String correoUsuario;

    @Column(name = "contraseniaUsuario")
    private String contraseniaUsuario;

    @Column(name = "dniUsuario", unique = true)
    private String dniUsuario;

    @Column(name = "esAdmin")
    private Boolean esAdmin;

    @Lob // Usado para tipos grandes como imágenes
    @Column(name = "imagenUsuario")
    private byte[] imagenUsuario; // Imagen como array de bytes
    
    @Column(name = "Direccion")
    private String direccion;

    @Column(name = "Alias")
    private String alias;

    // Relación ManyToOne con Club
    @ManyToOne
    @JoinColumn(name = "club_id", nullable = false)
    private entidadClub clubPerteneciente;

    // Constructor vacío (requerido por JPA)
    public entidadUsuario() {}

    // Constructor con todos los atributos (opcional)
    public entidadUsuario(Long idUsuario, String nombreUsuario, String apellidoUsuario, 
                   String correoUsuario, String contraseniaUsuario, String dniUsuario, 
                   Boolean esAdmin, byte[] imagenUsuario, String direccion, 
                   String alias, entidadClub clubPerteneciente) {
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
        //this.clubPerteneciente = clubPerteneciente;
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

    public entidadClub getClubPerteneciente() {
        return clubPerteneciente;
    }

    public void setClubPerteneciente(entidadClub clubPerteneciente) {
        this.clubPerteneciente = clubPerteneciente;
    }
}
