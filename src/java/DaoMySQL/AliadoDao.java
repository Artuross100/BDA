package DaoMySQL;

import Entidades.Aliado;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    public ArrayList<Aliado> listarAliados(){
        ArrayList<Aliado> aliados = new ArrayList<Aliado>();
        String consulta = "SELECT id, nombre, url, foto FROM Aliado";
        PreparedStatement pst;
        try {
            pst = this.conexion.getConexion().prepareStatement(consulta);
            ResultSet rs = pst.executeQuery();
            Aliado al = null;
            while(rs.next()){
                al = new Aliado();
                al.setId(rs.getLong(1));
                al.setNombre(rs.getString(2));
                al.setUrl(rs.getString(3));
                al.setFoto(rs.getString(4));
                aliados.add(al);
            }
            rs.close();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AliadoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return aliados;
    }
}
