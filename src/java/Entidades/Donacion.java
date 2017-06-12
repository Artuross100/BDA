package Entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Donacion implements Serializable {

    private Donante donante;
    private ArrayList<ProductoDonacion> productos;
    private Date fecha;

    public Donacion() {
        this.productos = new ArrayList<ProductoDonacion>();
    }

    public Donacion(Donante donante) {
        this.donante = donante;
        this.productos = new ArrayList<ProductoDonacion>();
    }

    public Donante getDonante() {
        return donante;
    }

    public void setDonante(Donante donante) {
        this.donante = donante;
    }

    public ArrayList<ProductoDonacion> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<ProductoDonacion> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean insertarProducto(ProductoDonacion p) {
        if (!buscarProducto(p)) {
            this.recorrer();
            return this.productos.add(p);
        }
        return false;
    }

    private boolean buscarProducto(ProductoDonacion p) {
        for (ProductoDonacion pd : this.productos) {
            if (pd.getProducto().getCodigo().equals(p.getProducto().getCodigo())) {
                return true;
            }
        }
        return false;
    }
    
    private void recorrer() {
        for (ProductoDonacion pd : this.productos) {
            System.out.println(pd.getProducto().getNombre()+" - - "+pd.getCantidad());
        }
        System.out.println("----------------------------------------------------------------------------------------");
    }

}
