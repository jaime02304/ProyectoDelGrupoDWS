package edu.ProyectoConjunto.edu.ProyectoConjunto.servicios;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;

/**
 * Clase donde se encuentra la representación del objeto usuario
 */
@Entity
public class entidadUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(name = "nombre_usuario")
    private String nombreUsuario;

    @Column(name = "apellido_usuario")
    private String apellidoUsuario;

    @Column(name = "correo_usuario", unique = true, nullable = false)
    private String correoUsuario;

    @Column(name = "contrasenia_usuario")
    private String contraseniaUsuario;

    @Column(name = "dni_usuario", unique = true)
    private String dniUsuario;

    @Column(name = "es_admin")
    private Boolean esAdmin;

    @Lob // Usado para tipos grandes como imágenes
    @Column(name = "imagen_usuario")
    private byte[] imagenUsuario; // Imagen como array de bytes

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "alias")
    private String alias;

    // Relación ManyToOne con Club
    @ManyToOne
    @Column(name = "id_club_perteneciente") // El campo que se guarda en la tabla Usuario como FK
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

    public entidadClub getClubPerteneciente() {
        return clubPerteneciente;
    }

    public void setClubPerteneciente(entidadClub clubPerteneciente) {
        this.clubPerteneciente = clubPerteneciente;
    }
}
