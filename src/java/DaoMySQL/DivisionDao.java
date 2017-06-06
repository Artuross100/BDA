package DaoMySQL;

import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DivisionDao implements Serializable {

    private Conexion conexion;
    
    public DivisionDao() throws SQLException{
        this.conexion = new Conexion();
    }
    
    public boolean insertar(long bodega, String datos){
        boolean b = false;
        String consulta = "INSERT INTO Division (idBodega, descripcion)"
                + "VALUES "+datos;
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
}
