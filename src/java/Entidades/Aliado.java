package Entidades;

import java.io.Serializable;

public class Aliado implements Serializable{
    
    private long id;
    private String nombre;
    private String url;
    private String foto;

    public Aliado() {
    }

    public Aliado(String nombre, String url, String foto) {
        this.nombre = nombre;
        this.url = url;
        this.foto = foto;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
    
    
}
