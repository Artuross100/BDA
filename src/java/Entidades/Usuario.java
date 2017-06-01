package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Usuario implements Serializable{
    
    private long id;
    private TipoIdentificacion identificacion;
    private TipoUsuario tipoUsuario;
    private TipoPersona tipoPersona;
    private ArrayList<Rol> rol;
    private String usuario;
    private String contra;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String telefonos;
    private Date fechaNacimiento;
    private String numeroDocumento;

    public Usuario() {
    }

    public Usuario(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public TipoIdentificacion getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(TipoIdentificacion identificacion) {
        this.identificacion = identificacion;
    }

    public TipoUsuario getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(TipoUsuario tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public TipoPersona getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(TipoPersona tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public ArrayList<Rol> getRol() {
        return rol;
    }

    public void setRol(ArrayList<Rol> rol) {
        this.rol = rol;
    }
    
    
}
