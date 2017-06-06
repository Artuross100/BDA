package Entidades;

import java.util.ArrayList;

public class BDA {
    
    private ArrayList<Usuario> usuarios;
    private ArrayList<Bodega> bodegas;
    private ArrayList<Carpeta> carpetas;
    
    public BDA(){}

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
    
    public Bodega buscarBodega(long id){
        for(Bodega b:this.bodegas){
            System.out.println(id+" - "+b.getId());
            if(b.getId()==id){
                return b;
            }
            System.out.println(id+" - "+b.getId());
        }
        return null;
    }
    
}
