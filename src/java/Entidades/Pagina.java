package Entidades;

import java.io.Serializable;

public class Pagina implements Serializable {

    private long id;
    private String ruta;
    private String titulo;
    private long idCarpeta;

    public Pagina() {
    }

    public Pagina(long id, long carpeta, String ruta, String titulo) {
        this.id = id;
        this.idCarpeta = carpeta;
        this.ruta = ruta;
        this.titulo = titulo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Pagina other = (Pagina) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public long getIdCarpeta() {
        return idCarpeta;
    }

    public void setIdCarpeta(long idCarpeta) {
        this.idCarpeta = idCarpeta;
    }

}
