
package Entidades;

import java.io.Serializable;

public class Almacenamiento implements Serializable{
    
    private Division division;
    private ProductoDonacion producto;
    private long cantidadAlmacenar;
    private long donacion;

    public Almacenamiento(Division division, ProductoDonacion producto, long cantidadAlmacenar) {
        this.division = division;
        this.producto = producto;
        this.cantidadAlmacenar = cantidadAlmacenar;
    }

    public Almacenamiento() {
    }

    public long getDonacion() {
        return donacion;
    }

    public void setDonacion(long donacion) {
        this.donacion = donacion;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public ProductoDonacion getProducto() {
        return producto;
    }

    public void setProducto(ProductoDonacion producto) {
        this.producto = producto;
    }

    public long getCantidadAlmacenar() {
        return cantidadAlmacenar;
    }

    public void setCantidadAlmacenar(long cantidadAlmacenar) {
        this.cantidadAlmacenar = cantidadAlmacenar;
    }
    
    
}
