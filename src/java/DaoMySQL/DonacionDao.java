package DaoMySQL;

import Entidades.Donacion;
import Entidades.GrupoAlimentos;
import Entidades.Producto;
import Entidades.ProductoDonacion;
import Entidades.UnidadMedida;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DonacionDao implements Serializable {

    private Conexion conexion;

    public DonacionDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public long insertarDonacion(long donante) {
        long cons = 0;
        String consulta = "INSERT INTO Donacion (donante) VALUES (?)";
        String consulta2 = "SELECT (MAX(id)) AS id FROM Donacion";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            pst.setLong(1, donante);
            if (!pst.execute()) {
                PreparedStatement pst2 = this.conexion.getConexion().prepareStatement(consulta2);
                ResultSet rs = pst2.executeQuery();
                if (rs.next()) {
                    cons = rs.getLong(1);
                }
                rs.close();
                pst2.close();
            }
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cons;
    }

    public ArrayList<Donacion> listarDonaciones(long donante) {
        ArrayList<Donacion> usuarios = new ArrayList<>();
//        String consulta = "SELECT pd.donacion, pd.cantidadProducto, d.fecha "
//                + "FROM Donacion d, ProductoDonacion pd"
//                + "WHERE d.id=pd.donacion"
//                + "d.donante=donante "
//                + "ORDER BY d.fecha DESC";
        String consulta = "SELECT * FROM Donacion WHERE donante = ? "
                + "ORDER BY d.fecha DESC";
        PreparedStatement pst;
        ResultSet rs;
        ArrayList<Producto> pro;
        ArrayList<ProductoDonacion> p;
        Donacion u;

        try {
            pst = this.conexion.getConexion().prepareStatement(consulta);
            pst.setLong(1, donante);
            rs = pst.executeQuery();

            while (rs.next()) {
                pro = new ProductoDao().buscarProductoPorDonacion(rs.getLong("pd.donacion"));
                //p = new ProductoDonacion(pro, rs.getLong("pd.cantidadProducto"));
                u = new Donacion();
                u.setFecha(rs.getDate("fecha"));
                //u.setProductos(p);
            }

            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return usuarios;
    }
}
