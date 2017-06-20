package Entidades;

import DaoMySQL.DonacionDao;
import DaoMySQL.DonanteDao;
import DaoMySQL.ProductoDao;
import DaoMySQL.ProductoDonacionDao;
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

    public boolean agregarProducto(long codP, long cantidad, long conforme) {
        try {
            Producto p = new ProductoDao().buscarProducto(codP);
            if (p != null) {
                return this.donacion.insertarProducto(new ProductoDonacion(p, cantidad, conforme));
            } else {
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public boolean registrarDonacion(long idDonante) {
        try {
            String aux = "";
            Donante d = new DonanteDao().bucarDonante(idDonante);
            if (d != null) {
                this.donacion.setDonante(d);
                long don = new DonacionDao().insertarDonacion(idDonante);
                if (don > 0) {
                    ArrayList<ProductoDonacion> apd = this.donacion.getProductos();
                    for (int i = 0; i < apd.size(); i++) {
                        aux += "(" + don + ",'" + apd.get(i).getProducto().getCodigo() + "'," + apd.get(i).getCantidad() + "," + apd.get(i).getConforme() + ")";
                        if (i + 1 != apd.size()) {
                            aux += ",";
                        }
                    }
                    if (new ProductoDonacionDao().insertarProductosDonacion(aux)) {
                        System.out.println("No");

                    } else {
                        System.out.println("Si");
                        this.donacion = new Donacion();
                        return true;
                    }
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

}
