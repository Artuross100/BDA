package DaoMySQL;

import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductoDonacionDao implements Serializable {

    private Conexion conexion;

    public ProductoDonacionDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean insertarProductosDonacion(String con) {
        String consulta = "INSERT INTO ProductoDonacion (donacion, producto, cantidadProducto) VALUES " + con;
        boolean b=false;
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            b= pst.execute();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b;
    }
}
