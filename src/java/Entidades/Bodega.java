
package Entidades;

import java.io.Serializable;
import java.util.ArrayList;

public class Bodega implements Serializable{
    
    private long id;
    private String nombre;
    private ArrayList<Division> divisiones;

    public Bodega() {
    }

    public Bodega(long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    public ArrayList<Division> getDivisiones() {
        return divisiones;
    }

    public void setDivisiones(ArrayList<Division> divisiones) {
        this.divisiones = divisiones;
    }
    
    
}
