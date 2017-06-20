package Entidades;

import java.io.Serializable;

public class UnidadMedida implements Serializable{
    
    private long id;
    private String descripcion;

    public UnidadMedida() {
    }
       public UnidadMedida(String des) {
           this.descripcion=des;
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

    @Override
    public String toString() {
        return descripcion;
    }
}
