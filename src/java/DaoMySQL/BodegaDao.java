package DaoMySQL;

import Entidades.Bodega;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BodegaDao implements Serializable {

    private Conexion conexion;

    public BodegaDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public long insertar(String descripcion) {
        long id = 0;
        String cosulta = "INSERT INTO Bodega (descripcion) "
                + "VALUES (?)";
        String cosulta2 = "SELECT (MAX(id)) AS id FROM Bodega";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(cosulta);
            pst.setString(1, descripcion);
            if (!pst.execute()) {
                PreparedStatement pst2 = this.conexion.getConexion().prepareStatement(cosulta2);
                ResultSet rs = pst2.executeQuery();
                if (rs.next()) {
                    id = rs.getLong("id");
                }
                pst2.close();
            }
            pst.close();

            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return id;
    }

    public ArrayList<Bodega> cargar() {
        ArrayList<Bodega> tipos = new ArrayList<Bodega>();
        String consulta = "SELECT id, descripcion "
                + "FROM Bodega";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            Bodega t;
            while (rs.next()) {
                t = new Bodega();
                t.setId(rs.getLong(1));
                t.setNombre(rs.getString(2));
                tipos.add(t);
            }
            rs.close();
            stmt.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return tipos;
    }
}
