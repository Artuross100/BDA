package Entidades;

import java.io.Serializable;
import java.util.Date;

public class TipoIdentificacion implements Serializable {
    private static final long serialVersionUID = 1L;
    private long id;
    private String descripcion;
    private Date fecha;

    public TipoIdentificacion() {
    }

    public TipoIdentificacion(long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public TipoIdentificacion(Integer id) {
        this.id = id;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final TipoIdentificacion other = (TipoIdentificacion) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

   
    @Override
    public String toString() {
        return "Entidades.TipoIdentificacion[ id=" + id + " ]";
    }
    
}
