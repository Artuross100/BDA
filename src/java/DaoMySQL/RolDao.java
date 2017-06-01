package DaoMySQL;

import Entidades.Rol;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RolDao implements Serializable{
    
    private Conexion conexion;
    
    public RolDao() throws SQLException{
        this.conexion = new Conexion();
    }
    
    public boolean registrar(String nombre) {
        String consulta = "INSERT INTO Rol (descripcion) VALUES(?)";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setString(1, nombre);
            int x = stmt.executeUpdate();
            stmt.close();
            this.conexion.close();
            if(x==1){
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }
    
    public ArrayList<Rol> cargar() {
        ArrayList<Rol> tipos = new ArrayList<Rol>();
        String consulta = "SELECT id, descripcion FROM Rol";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            Rol t;
            while (rs.next()) {
                t = new Rol();
                t.setId(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
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
