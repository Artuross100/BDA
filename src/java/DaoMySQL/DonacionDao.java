package DaoMySQL;

import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DonacionDao implements Serializable{
    
    private Conexion conexion;
    
    public DonacionDao() throws SQLException{
        this.conexion = new Conexion();
    }
    
    public long insertarDonacion(long donante){
        long cons = 0;
        String consulta = "INSERT INTO Donacion (donante) VALUES (?)";
        String consulta2 ="SELECT (MAX(id)) AS id FROM Donacion";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            pst.setLong(1, donante);
            if(!pst.execute()){
                PreparedStatement pst2 = this.conexion.getConexion().prepareStatement(consulta2);
                ResultSet rs = pst2.executeQuery();
                if(rs.next()){
                    cons = rs.getLong(1);
                }
                rs.close();
                pst2.close();
            }
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return cons;
    }
}
