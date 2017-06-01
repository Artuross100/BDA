package Entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Carpeta implements Serializable {

    private long id;
    private String descripcion;
    private String icono;
    private ArrayList<Pagina> paginas;

    public Carpeta() {
    }

    public Carpeta(long id, String descripcion, String icono) {
        this.id = id;
        this.descripcion = descripcion;
        this.icono = icono;
    }

    public Carpeta(long id, String descripcion) {
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

    public String getIcono() {
        return icono;
    }

    public void setIcono(String icono) {
        this.icono = icono;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carpeta other = (Carpeta) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

}
