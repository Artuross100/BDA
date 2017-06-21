package Entidades;

import java.util.Objects;

public class ProductoDonacion {
    
    private Producto producto;
    private long cantidad;
    private String comentarios;
    private long conforme;
    private long donacion;

    public ProductoDonacion() {
    }

    public ProductoDonacion(Producto producto, long cantidad, long conforme) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.conforme = conforme;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public long getConforme() {
        return conforme;
    }

    public void setConforme(long conforme) {
        this.conforme = conforme;
    }

    public long getDonacion() {
        return donacion;
    }

    public void setDonacion(long donacion) {
        this.donacion = donacion;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.producto);
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
        final ProductoDonacion other = (ProductoDonacion) obj;
        return this.producto.equals(other);
    }

    @Override
    public String toString() {
        return producto + "," + cantidad + ","  + conforme + "," + donacion;
    }
}
