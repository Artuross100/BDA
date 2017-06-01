package Entidades;

import java.io.Serializable;

public class TipoUsuario implements Serializable {

    private long id;
    private String descripcion;

    public TipoUsuario() {
    }

    public TipoUsuario(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
