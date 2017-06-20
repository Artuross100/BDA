package Entidades;

import java.io.Serializable;

public class GrupoAlimentos implements Serializable{
 
    private long id;
    private String descripcion;

    public GrupoAlimentos() {
    }

    public GrupoAlimentos(String descripcion) {
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
