package DaoMySQL;

import Entidades.Genero;
import Entidades.GrupoAlimentos;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GrupoAlimentosDao implements Serializable {

    private Conexion conexion;

    public GrupoAlimentosDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean registrar(String nombre) {
        String consulta = "INSERT INTO GrupoAlimentos (descripcion) VALUES(?)";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setString(1, nombre);
            int x = stmt.executeUpdate();
            stmt.close();
            this.conexion.close();
            if (x == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
        return false;
    }

    public ArrayList<GrupoAlimentos> cargar() {
        ArrayList<GrupoAlimentos> tipos = new ArrayList<GrupoAlimentos>();
        String consulta = "SELECT id, descripcion FROM GrupoAlimentos";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = stmt.executeQuery();
            GrupoAlimentos t;
            while (rs.next()) {
                t = new GrupoAlimentos();
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

    public GrupoAlimentos buscarGrupoAlimentosPorId(long idGrupo){
        String consulta;
        PreparedStatement state;
        ResultSet rs;
        GrupoAlimentos grupo = null;
        
        try{
            consulta = "SELECT * FROM ";
            state = this.conexion.getConexion().prepareStatement(consulta);
            state.setLong(1, idGrupo);
            
            rs = state.executeQuery();
            while(rs.next()){
                grupo = new GrupoAlimentos(rs.getString("descripcion"));
                grupo.setId(idGrupo);
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
        return grupo;
    }
}
