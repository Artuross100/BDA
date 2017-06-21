package Negocio;

import java.io.Serializable;

public class DatosBanco implements Serializable{
    
    static String telefono = "No hay telefono registrado";
    static String direccion = "No hay dirección registrada";
    static String representante = "No hay un representante asignado";
    static String ciudad = "No hay una ciudad asignada";
    static String correo = "No hay un correo registrado";
    static String nombreBanco = "No hay un nombre asignado en este momento";
    static long visitas;

    public static String getTelefono() {
        return telefono;
    }

    public static void setTelefono(String telefono) {
        DatosBanco.telefono = telefono;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static void setDireccion(String direccion) {
        DatosBanco.direccion = direccion;
    }

    public static String getRepresentante() {
        return representante;
    }

    public static void setRepresentante(String representante) {
        DatosBanco.representante = representante;
    }

    public static String getCiudad() {
        return ciudad;
    }

    public static void setCiudad(String ciudad) {
        DatosBanco.ciudad = ciudad;
    }

    public static String getCorreo() {
        return correo;
    }

    public static void setCorreo(String correo) {
        DatosBanco.correo = correo;
    }

    public static String getNombreBanco() {
        return nombreBanco;
    }

    public static void setNombreBanco(String nombreBanco) {
        DatosBanco.nombreBanco = nombreBanco;
    }

    public static long getVisitas() {
        return visitas;
    }

    public static void setVisitas() {
        DatosBanco.visitas ++;
    }

    
    
}
