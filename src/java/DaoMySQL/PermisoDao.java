package DaoMySQL;

import Util.Conexion;
import java.io.Serializable;
import java.sql.SQLException;

public class PermisoDao implements Serializable{
    
    private Conexion conexion;
    
    public PermisoDao() throws SQLException{
        this.conexion = new Conexion();
    }
}
