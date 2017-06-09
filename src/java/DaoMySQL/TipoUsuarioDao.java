package DaoMySQL;

import Entidades.TipoUsuario;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TipoUsuarioDao implements Serializable{
    
    private Conexion conexion;
    
    public TipoUsuarioDao() throws SQLException{
        this.conexion = new Conexion();
    }
    
    public boolean registrar(String nombre) {
        String consulta = "INSERT INTO TipoUsuario (descripcion) VALUES(?)";
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
    
    public ArrayList<TipoUsuario> cargar() {
        ArrayList<TipoUsuario> tipos = new ArrayList<TipoUsuario>();
        String consulta = "SELECT id, descripcion FROM TipoUsuario";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            TipoUsuario t;
            while (rs.next()) {
                t = new TipoUsuario();
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
    
    public TipoUsuario buscarTipoUsuario(long id) {
        String consulta = "SELECT id, descripcion FROM TipoUsuario "
                + "WHERE id=?";
        TipoUsuario t = null;
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            pst.setLong(1, id);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                t = new TipoUsuario();
                t.setId(rs.getInt(1));
                t.setDescripcion(rs.getString(2));
            }
            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }

        return t;
    }
}
