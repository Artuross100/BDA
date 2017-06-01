package Entidades;

import java.io.Serializable;

public class Producto implements Serializable {

    private String codigo;
    private UnidadMedida unidad;
    private String nombre;
    private float peso;
    private float medida;
    private float precio;
    private GrupoAlimentos grupo;

    public Producto() {
    }

    public Producto(String codigo, String nombre, float peso, float medida, float precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.peso = peso;
        this.medida = medida;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public UnidadMedida getUnidad() {
        return unidad;
    }

    public void setUnidad(UnidadMedida unidad) {
        this.unidad = unidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getMedida() {
        return medida;
    }

    public void setMedida(float medida) {
        this.medida = medida;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public GrupoAlimentos getGrupo() {
        return grupo;
    }

    public void setGrupo(GrupoAlimentos grupo) {
        this.grupo = grupo;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", unidad=" + unidad + ", nombre=" + nombre + ", peso=" + peso + ", medida=" + medida + ", precio=" + precio + ", grupo=" + grupo + '}';
    }

}
