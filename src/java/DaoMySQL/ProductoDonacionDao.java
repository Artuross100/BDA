package DaoMySQL;

import Entidades.Producto;
import Entidades.ProductoDonacion;
import Entidades.UnidadMedida;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductoDonacionDao implements Serializable {

    private Conexion conexion;

    public ProductoDonacionDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean insertarProductosDonacion(String con) {
        String consulta = "INSERT INTO ProductoDonacion (donacion, producto, cantidadProducto, conforme) VALUES " + con;
        boolean b = false;
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            b = pst.execute();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b;
    }

    public ArrayList<ProductoDonacion> listarProductoDonadosSinAlmacenar() {
        String consulta = "SELECT p.nombre, p.medida, u.descripcion, "
                + "d.cantidadProducto, d.conforme, p.codigo, "
                + "FROM Producto p, ProductoDonacion d, UnidadMedida u, Donacion do, Donante dn "
                + "WHERE p.codigo=d.producto AND d.producto "
                + "NOT IN (SELECT a.productoDonacion "
                + "FROM Almacenamiento a where a.codDonacion=d.donacion "
                + "AND d.producto=a.productoDonacion AND d.conforme=a.cantidadAlmacenada)";
        ArrayList<ProductoDonacion> productos = new ArrayList<ProductoDonacion>();
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            ProductoDonacion pd = null;
            Producto p = null;
            UnidadMedida u = null;
            while(rs.next()){
                p = new Producto();
                pd = new ProductoDonacion();
                u = new UnidadMedida();
                p.setCodigo(rs.getString(6));
                p.setNombre(rs.getString(1));
                u.setDescripcion(rs.getString(3));
                p.setMedida(rs.getLong(2));
                pd.setCantidad(rs.getLong(4));
                pd.setConforme(rs.getLong(5));
                p.setUnidad(u);
                pd.setProducto(p);
                productos.add(pd);
            }
            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return productos;
    }
}
