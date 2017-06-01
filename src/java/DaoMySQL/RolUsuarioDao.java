package DaoMySQL;

import Util.Conexion;
import java.io.Serializable;
import java.sql.SQLException;

public class RolUsuarioDao implements Serializable{

    private Conexion conexion;
    
    public RolUsuarioDao() throws SQLException {
        this.conexion = new Conexion();
    }
    
}
