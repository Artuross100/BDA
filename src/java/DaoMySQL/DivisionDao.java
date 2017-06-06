package DaoMySQL;

import Entidades.Division;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
    
    public ArrayList<Division> cargar( long idBodega) {
        ArrayList<Division> tipos = new ArrayList<Division>();
        String consulta = "SELECT id, descripcion, comentarios "
                + "FROM Division "
                + "WHERE idBodega=?";
        try {
            PreparedStatement stmt = this.conexion.getConexion().prepareStatement(consulta);
            stmt.setLong(1, idBodega);
            ResultSet rs = stmt.executeQuery();
            Division t;
            while (rs.next()) {
                t = new Division();
                t.setIde(rs.getLong(1));
                t.setId(rs.getString(2).charAt(0));
                t.setComentarios(rs.getString(3));
                tipos.add(t);
            }
            rs.close();
            stmt.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        System.out.println("Cantidad = "+tipos.size());
        return tipos;
    }
}
