package DaoMySQL;

import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmpleadoDao implements Serializable{

    private final Conexion conexion;

    public EmpleadoDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean insertar(long id) {
        boolean b = false;
        String cosulta = "INSERT INTO Empleado (idUsuario) "
                + "VALUES (?)";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(cosulta);
            pst.setLong(1, id);
            b = pst.execute();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b;
    }
}
