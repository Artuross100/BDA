package DaoMySQL;

import Entidades.Aliado;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AliadoDao implements Serializable {

    private Conexion conexion;

    public AliadoDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean registrarAliado(Aliado a) {
        String consulta = "INSERT INTO Aliado (nombre, url, foto) VALUES (?,?,?)";
        boolean b = true;
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            pst.setString(1, a.getNombre());
            pst.setString(2, a.getUrl());
            pst.setString(3, a.getFoto());
            b = pst.execute();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return b;
    }
}
