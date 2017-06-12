package Entidades;

import DaoMySQL.DonanteDao;
import DaoMySQL.ProductoDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BDA {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Bodega> bodegas;
    private ArrayList<Carpeta> carpetas;
    private Donacion donacion;

    public BDA() {
        this.donacion = new Donacion();
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public ArrayList<Bodega> getBodegas() {
        return bodegas;
    }

    public void setBodegas(ArrayList<Bodega> bodegas) {
        this.bodegas = bodegas;
    }

    public ArrayList<Carpeta> getCarpetas() {
        return carpetas;
    }

    public void setCarpetas(ArrayList<Carpeta> carpetas) {
        this.carpetas = carpetas;
    }

    public Donacion getDonacion() {
        return donacion;
    }

    public void setDonacion(Donacion donacion) {
        this.donacion = donacion;
    }

    public Bodega buscarBodega(long id) {
        for (Bodega b : this.bodegas) {
            System.out.println(id + " - " + b.getId());
            if (b.getId() == id) {
                return b;
            }
            System.out.println(id + " - " + b.getId());
        }
        return null;
    }

    public boolean agregarProducto(long codP, long cantidad) {
        try {
            Producto p = new ProductoDao().buscarProducto(codP);
            if (p != null) {
                return this.donacion.insertarProducto(new ProductoDonacion(p, cantidad));
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean registrarDonacion(long idDonante){
        try {
            Donante d = new DonanteDao().bucarDonante(idDonante);
            if(d!=null){
                this.donacion.setDonante(d);
                this.donacion = new Donacion();
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
}
