package DaoMySQL;

import Entidades.Almacenamiento;
import Util.Conexion;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlmacenamientoDao implements Serializable{

    private Conexion conexion;

    public AlmacenamientoDao() throws SQLException {
        this.conexion = new Conexion();
    }

    public boolean almacenar(Almacenamiento a){
        boolean b = false;
        String consulta = "INSERT INTO Almacenamiento (division, codDonacion, productoDonacion, cantidadAlmacenada) "
                + "VALUES (?,?,?,?)";
        try {
            PreparedStatement pst = this.conexion.getConexion().prepareStatement(consulta);
            pst.setLong(1, a.getDivision().getIde());
            pst.setLong(2, a.getDonacion());
            pst.setString(3, a.getProducto().getProducto().getCodigo());
            pst.setLong(4, a.getCantidadAlmacenar());
            System.out.println(consulta);
            b= pst.execute();
            pst.close();
            this.conexion.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlmacenamientoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return b;
    }
}
