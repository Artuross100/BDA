/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Entidades.ProductoDonacion;
import java.util.ArrayList;

/**
 *
 * @author semillero
 */
public class pruebas {
    public static void main(String[] args) {
        Negocio negocio = new Negocio();
        ArrayList<String> productos = negocio.listarProductosDonacionPorDivision(1L);
        
        for (String producto : productos) {
            System.out.println(producto);
        }
    }
}
